package kr.or.yi.exam0826.jdbc;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
		
		private static SqlSessionFactory getSqlSessionFactory() {
			if(sqlSessionFactory == null) {
				InputStream inputStream;
				try {
					inputStream = Resources.getResourceAsStream("mybatis-config.xml");
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e.getCause());
				}
			}
			return sqlSessionFactory;
		}
		
		public static SqlSession openSession() {
			return getSqlSessionFactory().openSession();
		}
}
