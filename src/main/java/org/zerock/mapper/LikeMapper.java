package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.LikeVO;

public interface LikeMapper {
	
	public int insertLike(LikeVO likeVO);
	
	public int getCount(Long resno);
	
//	public int dislikeCount(Long resno);
	
	public int likeDelete(Long userno, Long resno);
	
	public int likeUpdate(Long resno);
	
	public int getLike(Long userno, Long resno);
}
