package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminFreeBoardVO;

public interface AdminFreeBoardMapper {
	
	public List<AdminFreeBoardVO> getBoardListPaging(Acriteria cri);
	
	public AdminFreeBoardVO read(Long no);
	
	public int getBoardTotalCnt(Acriteria cri);
	
	public int deleteBoard(Long no);
	
	public int deleteReply(Long no);
}
