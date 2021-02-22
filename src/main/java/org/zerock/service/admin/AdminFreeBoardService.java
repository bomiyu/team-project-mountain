package org.zerock.service.admin;

import java.util.List;

import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminFreeBoardVO;
import org.zerock.domain.admin.AdminMemberVO;

public interface AdminFreeBoardService {
	public List<AdminFreeBoardVO> getList(Acriteria cri);
	
	public int getTotal(Acriteria cri);
	
	public AdminFreeBoardVO read(Long no);
	
	public boolean removeBoard(Long no);
	
	public boolean removeReply(Long no);
}
