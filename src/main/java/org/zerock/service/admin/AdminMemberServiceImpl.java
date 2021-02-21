package org.zerock.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminMemberVO;
import org.zerock.mapper.AdminMemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class AdminMemberServiceImpl implements AdminMemberService {

	private AdminMemberMapper mapper;
	
	@Override
	public List<AdminMemberVO> getList(Acriteria cri) {
		return mapper.getMemberListPaging(cri);
	}

	@Override
	public int getTotal(Acriteria cri) {
		return mapper.getMemberTotalCnt(cri);
	}

	@Override
	public AdminMemberVO getMember(Long no) {
		return mapper.getMember(no);
	}

}
