package org.zerock.service;

import org.zerock.domain.LikeVO;

public interface LikeService {
	public void likeInsert(LikeVO like);
	public boolean likeRemove(Long userno, Long resno);
	public int getLike(Long userno, Long resno);
	public int getDislike(Long userno, Long resno);
}
