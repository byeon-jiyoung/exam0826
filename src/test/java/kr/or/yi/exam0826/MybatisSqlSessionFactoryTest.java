package kr.or.yi.exam0826;


import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import kr.or.yi.exam0826.jdbc.MybatisSqlSessionFactory;

public class MybatisSqlSessionFactoryTest extends AbstractTest {
	
	@Test
	public void testOpenSession() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		SqlSession session = MybatisSqlSessionFactory.openSession();
		log.debug("session"+session);
		Assert.assertNotNull(session);
	}

}
