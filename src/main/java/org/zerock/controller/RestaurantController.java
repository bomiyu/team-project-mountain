package org.zerock.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AddressVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.domain.RestaurantVO;
import org.zerock.service.LikeService;
import org.zerock.service.RestaurantService;
import org.zerock.upload.UploadFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/restaurant/*")
@AllArgsConstructor
@Log4j
public class RestaurantController {
	private RestaurantService service;
	private LikeService likeSvc;

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") Criteria cri, HttpServletRequest req) {
		List<RestaurantVO> list = service.getList(cri);
		RestaurantVO vo = new RestaurantVO();
		// userno 세션 가져오기 
		int userno = (authUser) req.getSession().getAttribute("authUser").getUserno(); 
		int total = service.getTotal(cri);
		PageDTO dto = new PageDTO(cri, total);
		int like = likeSvc.getLike(vo.getNo(), userno);
		model.addAttribute("list", list);
		model.addAttribute("page", dto);
		
	}
	
	@PostMapping("/register")
	public String register(RestaurantVO restaurant, RedirectAttributes rttr, MultipartFile file, AddressVO addr) throws Exception {
		// manager 세션 가져오기
		log.info("**************************" + restaurant.getMname() + "******************************");
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFile.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file != null) {
		 fileName = UploadFile.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
	
		restaurant.setImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		String address = addr.getAddress1() + " " + addr.getAddress2();
		log.info("**************************" + address + "******************************");
		restaurant.setRloc(address);
		
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
		log.info("********* modify get *************" + vo.getRloc() + "*******************");
		
		model.addAttribute("restaurant", vo);
	}
	
	@PostMapping("/remove")
	// manager 세션 가져오기
	public String remove(Long no, RedirectAttributes rttr, Criteria cri, MultipartFile file, HttpServletRequest req) throws Exception {
		
		new File(uploadPath + req.getParameter("gdsImg")).delete();
		
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
	// manager 세션 가져오기
	public String modify(RestaurantVO restaurant, RedirectAttributes rttr, Criteria cri, MultipartFile file, HttpServletRequest req, AddressVO addr) throws Exception {
		log.info("**********************" + file.getOriginalFilename() + "*******************");
		log.info("**********************" + req.getParameter("gdsImg") + "*******************");
		
		if(file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
			  // 기존 파일을 삭제
			  new File(uploadPath + req.getParameter("gdsImg")).delete();
			  
			  // 새로 첨부한 파일을 등록
			  String imgUploadPath = uploadPath + File.separator + "imgUpload";
			  String ymdPath = UploadFile.calcPath(imgUploadPath);
			  String fileName = UploadFile.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			  
			  restaurant.setImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			  
			 } else {  // 새로운 파일이 등록되지 않았다면
			  // 기존 이미지를 그대로 사용
				 restaurant.setImg(req.getParameter("gdsImg"));
			  
			 }
		String address = addr.getAddress1() + ", " + addr.getAddress2();
		log.info("**************************" + address + "******************************");
		restaurant.setRloc(address);
		
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
