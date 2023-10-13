package com.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("memberajax")
public class MemberAJAXController {
	
	@GetMapping("main")
	public String main() {
		System.out.println("memberajax/main");

		return "memberajax/main";
		
	}
	
	@GetMapping("memberList")
	public String memberList() {
		System.out.println("memberajax/memberList");

		return "memberajax/memberList";
		
	}
	
	
}
