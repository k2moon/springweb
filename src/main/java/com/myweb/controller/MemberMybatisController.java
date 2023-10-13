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
public class MemberMybatisController{
	
	String view;
	
	@Autowired
	@Qualifier("memberMybatisServiceImpl")
	IMemberService service;
	
	@RequestMapping("main")
	public String main() {
		System.out.println("main");		
		
		view = "membermybatis/main";
		
		return view;				
	}		
	
	@RequestMapping(value = "memberList", method = {RequestMethod.GET, RequestMethod.POST})
	public String memberList(Model model) {
		System.out.println("memberList");
		
		List<MemberDTO> list = service.getMemberList();		
		model.addAttribute("list", list);
		
		view = "membermybatis/memberList";
		
		return view;		
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("join - get");
		
		view = "membermybatis/join";
		
		return view;		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinAction(MemberDTO dto, RedirectAttributes ra) {
		System.out.println("join - post");
		
		int rs = service.insert(dto);		
		ra.addFlashAttribute("rs", rs);
		view = "redirect:login";		
		
		return view;		
	}	
	
	// v4.3 이후
	@GetMapping("login")
	public String login() {
		System.out.println("login - get");
		
		view = "membermybatis/login";		
		
		return view;		
	}
	
	@PostMapping(value = "login")
	public String loginAction(MemberDTO dto, HttpSession session) {
		System.out.println("login - post - logindto");
		
		view = "membermybatis/login";
		String id = dto.getId();
		String pw = dto.getPw();		
		
		dto = service.getMember(dto);
		
		if (dto != null) {
			if (dto.getPw().equals(pw)) {
				
				session.setAttribute("id", id);
				session.setAttribute("name", dto.getName());
				
				view = "redirect:main";
			}
		}
		
		return view;		
	}
	
	
	@GetMapping("update")
	public String update(Model model, HttpSession session) {
		System.out.println("update - get");
		
		String id = (String)session.getAttribute("id");

		MemberDTO dto = new MemberDTO();
		dto.setId(id);

		model.addAttribute("dto", service.getMember(dto));
		
		view = "membermybatis/update";		
		
		return view;		
	}
	
	@PostMapping("update")
	public String updateAction(MemberDTO dto, HttpSession session) {
		System.out.println("update - post");
		System.out.println(dto);
		
		String id = (String)session.getAttribute("id");
		dto.setId(id);
		service.update(dto);
		
		session.setAttribute("name", dto.getName());
		
		view = "redirect:update";
		
		return view;
	}
	
	@GetMapping("delete")	
	public String delete() {		
		System.out.println("delete - get");
		
		view = "membermybatis/delete";
		
		return view;		
		
	}
	
	@PostMapping("delete")
	public String deleteAction(MemberDTO dto, HttpSession session) {
		System.out.println("delete - post");
		
		String id = (String)session.getAttribute("id");
		String pw = dto.getPw();
		dto.setId(id);		
		
		dto = service.getMember(dto);
		
		if (dto != null) {
			if (dto.getPw().equals(pw)) {
				
				service.delete(dto);				
				session.invalidate();
				
				view = "rediret:main";
			}
		}
		
		return view;		
	}
		
	@GetMapping("logout")	
	public String logout(HttpSession session) {		
		System.out.println("logout - get");
		
		session.invalidate();
		
		view = "redirect:main";
		
		return view;		
		
	}	


}
