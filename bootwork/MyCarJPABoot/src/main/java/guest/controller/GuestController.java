package guest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import guest.data.GuestDao;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
public class GuestController {
	
	//storage class 선언
	private final NcpObjectStorageService storageService;
	
	//dao
	private final GuestDao guestDao;
	
	//업로드한 파일명 저장
	String photo;
			
	//버킷 네임 지정
	private String bucketName="bitcamp-jir";
			
	//저장할 폴더 네임 지정
	private String folderName="bootmyshop";
	
	//사진만 먼저 업로드하기
	@PostMapping("/guest/upload")
	public String uploadFile(@RequestParam("upload") MultipartFile upload)
	{
		System.out.println("upload:"+upload.getOriginalFilename());
		photo=storageService.uploadFile(bucketName, folderName, upload);
		return photo;
	}

}
