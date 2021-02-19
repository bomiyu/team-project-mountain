package org.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.member.MemberVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/admin/*")
@Log4j
public class AdminController {
	
	@GetMapping("/index")
	public String index(RedirectAttributes rttr, HttpSession session) {
		MemberVO user = (MemberVO) session.getAttribute("authUser");
		try {
			if(user.getManager() == 0 || user == null) {
				rttr.addFlashAttribute("message2", "관리자만이용 가능합니다");
				return "redirect:/index.jsp";
			}
			} catch (NullPointerException e) {
				e.printStackTrace();
				rttr.addFlashAttribute("message2", "관리자만이용 가능합니다");
				return "redirect:/index.jsp";
			}
			return "/admin/index";
		}
	
	}
