package kr.or.yi.exam0826.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.exam0826.AbstractTest;
import kr.or.yi.exam0826.daoImpl.ProductDaoImpl;
import kr.or.yi.exam0826.dto.Product;

public class ProductDaoTest extends AbstractTest {
	private static ProductDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new ProductDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectSaleByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Product> list = dao.selectProductByAll();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test02SelectSaleByCode() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Product p  = new Product("A003");
		Product product = dao.selectProductByCode(p);
		Assert.assertNotNull(product);
	}
}
