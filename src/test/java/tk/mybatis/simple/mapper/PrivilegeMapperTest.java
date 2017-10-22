package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysPrivilege;

/**
 * 权限测试类
 * 
 * @author qinyao
 * 
 */
public class PrivilegeMapperTest extends BaseMapperTest {	
	
	@Test
	public void testSelectById() {
		SqlSession sqlSession = getSqlSession();
		try {
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			SysPrivilege sysPrivilege = privilegeMapper.selectById(1L);
			System.err.println(sysPrivilege.toString());
			//删除
			//privilegeMapper.deleteById(9L);
		} finally {
			sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}

	}

	


}
