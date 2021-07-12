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
	// չʾЧ�����ò�ѯ���еķ���
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
		c.setName("123������");
		session.insert("addCategory", c);
		//R
		c = session.selectOne("getCategory","������idֵ");
		//U
		c.setName("�޸��˵�123������");
		session.update("updateCategory", c);
		//D
		session.delete("deleteCategory",c);

		listAll(session);// չʾЧ��
		session.commit();// �����ύ->д�����ݿ�
		session.close();// �ر�����->���д�뵽���������
	}
}
