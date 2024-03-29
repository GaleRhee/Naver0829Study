package mycar.controller;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;
import mycar.repository.MyCarDao;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
public class MyCarController {
	
	private final MyCarDao myCarDao;
	private final MyCarCommentDao commentDao;
	
	//storage class 선언
	private final NcpObjectStorageService storageService;
		
	//버킷 네임 지정
	private String bucketName="bitcamp-jir";
		
	//저장할 폴더 네임 지정
	private String folderName="bootmyshop";
		
	/*
	 * @GetMapping("/") public String list(Model model) { //전체 개수 Long
	 * totalCount=myCarDao.getTotalCount();
	 * 
	 * //전체 목록 가져오기 List<MyCarDto> list=myCarDao.getAllCars();
	 * 
	 * model.addAttribute("totalCount", totalCount); model.addAttribute("list",
	 * list); return "mycar/mycarlist"; }
	 */
	
	int pageSize;
	
	@GetMapping("/")
	public String list(Model model,@RequestParam(value="more",defaultValue="0") int more)
	{
		//more 가 0이면 기본 3 개만 출력
		//0 이 아니면 기본 사이즈에 more 값 추가해서 목록 가져오기
		if(more==0)
			pageSize=3;
		else
			pageSize+=more;
		//페이징 처리를 위한 클래스
		Pageable pageable=PageRequest.of(0, pageSize,Sort.by("num").ascending());
		
		//페이지에 필요한만큼만 가져오기
		Page<MyCarDto> result=myCarDao.getAllCars(pageable);
		List<MyCarDto> list=result.getContent();
		for(MyCarDto dto:list)
		{
			//댓글 개수 저장
			int acount=commentDao.getMyCarCommentList(dto.getNum()).size();
			dto.setCommentcount(acount);
		}
		
		model.addAttribute("totalCount", result.getTotalElements());
		model.addAttribute("totalPage", result.getTotalPages());
		model.addAttribute("list", result.getContent());
		model.addAttribute("pageSize", pageSize);
		
		return "mycar/mycarlist";
	}
	
	@GetMapping("/addcar")
	public String addform()
	{
		return "mycar/mycarform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MyCarDto dto,@RequestParam("upload") MultipartFile upload)
	{
		//이미지를 스토리지에 저장 후 저장된 파일명 변환
		String carphoto=storageService.uploadFile(bucketName, folderName, upload);
		//dto 에 사진 파일명 저장
		dto.setCarphoto(carphoto);
		//db insert
		myCarDao.insertMyCar(dto);
		
		return "redirect:./"; //목록으로 이동
	}
	
	@GetMapping("/detail")
	public String detail(Model model,@RequestParam("num") Long num)
	{
		MyCarDto dto=myCarDao.getData(num);
		model.addAttribute("dto",dto);
		return "mycar/mycardetail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("num") Long num)
	{
		//db 삭제 전에 스토리지의 기존 사진부터 삭제
		//사진 이름 얻기
		String carphoto=myCarDao.getData(num).getCarphoto();
		//스토리지 사진 삭제
		storageService.deleteFile(bucketName, folderName, carphoto);
		
		//db 삭제
		myCarDao.deleteMyCar(num);
		//목록으로 이동
		return "redirect:./";
	}
	
	@GetMapping("/carupdate")
	public String updateForm(Model model,@RequestParam("num") Long num)
	{
		//num 에 해당하는 dto
		MyCarDto dto=myCarDao.getData(num);
		
		model.addAttribute("dto",dto);
		return "mycar/mycarupdateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MyCarDto dto,@RequestParam("upload") MultipartFile upload)
	{
		if(upload.getOriginalFilename().equals("")) {
			//폼에서 사진을 선택 안한 경우
			myCarDao.updateMycarNoPhoto(dto);
		}else {
			//사진 수정 전에 기존 사진 먼저 삭제하기
			String carphoto=myCarDao.getData(dto.getNum()).getCarphoto();
			storageService.deleteFile(bucketName, folderName, carphoto);
			
			//새로 업데이트한 사진 스토리지에 저장
			String newCarphoto=storageService.uploadFile(bucketName, folderName, upload);
			
			//dto 에 사진명 수정
			dto.setCarphoto(newCarphoto);
			
			//db 수정
			myCarDao.updateMyCar(dto);
		}
		
		//상세 보기 페이지로 이동
		return "redirect:./detail?num="+dto.getNum();
	}
}
