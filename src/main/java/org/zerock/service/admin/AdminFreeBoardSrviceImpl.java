package org.zerock.service.admin;

import java.util.List;

import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminFreeBoardVO;
import org.zerock.mapper.AdminFreeBoardMapper;

public class AdminFreeBoardSrviceImpl implements AdminFreeBoardService {
	
	private AdminFreeBoardMapper mapper;
	
	@Override
	public List<AdminFreeBoardVO> getList(Acriteria cri) {
		return mapper.getBoardListPaging(cri);
	}

	@Override
	public int getTotal(Acriteria cri) {
		return mapper.getBoardTotalCnt(cri);
	}

	@Override
	public AdminFreeBoardVO read(Long no) {
		return mapper.read(no);
	}

	@Override
	public boolean removeBoard(Long no) {
		return mapper.deleteBoard(no) == 1 ;
	}

	@Override
	public boolean removeReply(Long no) {
		return mapper.deleteReply(no) == 1;
	}

}
