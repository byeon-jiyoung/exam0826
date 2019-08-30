package kr.or.yi.exam0826.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.yi.exam0826.AbstractTest;
import kr.or.yi.exam0826.daoImpl.SaleDetailDaoImpl;
import kr.or.yi.exam0826.dto.SaleDetail;

public class SaleDetailDaoTest extends AbstractTest {
	private static SaleDetailDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new SaleDetailDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectSaleDetailRankSalePrice() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<SaleDetail> list = dao.selectSaleDetailRankSalePrice();
		Assert.assertNotNull(list);
	}
	
	@Test
	public void test01SelectSaleDetailRankMarPrice() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<SaleDetail> list = dao.selectSaleDetailRankMarPrice();
		Assert.assertNotNull(list);
	}
}
