package cn.shadow.archetype;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.shadow.archetype.dao.UserMapper;
import cn.shadow.archetype.entity.User;

/**
 * Hello world!
 *
 */
public class App 
{
	public static SqlSession getsession() throws Exception {
		InputStream config=new FileInputStream("E:\\experiment\\archetype\\archetype-dao\\src\\main\\resource\\mybatis-config.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(config);
		return factory.openSession();
	}
    public static void main( String[] args )
    {
        try {
        	Map map=new HashMap();
        	map.put("id", 1);
			UserMapper userdao=getsession().getMapper(UserMapper.class);
			User user=userdao.selectById(map);
			System.out.println("id:"+user.getId()+"\n"+"名字:"+user.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
