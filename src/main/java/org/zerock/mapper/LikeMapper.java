package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.LikeVO;

public interface LikeMapper {
	
	public void insertSelectKey(LikeVO like);
	
	public int likeCount(Long bno);
	
	public int delete(Long uno);
	
	public int likeCheck(Long likeCheck);

	public List<LikeVO> getList();
}
