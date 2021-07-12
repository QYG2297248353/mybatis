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

public class selectTest {
	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		//模糊查询
//      List<Category> cs = session.selectList("listCategoryByName","6");
//      for (Category c : cs) {
//          System.out.println(c.getName());
//      }
		//多条件查询
//		Map<String,Object> params = new HashMap<>();
//        params.put("id", 3);
//        params.put("name", "cat");
//         
//        List<Category> cs = session.selectList("listCategoryByIdAndName",params);
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
		//一对多
		List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p);
            }
        }
        //多对一
        List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
        	System.out.println(p+" 对应的分类是 \t "+ p.getCategory().getName());
        }
		session.commit();
		session.close();

	}
}
