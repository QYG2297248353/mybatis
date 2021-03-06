package com.ms.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ms.pojo.Category;
import com.ms.pojo.Product;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		//Category???ò???
		List<Category> cs=session.selectList("listCategory");
		for (Category c : cs) {
			System.out.println(c.getName());
		}
		//Product???ò???
		List<Product> ps=session.selectList("listProduct");
		for (Product p : ps) {
			System.out.println(p.getName()+"\t"+p.getPrice());
		}
	}
}
