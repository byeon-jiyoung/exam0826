package kr.or.yi.exam0826.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.exam0826.dao.SaleDetailDao;
import kr.or.yi.exam0826.dto.SaleDetail;
import kr.or.yi.exam0826.jdbc.MybatisSqlSessionFactory;

public class SaleDetailDaoImpl implements SaleDetailDao {
	private String namespace = "kr.or.yi.exam0826.dao.SaleDetailMapper";
	
	@Override
	public List<SaleDetail> selectSaleDetailRankSalePrice() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectSaleDetailRankSalePrice");
		}
	}

	@Override
	public List<SaleDetail> selectSaleDetailRankMarPrice() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectSaleDetailRankMarPrice");
		}
	}

}
