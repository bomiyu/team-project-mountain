package org.zerock.service;

import java.util.List;

import org.zerock.domain.Rcriteria;
import org.zerock.domain.RestaurantVO;

public interface RestaurantService {
	public void register(RestaurantVO restaurant);

	public RestaurantVO read(Long no); 

	public boolean modify(RestaurantVO restaurant);

	public boolean remove(Long no);
	
	public List<RestaurantVO> getList(Rcriteria cri);
	
	public int getTotal(Rcriteria cri);

}
