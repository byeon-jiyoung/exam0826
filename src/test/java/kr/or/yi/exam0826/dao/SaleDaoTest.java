package kr.or.yi.exam0826.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.exam0826.AbstractTest;
import kr.or.yi.exam0826.daoImpl.SaleDaoImpl;
import kr.or.yi.exam0826.dto.Sale;

public class SaleDaoTest extends AbstractTest {
	private static SaleDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new SaleDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectSaleByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Sale> list = dao.selectSaleByAll();
		Assert.assertNotNull(list);
	}

}
