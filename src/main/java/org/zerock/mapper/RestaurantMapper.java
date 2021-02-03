package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.RestaurantVO;

public interface RestaurantMapper {
	
	public void insert(RestaurantVO restaurant);
	
	public void insertSelectKey(RestaurantVO restaurant);
	
	public List<RestaurantVO> getList();
	
	public List<RestaurantVO> getList(Criteria cri);
	
	public int delete(Long no);
	
	public int update(RestaurantVO restaurant);
	
	public RestaurantVO read(Long no);
	
}
