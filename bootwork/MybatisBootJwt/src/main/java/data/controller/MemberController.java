package data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

	private final MemberService memberService;
	
	//스토리지 변수
	private final NcpObjectStorageService storageService;
	
	//비밀번호 암호화를 위한 변수 선언
	private final PasswordEncoder passwordEncoder;
	
	private String bucketName="bitcamp-jir";
	private String folderName="reactboot";
	
	//업로드한 파일명
	private String uploadFileName;
	
	@GetMapping("/member/list")
	public Map<String, Object> list()
	{
		Map<String, Object> map=new HashMap<>();
		int totalCount=memberService.getTotalCount();
		List<MemberDto> mlist=memberService.getAllMembers();
		
		map.put("totalCount", totalCount);
		map.put("mlist", mlist);
		return map;
	}
	
	//가입 시 먼저 사진 저장
	@PostMapping("/member/upload")
	public String uploadFile(@RequestParam("upload") MultipartFile upload)
	{
		uploadFileName=storageService.uploadFile(bucketName, folderName, upload);
		return uploadFileName;
	}
	
	@PostMapping("/member/insert")
	public String insert(@RequestBody MemberDto dto)
	{
		//pass 는 암호화 해서 db 에 저장
		String pass=dto.getPass();
		String pass1=passwordEncoder.encode(pass);
		System.out.println("비밀번호 암호화 : "+pass1);
		
		//dto 의 pass  를 암호화된 pass 로 변경
		dto.setPass(pass1);
		//업로드된 사진
		dto.setPhoto(uploadFileName);
		
		memberService.insertMember(dto);
		uploadFileName=null;
		return "success";
	}
	
	//아이디가 db 에 존재하면 1, 존재하지 않을 경우 0 이 반환
	@GetMapping("/member/idcheck")
	public int idcheck(@RequestParam("myid") String myid)
	{
		return memberService.getIdCheck(myid);
	}
	
	@DeleteMapping("/member/delete")
	public void delete(@RequestParam("num") int num)
	{
		//db 삭제 전에 스토리지의 사진부터 먼저 삭제
		String dbPhotoname=memberService.getMember(num).getPhoto();
		storageService.deleteFile(bucketName, folderName, dbPhotoname);
		
		//db 삭제
		memberService.deleteMember(num);
	}
}
