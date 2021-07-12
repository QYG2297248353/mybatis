package com.ms.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ms.pojo.Product;

public class dynamicSQL {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		// if语句
//		System.out.println("查询所有的");
//        List<Product> ps = session.selectList("listProduct");
//        for (Product p : ps) {
//            System.out.println(p);
//        }
//         
//        System.out.println("模糊查询");
//        Map<String,Object> params = new HashMap<>();
//        params.put("name","a");
//        List<Product> ps2 = session.selectList("listProduct",params);
//        for (Product p : ps2) {
//            System.out.println(p);
//        }
		// where语句
//		System.out.println("多条件查询");
//		Map<String, Object> params = new HashMap<>();
//		params.put("name", "a");//参数可自选
//		params.put("price", "10");
//		List<Product> ps2 = session.selectList("listProduct", params);
//		for (Product p : ps2) {
//			System.out.println(p);
//		}
		// where语句->set语句
//		  Product p = new Product();
//        p.setId(6);
//        p.setName("product zz");
//        p.setPrice(99.99f);
//        session.update("updateProduct",p);
//        listAll(session);
		// choose语句
//		Map<String, Object> params = new HashMap<>();
////      params.put("name","a");
////      params.put("price","10");
//		List<Product> ps = session.selectList("listProduct", params);
//		for (Product p : ps) {
//			System.out.println(p);
//		}
		// foreach语句
//		List<Integer> ids = new ArrayList();
//		ids.add(1);
//		ids.add(3);
//		ids.add(5);
//
//		List<Product> ps = session.selectList("listProduct", ids);
//		for (Product p : ps) {
//			System.out.println(p);
//		}

		Map<String, String> params = new HashMap();
		params.put("name", "product");

		List<Product> ps = session.selectList("listProduct", params);
		for (Product p : ps) {
			System.out.println(p);
		}

		session.commit();
		session.close();

	}

	// 无条件便取出所有数据
//	private static void listAll(SqlSession session) {
//		Map<String, Object> params = new HashMap<>();
////        params.put("name","a");
////        params.put("price","10");
//		List<Product> ps2 = session.selectList("listProduct", params);
//		for (Product p : ps2) {
//			System.out.println(p);
//		}
//	}
}
