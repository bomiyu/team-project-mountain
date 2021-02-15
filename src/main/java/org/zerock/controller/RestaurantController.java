package org.zerock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.restaurant.AddressVO;
import org.zerock.domain.restaurant.Rcriteria;
import org.zerock.domain.restaurant.RestaurantVO;
import org.zerock.domain.restaurant.RpageDTO;
import org.zerock.service.restaurant.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/restaurant/*")
@AllArgsConstructor
@Log4j
public class RestaurantController {
	private RestaurantService service;

	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") Rcriteria cri) {
		List<RestaurantVO> list = service.getList(cri);
		// userno 세션 가져오기
		// int userno = (authUser)
		// req.getSession().getAttribute("authUser").getUserno();
		int total = service.getTotal(cri);
		RpageDTO dto = new RpageDTO(cri, total);

		model.addAttribute("list", list);
		model.addAttribute("page", dto);

	}

	@PostMapping("/register")
	public String register(@Valid RestaurantVO restaurant, BindingResult result, RedirectAttributes rttr, @Valid AddressVO addr, HttpSession session)
			throws Exception {
		// manager == 1 세션 가져오기
		// User authUser = (User) req.getSession().getAttribute("authUser");
//		MemberVO user = (MemberVO) session.getAttribute("authUser");
		
		if(result.hasErrors()) {
			return "/restaurant/register";
		}
		log.info("*************** m.name ***********" + restaurant.getMname() + "******************************");

		String address = addr.getAddress1() + " " + addr.getAddress2();
		log.info("**************************" + address + "******************************");
		
		
		
//		if (user.getManager() == 1) {
			restaurant.setRloc(address);
			log.info("**************************" + restaurant + "******************************");
			service.register(restaurant);
			rttr.addFlashAttribute("result", restaurant.getNo());
			rttr.addFlashAttribute("message", restaurant.getNo() + "번 글이 등록되었습니다");
//		}

		return "redirect:/restaurant/list";
	}


	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Rcriteria cri) {

	}

	@GetMapping("/modify")
	public void get(Long no, Model model, @ModelAttribute("cri") Rcriteria cri) {

		RestaurantVO vo = service.read(no);
		log.info("********* modify get *************" + vo.getRloc() + "*******************");

		model.addAttribute("restaurant", vo);

	}

	@PostMapping("/remove")
	// manager 세션 가져오기
	public String remove(Long no, RedirectAttributes rttr, Rcriteria cri, HttpSession session) throws Exception {
//		if(service.remove(no)) {
//			rttr.addFlashAttribute("result", "success");
//			rttr.addFlashAttribute("message", no + "번 글이 삭제되었습니다");
//		}
//		MemberVO user = (MemberVO) session.getAttribute("authUser");
//		if (user.getManager() == 1) {
			service.remove(no);
//		}
			rttr.addAttribute("pageNo", cri.getPageNo());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/restaurant/list";
	}

	@PostMapping("/modify")
	// manager 세션 가져오기
	public String modify(RestaurantVO restaurant, RedirectAttributes rttr, Rcriteria cri, HttpSession session,
			AddressVO addr) throws Exception {
		String address = addr.getAddress1() + " " + addr.getAddress2();
		log.info(restaurant);
		log.info("****************    address   **********" + address + "******************************");
//		MemberVO user = (MemberVO) session.getAttribute("authUser");
//		if (user.getManager() == 1) {

			restaurant.setRloc(address);

			if (service.modify(restaurant)) {
				rttr.addFlashAttribute("result", "success");
				rttr.addFlashAttribute("message", restaurant.getNo() + "번 글이 수정되었습니다");
			}
//		}
		rttr.addAttribute("pageNo", cri.getPageNo());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/restaurant/list";
	}

}
