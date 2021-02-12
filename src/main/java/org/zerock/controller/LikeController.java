package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.LikeVO;
import org.zerock.service.LikeService;
import org.zerock.service.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/restaurant/*")
@AllArgsConstructor
@Log4j
public class LikeController {
	private LikeService likeSvc;
	@ResponseBody
	@PostMapping(value = "/like", produces = "application/json")
	public String like(LikeVO like, HttpServletRequest req, RedirectAttributes rttr) {
		log.info("********* clickLike *****************" + req.getAttribute("likeno")
				+ "******************************");
		log.info("********* clickDislike *****************" + req.getAttribute("dislikeno")
				+ "******************************");
		log.info("********* resno *****************" + req.getAttribute("resno") + "******************************");
		log.info("********* userno *****************" + req.getAttribute("userno") + "******************************");

		int resLike = likeSvc.getLike(like.getUserno(), like.getResno());
		int resDislike = likeSvc.getDislike(like.getUserno(), like.getResno());

		if (resLike >= 1 || resDislike >= 1) {
			likeSvc.likeRemove(like.getUserno(), like.getResno());
			likeSvc.likeInsert(like);
			likeSvc.likeUpdate(like.getResno());
		} else {
			likeSvc.likeInsert(like);
			likeSvc.likeUpdate(like.getResno());
		}

		if (like.getLikeno() == 1) {
			rttr.addAttribute("clicked_like", 1);
		} else if (like.getDislikeno() == 1) {
			rttr.addAttribute("clicked_dislike", 1);
		}

		return "success";
	}
}
