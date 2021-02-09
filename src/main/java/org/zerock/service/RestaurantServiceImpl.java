package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Rcriteria;
import org.zerock.domain.RestaurantVO;
import org.zerock.mapper.RestaurantMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class RestaurantServiceImpl implements RestaurantService{
	
	private RestaurantMapper mapper;
	
	@Override
	public void register(RestaurantVO restaurant) {
		mapper.insertSelectKey(restaurant);
	}

	@Override
	public RestaurantVO read(Long no) {
		return mapper.read(no);
	}

	@Override
	public boolean modify(RestaurantVO restaurant) {
		return mapper.update(restaurant) == 1;
	}

	@Override
	public boolean remove(Long no) {
		return mapper.delete(no) == 1;
	}

	@Override
	public List<RestaurantVO> getList(Rcriteria cri) {
		return mapper.getListPaging(cri);
	}

	@Override
	public int getTotal(Rcriteria cri) {
		return mapper.getTotalCnt(cri);
	}

}
