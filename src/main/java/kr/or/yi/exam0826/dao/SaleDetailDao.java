package kr.or.yi.exam0826.dao;

import java.util.List;

import kr.or.yi.exam0826.dto.SaleDetail;

public interface SaleDetailDao {
	public List<SaleDetail> selectSaleDetailRankSalePrice();
	public List<SaleDetail> selectSaleDetailRankMarPrice();
}
