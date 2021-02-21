package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminMemberVO;

public interface AdminMemberMapper {
	
	public List<AdminMemberVO> getMemberListPaging(Acriteria cri);
	
	public AdminMemberVO getMember(Long no);
	
	public int getMemberTotalCnt(Acriteria cri);
	
}
