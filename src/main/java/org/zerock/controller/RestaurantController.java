package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.RestaurantVO;
import org.zerock.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/restaurant/*")
@AllArgsConstructor
@Log4j
public class RestaurantController {
	private RestaurantService service;

	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") Criteria cri) {
		List<RestaurantVO> list = service.getList(cri);
		
		int total = service.getTotal(cri);
		PageDTO dto = new PageDTO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("page", dto);
		
	}
	
	@PostMapping("/register")
	public String register(RestaurantVO restaurant, RedirectAttributes rttr) {
		service.register(restaurant);
		rttr.addFlashAttribute("result", restaurant.getNo());
		rttr.addFlashAttribute("message", "상호 " + restaurant.getNo() + "번 글이 등록되었습니다");
		
		return "redirect:/restaurant/list";
	}
	
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Criteria cri) {
		
	}
	
	@GetMapping({"/modify"})
	public void get(Long no, Model model, @ModelAttribute("cri") Criteria cri) {
		RestaurantVO vo = service.read(no);
		model.addAttribute("restaurant", vo);
	}
	
	@PostMapping("/remove")
	public String remove(Long no, RedirectAttributes rttr, Criteria cri) {
		if(service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", no + "번 글이 삭제되었습니다");
		}
		rttr.addAttribute("pageNo", cri.getPageNo());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/restaurant/list";
	}
	
	@PostMapping("/modify")
	public String modify(RestaurantVO restaurant, RedirectAttributes rttr, Criteria cri) {
		if(service.modify(restaurant)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", restaurant.getNo() + "번 글이 수정되었습니다");
		}
		rttr.addAttribute("pageNo", cri.getPageNo());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/restaurant/list";
	}
}
