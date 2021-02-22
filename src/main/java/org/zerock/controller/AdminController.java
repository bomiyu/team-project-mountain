package org.zerock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminFreeBoardVO;
import org.zerock.domain.admin.AdminMemberVO;
import org.zerock.domain.admin.ApageDTO;
import org.zerock.domain.admin.VisitVO;
import org.zerock.domain.member.MemberVO;
import org.zerock.service.admin.AdminFreeBoardService;
import org.zerock.service.admin.AdminMemberService;
import org.zerock.service.visit.VisitService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor // 생성자 자동생성
@RequestMapping("/admin/*")
@Log4j
public class AdminController {
	
	private VisitService visitSvc;
	private AdminMemberService memberSvc;
	// private AdminFreeBoardService boardSvc;
	
	@GetMapping("/index")
	public String index(RedirectAttributes rttr, HttpSession session, Model model) {
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
		
         int today = visitSvc.getToday();
         int total = visitSvc.getTotal();
         int memberCnt = memberSvc.getMemberCnt();
         log.info("*****************today*****" + today);
         log.info("*****************total*****" + total);
         model.addAttribute("today", today);
         model.addAttribute("total", total);
         model.addAttribute("memberCnt", memberCnt);
		
			return "/admin/index";
		}
	
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") Acriteria cri) {
		// MemberVO user = (MemberVO) session.getAttribute("authUser");
		List<AdminMemberVO> mlist = memberSvc.getList(cri);
		 int total = memberSvc.getTotal(cri);
		ApageDTO memberDto = new ApageDTO(cri, total);
		model.addAttribute("memberList", mlist);
	    model.addAttribute("page", memberDto);

		}

}