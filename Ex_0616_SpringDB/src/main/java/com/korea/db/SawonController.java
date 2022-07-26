package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.SawonDAO;
import vo.SawonVO;

@Controller
public class SawonController {

	//jsp실행경로
		public static final String VIEW_PATH="/WEB-INF/views/sawon/"; 
		
		SawonDAO sawon_dao;
		
		public SawonController(SawonDAO sawon_dao) {
			this.sawon_dao = sawon_dao;
		}
		
		@RequestMapping(value = {"/", "/list.do"})
		public String list(Model model) {
			//dao로부터 부서 목록을 요청한다.
			
			List<SawonVO> list = sawon_dao.selectList();
		
			//바인딩
			model.addAttribute("list",list);
			
			//포워딩
			return VIEW_PATH + "sawon_list.jsp";
		
		}
	
	
}
