package com.korea.db;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

@Controller
public class DeptController {

	//jsp실행경로
	public static final String VIEW_PATH="/WEB-INF/views/dept/"; 
	
	DeptDAO dept_dao;
	
	public DeptController(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
	}
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		//dao로부터 부서 목록을 요청한다.
		
		List<DeptVO> list = dept_dao.selectList();
	
		//바인딩
		model.addAttribute("list",list);
		
		//포워딩
		return VIEW_PATH + "dept_list.jsp";
	
	}
	
}
