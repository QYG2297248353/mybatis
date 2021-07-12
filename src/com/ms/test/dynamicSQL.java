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
		// if���
//		System.out.println("��ѯ���е�");
//        List<Product> ps = session.selectList("listProduct");
//        for (Product p : ps) {
//            System.out.println(p);
//        }
//         
//        System.out.println("ģ����ѯ");
//        Map<String,Object> params = new HashMap<>();
//        params.put("name","a");
//        List<Product> ps2 = session.selectList("listProduct",params);
//        for (Product p : ps2) {
//            System.out.println(p);
//        }
		// where���
//		System.out.println("��������ѯ");
//		Map<String, Object> params = new HashMap<>();
//		params.put("name", "a");//��������ѡ
//		params.put("price", "10");
//		List<Product> ps2 = session.selectList("listProduct", params);
//		for (Product p : ps2) {
//			System.out.println(p);
//		}
		// where���->set���
//		  Product p = new Product();
//        p.setId(6);
//        p.setName("product zz");
//        p.setPrice(99.99f);
//        session.update("updateProduct",p);
//        listAll(session);
		// choose���
//		Map<String, Object> params = new HashMap<>();
////      params.put("name","a");
////      params.put("price","10");
//		List<Product> ps = session.selectList("listProduct", params);
//		for (Product p : ps) {
//			System.out.println(p);
//		}
		// foreach���
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

	// ��������ȡ����������
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
