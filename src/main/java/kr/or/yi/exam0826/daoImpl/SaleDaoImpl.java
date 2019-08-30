package kr.or.yi.exam0826.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.exam0826.dao.SaleDao;
import kr.or.yi.exam0826.dto.Sale;
import kr.or.yi.exam0826.jdbc.MybatisSqlSessionFactory;

public class SaleDaoImpl implements SaleDao {
	private String namespace = "kr.or.yi.exam0826.dao.SaleMapper";
	
	@Override
	public List<Sale> selectSaleByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectSaleByAll");
		}
	}

}
