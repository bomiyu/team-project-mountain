package org.zerock.service;

import org.zerock.domain.LikeVO;

public interface LikeService {
	public void likeRegister(LikeVO like);
	public void likeRemove(Long resno, Long userno);
	public int getLike(Long userno, Long resno);
}