package com.korea.fileupload;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileUploadController {

	@Autowired //자동주입 어노테이션
	ServletContext application;
	//servletContext, session, request
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	
	static final String VIEW_PATH = "/WEB-INF/views/";
	
	@RequestMapping(value= {"/", "/insert_form.do"})
	public String insert_form() {
		return VIEW_PATH + "insert_form.jsp";
	}
	
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo) {
		
		String webPath = "/resources/upload/";
		
		String savePath =application.getRealPath(webPath);
		System.out.println(savePath);
		//업로드된 파일 정보
		MultipartFile photo = vo.getPhoto();
		String filename = "no_file";
		
		if(!photo.isEmpty()) {
			//업로드될 실제 파일 명
			filename = photo.getOriginalFilename();
			//파일을 저장할 경로
			File saveFile = new File(savePath, filename);
			
			//savePath경로까지가서 filename이라고 하는게 있나 확인
			
			if(!saveFile.exists()) {
				saveFile.mkdirs();
			}else {
				//자바가 만들어진 1970년부터 현재까지의 시간을 1000분의 1초로 저장
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time,filename);
				saveFile = new File(savePath, filename);
			}
			
			try {//실제로 파일을 업로드 하는코드
				photo.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		vo.setFilename(filename);
		request.setAttribute("vo", vo);
		
		return VIEW_PATH + "input_result.jsp";
		
	}
	
	
	
	
	
	
	
	
}
