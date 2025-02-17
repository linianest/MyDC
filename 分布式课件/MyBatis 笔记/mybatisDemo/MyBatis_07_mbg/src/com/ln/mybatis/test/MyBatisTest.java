package com.ln.mybatis.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.ln.mybatis.bean.Employee;
import com.ln.mybatis.bean.EmployeeExample;
import com.ln.mybatis.bean.EmployeeExample.Criteria;
import com.ln.mybatis.dao.EmployeeMapper;



public class MyBatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	@Test
	public void testMBG() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}

//	@Test
//	public void test() throws Exception {
//		SqlSessionFactory sessionFactory = getSqlSessionFactory();
//		SqlSession openSession = sessionFactory.openSession();
//		try {
//			EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
//			List<Employee> list=employeeMapper.selectAll();
//			for (Employee employee : list) {
//				System.out.println(employee);
//			}
//		} finally {
//			// TODO: handle finally clause
//			openSession.close();
//		}
//
//	}
	
	
	@Test
	public void testMyBatis3() throws Exception {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession openSession = sessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper=openSession.getMapper(EmployeeMapper.class);
			// xxxMapper就是封装条件的
			// 1、查询所有的
	//		List<Employee> list=employeeMapper.selectByExample(null);
			// 2、查询名字中有e的，并且性别是1
			EmployeeExample employeeExample=new EmployeeExample();
			// 创建一个criteria，这个Criteria就是拼装查询条件
			Criteria criteria=employeeExample.createCriteria();
			criteria.andLastNameLike("%e%");
			criteria.andGenderEqualTo("1");
			List<Employee> list=employeeMapper.selectByExample(employeeExample);
			for (Employee employee : list) {
				System.out.println(employee);
			}
		} finally {
			// TODO: handle finally clause
			openSession.close();
		}

	}

}
