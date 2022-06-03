package com.influencer.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.FirstnameService;
import service.MemberService;
import service.YtubeService;
import vo.FirstnameVO;
import vo.MemberVO;
/*
 * 2022 - 05 - 26
 * Last update 최성림
 * login 
 * logout
 * check(idGet, pwGet)
 * */
import vo.YtubeVO;



/**
 * 2022-06-03
 * @author ChoiSungRim
 * Client interest에 따른 Ytube Image 출력 (home.jsp)
 * Id Get, Pw Get 구현 완료 ( 새창 페이지 띄우는거 만들면 그곳으로 Json해서 전달 )
 * coding convention = 1가지 조건,반복은 띄어쓰기, 2가지 이상 조건 or 반복은 붙여쓰기 // 매개변수는 한칸씩 띄우되, @annotation 의 경우는 단락을 나눔
 * */

@Controller
public class MemberController{
	List<YtubeVO> list = new ArrayList<YtubeVO>();
	@Autowired
	MemberService Service;
	@Autowired
	FirstnameService Fservice;
	@Autowired
	YtubeService Yservice;
	
	int cnt = 0 ;
	
	//login
	@RequestMapping(value = "/loginf")
	public ModelAndView loginf(ModelAndView mv) {
		mv.setViewName("member/login");
		return mv;
	} 
	@RequestMapping(value = "/login")
	@ResponseBody
	public ModelAndView login(ModelAndView mv, HttpServletRequest request, RedirectAttributes attr, MemberVO vo, YtubeVO vo1) {
		String password = request.getParameter("pw"); // 입력한 비밀번호
		vo = Service.selectOne(vo); // vo에 저장된 비밀번호
		
		int i = 1; // 전달할 namespace
		int listNum = 0; // 불러올 listNumber
		
		if(vo != null) {
			List<YtubeVO> imglist = Yservice.imgOne(vo.getInterest());
			if(vo.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("Login_Id", vo.getId());
				session.setAttribute("Login_Name", vo.getNick_name());
				if(vo.getInterest() != null) {
					session.setAttribute("interest", vo.getInterest());
					
					if(vo.getInterest().length() >= 3) {
						session.setAttribute("interest", vo.getInterest().substring(0,2)); 
					}
					//Interest에 따른 Ytube Image 출력 
					do {
						session.setAttribute("img"+i, imglist.get(listNum).getImage());
						session.setAttribute("name"+i, imglist.get(listNum).getName());
						session.setAttribute("subs"+i, imglist.get(listNum).getSubscribe());
						i++; 
						listNum++;
					}while (i <= 3);
					
				}else {
					session.setAttribute("interest", vo.getInterest()); 
					mv.setViewName("home");
				}
			}else {
				mv.setViewName("member/login");
			}
		}else { 
			mv.setViewName("member/login");
		}
		return mv;
	}
	
	//logout control
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, ModelAndView mv) {
		request.getSession().invalidate();
		mv.setViewName("home");
		return mv;
	}
	
	// check control
	@RequestMapping(value = "/id_pw_getf")
	public ModelAndView allcheck(HttpServletRequest request, ModelAndView mv, HttpServletResponse response) {
		request.getSession().invalidate();
		mv.setViewName("member/id_pw_get");
		return mv;
	}
	@RequestMapping(value = "/idGet" , method = RequestMethod.POST)
	public ModelAndView idGet(ModelAndView mv, MemberVO vo , 	
							  @RequestParam("email_get") String email,
							  @RequestParam("birthday_get") int birth, 	
							  @RequestParam("color_get") String color) {
		
		HashMap<String,Object>map = new HashMap<>(); // 1:N 매칭을 하기위해서 HashMap 사용 (파라미터값이 N개 이상)
		map.put("email",email);
		map.put("birth",birth);
		map.put("color",color);

		MemberVO id = Service.getAll(map);
		mv.addObject(id.getId()); // 아이디찾기
		mv.setViewName("member/idGet");
		return mv;
	}
	@RequestMapping(value = "/pwGet", method = RequestMethod.POST)
	public ModelAndView pwGet(ModelAndView mv, MemberVO vo , 
							  @RequestParam("email_get") String email,
			  				  @RequestParam("birthday_get") int birth, 	
			  				  @RequestParam("color_get") String color) {
		
		HashMap<String,Object>map = new HashMap<>();
		map.put("email",email);
		map.put("birth",birth);
		map.put("color",color);

		MemberVO password = Service.getAll(map);
		mv.addObject(password.getPassword()); // 비밀번호찾기
		mv.setViewName("member/pwGet");
		return mv;
	}
	
	
	// join
	@RequestMapping(value = {"/joinf","/t"}, method = RequestMethod.GET)
	public ModelAndView joinf(ModelAndView mv,HttpServletRequest request,MemberVO vo) {
		List<FirstnameVO> nickname = Fservice.givenick();
		mv.addObject("apple", nickname.get(cnt).getNick_name()); // 닉네임 넣어주기
		
		mv.setViewName("member/join");
		return mv;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join (ModelAndView mv, HttpServletRequest request, MemberVO vo) {
		List<FirstnameVO>nickname = Fservice.givenick();
		if(Service.insert(vo)>0) {
			Fservice.countUpdate(nickname.get(cnt).getNick_name());
			cnt++;
			mv.addObject("message", "회원가입 완료");
			mv.setViewName("member/login");
		}else {
			mv.addObject("message", "회원가입 오류 다시하세요");
			mv.setViewName("member/join");
		}
		
		return mv;
		
	}
	
	
	
	// 아직 미사용
	@RequestMapping(value = "/idDupCheck", method = RequestMethod.GET)
	public ModelAndView idDupCheck(ModelAndView mv, MemberVO vo) {
		mv.addObject("newId",vo.getId());
		vo = Service.selectOne(vo);
		if(vo != null) {
			// 사용 불가능 id 존재
			mv.addObject("idUse","F");
		}else {
			// 사용 가능 id 존재
			mv.addObject("idUse","T");
		}
		mv.setViewName("member/idDupCheck");
		return mv;
	} // idDupCheck
	
	

	
	

}
