package com.myweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myweb.dto.MemberDTO;
import com.myweb.service.IMemberService;


@Controller
@RequestMapping("member")
public class MemberController{
	
	String view;
	
	@Autowired
	IMemberService service;
	
	@RequestMapping("main")
	public ModelAndView main() {
		System.out.println("main");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/main");
		return mav;
		
	}
	
	
	
	@RequestMapping(value = "memberList", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView memberList() {
		System.out.println("memberList");
		
		List<MemberDTO> list = service.getMemberList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", list);
		
		view = "member/memberList";
		mav.setViewName(view);
		
		return mav;
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public ModelAndView join() {
		System.out.println("join - get");
		
		ModelAndView mav = new ModelAndView();
		
		view = "member/join";
		mav.setViewName(view);
		
		return mav;		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public ModelAndView joinAction(MemberDTO dto) {
		System.out.println("join - post");
		
		int rs = service.insert(dto);
		
		ModelAndView mav = new ModelAndView();
		
		view = "redirect:login";		
		mav.setViewName(view );
		
		return mav;
		
	}	
	
	// v4.3 이후
	@GetMapping("login")
	public ModelAndView login() {
		System.out.println("login - get");
		
		ModelAndView mav = new ModelAndView();
		
		view = "member/login";		
		mav.setViewName(view);
		
		return mav;		
	}
	
	@PostMapping(value = "login")
	public ModelAndView loginAction(MemberDTO dto, HttpSession session) {
		System.out.println("login - post - loginDTO");
		
		String view = "member/login";
		String id = dto.getId();
		String pw = dto.getPw();
		
		
		dto = service.getMember(dto);
		
		if (dto != null) {
			if (dto.getPw().equals(pw)) {
				
				session.setAttribute("id", id);
				session.setAttribute("name", dto.getName());
				
				view = "member/main";
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(view);
		return mav;		
	}
	
	
	@RequestMapping(value = "loginReq", method = RequestMethod.POST)
	public ModelAndView loginReq(HttpServletRequest request) {
		System.out.println("login - post - loginReq");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;		
	}
	
	@RequestMapping(value = "loginMap", method = RequestMethod.POST)
	public ModelAndView loginMap(@RequestParam Map<String, String> request) {
		System.out.println("login - post - loginMap");
		
		String id = request.get("id");
		String pw = request.get("pw");
		
		System.out.println(id);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		return mav;		
	}
	
	
	
	/*	
	protected void requestMapping(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController - requestMapping");
		
		IMemberService service = new MemberServiceImpl();
		HttpSession session = request.getSession();
		String view = "";
		
		if(action.equals("/main.go")) {
			System.out.println("/main.go");
			
			view = "main.jsp";
			viewResolver(view, request, response);
			
		}else if(action.equals("/memberList.go")) {
			System.out.println("/memberList.go");
			
			List<MemberDTO> list = service.getMemberList();
			
			request.setAttribute("list", list);
			
			view = "memberList.jsp";
			viewResolver(view, request, response);
			
		}else if(action.equals("/join.go")) {			
			System.out.println("/join.go");
			
			view = "join.jsp";
			viewResolver(view, request, response);
			
		}else if(action.equals("/login.go")) {
			System.out.println("/login.go");
			
			view = "login.jsp";
			viewResolver(view, request, response);
			
		}else if(action.equals("/joinAction.go")) {
			System.out.println("/joinAction.go");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String role = request.getParameter("role");
			MemberDTO dto = new MemberDTO(id, pw, name, role);
			
			int rs = service.insert(dto);
			
			view = "login.go";			
			viewResolver(view, request, response);
			
		}else if(action.equals("/loginAction.go")) {
			System.out.println("/loginAction.go"); 
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			
			dto = service.getMember(dto);
			
			if (dto != null) {
				if (dto.getPw().equals(pw)) {
					
					session.setAttribute("id", id);
					session.setAttribute("name", dto.getName());
					
					view = "main.go";
				} else {
					view = "login.go";
				}
			} else {
				view = "login.go";
			}
			viewResolver(view, request, response);
			
		}else if(action.equals("/logout.go")) {
			System.out.println("/logout.go");
			
			session.invalidate();
			
			view = "main.go";
			viewResolver(view, request, response);
			
		}else if(action.equals("/update.go")) {
			System.out.println("/update.go");
			
			String id = (String)session.getAttribute("id");

			MemberDTO dto = new MemberDTO();
			dto.setId(id);

			dto = service.getMember(dto);
			
			request.setAttribute("dto", dto);
			
			view = "update.jsp";
			viewResolver(view, request, response);
			
		}else if(action.equals("/updateAction.go")) {
			System.out.println("/updateAction.go");
			
			String id = (String)session.getAttribute("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String role = request.getParameter("role");
			MemberDTO dto = new MemberDTO(id, pw, name, role);
			
			int rs = service.update(dto);
			
			session.setAttribute("name", name);
			
			view = "update.go";
			viewResolver(view, request, response);
			
		}else if(action.equals("/delete.go")) {			
			System.out.println("/delete.go");
			
			view = "delete.jsp";
			viewResolver(view, request, response);
			
		}else if(action.equals("/deleteAction.go")) {			
			System.out.println("/deleteAction.go");
			
			String id = (String)session.getAttribute("id");
			String pw = request.getParameter("pw");
			
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			
			dto = service.getMember(dto);
			
			if (dto.getPw().equals(pw)) {
				
				service.delete(dto);
				session.invalidate();
				
				view = "main.go";
				
			} else {
				
				view = "delete.go";
			}		
			
			viewResolver(view, request, response);
			
		}		
	}

	void viewResolver(String view, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewExt = view.split("\\.")[1];
		
		if(viewExt.equals("jsp")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(view);
		}
		
	}
	 */
}
