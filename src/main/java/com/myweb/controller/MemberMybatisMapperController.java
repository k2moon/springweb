package com.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.dto.MemberDTO;
import com.myweb.service.IMemberService;


@Controller
@RequestMapping("membermybatis")
public class MemberMybatisMapperController{
	
	String view;
	
	@Autowired
	@Qualifier("memberMybatisMapperServiceImpl")
	IMemberService service;
	
		
	@GetMapping("main-mapper")
	public String mainInteface() {
		System.out.println("main-mapper");		
		
		view = "membermybatis/main-mapper";
		
		return view;				
	}
		
	
	@GetMapping("memberList-mapper")
	public String memberList(Model model) {
		System.out.println("memberList-mapper");
		
		List<MemberDTO> list = service.getMemberList();		
		model.addAttribute("list", list);
		
		view = "membermybatis/memberList-mapper";
		
		return view;		
		
	}
		


}
