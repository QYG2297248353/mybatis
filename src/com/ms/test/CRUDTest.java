package com.ms.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.ms.pojo.Category;
public class CRUDTest {
	// 展示效果调用查询所有的方法
	private static void listAll(SqlSession session) {
		List<Category> cs = session.selectList("listCategory");
		for (Category c : cs) {
			System.out.println(c.getName());
		}
	}

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();

		Category c=new Category();
		//C
		c.setName("123新数据");
		session.insert("addCategory", c);
		//R
		c = session.selectOne("getCategory","这里是id值");
		//U
		c.setName("修改了的123新数据");
		session.update("updateCategory", c);
		//D
		session.delete("deleteCategory",c);

		listAll(session);// 展示效果
		session.commit();// 事务提交->写入数据库
		session.close();// 关闭连接->清空写入到缓存的数据
	}
}
