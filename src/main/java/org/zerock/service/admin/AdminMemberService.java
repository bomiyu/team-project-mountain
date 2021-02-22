package org.zerock.service.admin;

import java.util.List;

import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminMemberVO;

public interface AdminMemberService {
	public List<AdminMemberVO> getList(Acriteria cri);
	
	public int getTotal(Acriteria cri);
	
	public AdminMemberVO getMember(Long no);
	
	public int getMemberCnt();

}
