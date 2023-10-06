package com.myweb.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.dto.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public String home() {	
		
		return "index";
	}
	
	@RequestMapping(value = "request", method = RequestMethod.GET)
	public String request() {
		System.out.println("request");
		
		return "test/request";
		
	}
	
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(@RequestParam String id) {
		System.out.println("getRequst");
		System.out.println("id : " + id);
		
		
		return "test/request";		
	}
	
	@GetMapping("get2")
	public String get2(@RequestParam("id2") String id) {
		System.out.println("getRequst2");
		System.out.println("id : " + id);
		
		
		return "test/request";		
	}
	
	@RequestMapping(value = "postDTO", method = RequestMethod.POST)
	public String post(MemberDTO dto) {
		System.out.println("postDTO");
		System.out.println("id : " + dto.getId());
		System.out.println("pw : " + dto.getPw());
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("index");
		
		return "test/request";	
		
	}
	
	@PostMapping("postMap")
	public String postMap(@RequestParam Map<String, String> map) {
		System.out.println("postMap");
		System.out.println("id : " + map.get("id"));
		System.out.println("pw : " + map.get("pw"));
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("index");
		
		return "test/request";	
		
	}
	
	@PostMapping("postList")
	public String postList(@RequestParam("id") List<String> ids) {
		System.out.println("postList");
		System.out.println("ids : " + ids);
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("index");
		
		return "test/request";	
		
	}
	
	@PostMapping(value = "postSM")
	public String postSM(MemberDTO dto, Model model) {
		System.out.println("postSM");
		System.out.println("id : " + dto.getId());
		System.out.println("pw : " + dto.getPw());
		
		model.addAttribute("dto",dto);
		
			
		return "test/response";	
		
	}
	
	@PostMapping(value = "postMAV")
	public ModelAndView postMAV(MemberDTO dto) {
		System.out.println("postMAV");
		System.out.println("id : " + dto.getId());
		System.out.println("pw : " + dto.getPw());
		
		ModelAndView mav = new ModelAndView();		
		
		mav.addObject("dto",dto);
		mav.setViewName("test/response");
		
		return mav;
		
	}
	
	@GetMapping("response")
	public String response() {
		System.out.println("response");
		
		
		return "test/response";		
	}
	
	
	
}
