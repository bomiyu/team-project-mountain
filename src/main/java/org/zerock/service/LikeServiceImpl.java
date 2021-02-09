package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.LikeVO;
import org.zerock.mapper.LikeMapper;
import org.zerock.mapper.RestaurantMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class LikeServiceImpl implements LikeService {
	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;

	@Override
	public void likeInsert(LikeVO like) {
		mapper.insertLike(like);
		mapper.likeUpdate(like.getLikeno());
	}

	@Override
	public void likeRemove(Long resno, Long userno) {
		 mapper.likeDelete(userno, resno);
		 mapper.likeUpdate(resno);
	}

	@Override
	public int getLike(Long userno, Long resno) {
		return mapper.getLike(userno, resno);
	}

}
