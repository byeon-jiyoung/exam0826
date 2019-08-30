package kr.or.yi.exam0826.daoImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.exam0826.dao.ProductDao;
import kr.or.yi.exam0826.dto.Product;
import kr.or.yi.exam0826.jdbc.MybatisSqlSessionFactory;

public class ProductDaoImpl implements ProductDao {
	private String namespace = "kr.or.yi.exam0826.dao.ProductMapper";
	
	@Override
	public List<Product> selectProductByAll() {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace + ".selectProductByAll");
		}
	}

	@Override
	public Product selectProductByCode(Product product) {
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectProductByCode", product);
		}
	}

}
