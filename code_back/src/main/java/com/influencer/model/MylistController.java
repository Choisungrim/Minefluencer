package com.influencer.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MylistService;
import vo.MemberVO;
import vo.MylistVO;

@Controller
public class MylistController {
	@Autowired
	MylistService service;
	
	@RequestMapping(value = "/mylistf")
	public ModelAndView rankf(ModelAndView mv,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("Login_Id") != null) {
			mv.addObject("list",service.selectList((String)session.getAttribute("Login_Id")));
			mv.setViewName("mylist/my_list");
		}
		else
			mv.setViewName("member/login");
		return mv;
	}
	@RequestMapping(value = "/alllist")
	public ModelAndView alllist(ModelAndView mv,HttpServletRequest request,MylistVO vo
								,HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("Login_Id") != null) {
			mv.addObject("list",service.selectList((String)session.getAttribute("Login_Id")));
			mv.setViewName("jsonView");
		}
		return mv;
	} 
}
