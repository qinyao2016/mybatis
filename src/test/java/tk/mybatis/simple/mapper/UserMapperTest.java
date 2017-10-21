package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysRole2;
import tk.mybatis.simple.model.SysUser;

/**
 * 用户测试类
 * 
 * @author qinyao
 * 
 */
public class UserMapperTest extends BaseMapperTest {	
	public void testSelectById() {
		//获取sqlSession
		SqlSession sqlSession = getSqlSession();
		Logger logger = getLogger();
		//多种输出方式
		//logger.warn(user.getUserName());
		//System.err.println(user.getUserEmail());
		try {
			//获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用selectById方法，查询id=1的用户
			SysUser user = userMapper.selectById(1l);
			//user不为空
			Assert.assertNotNull(user);
			//userName=admin
			Assert.assertEquals("admin", user.getUserName());
		} finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}

	}

	public void testSelectAll() {
		//获取sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用selectById方法，查询id=1的用户
			List<SysUser> userList = userMapper.selectAll();
			//结果不为空
			Assert.assertNotNull(userList);
			System.err.println(userList.get(0).toString());
			//用户数量大于0个
			Assert.assertTrue(userList.size() > 0);
		} finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	public void testSelectRolesByUserId() {
		//获取sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用selectById方法，查询id=1的用户
			List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
			//结果不为空
			Assert.assertNotNull(roleList);
			for(SysRole role : roleList) {
				System.err.println(role.toString());
			}
		} finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	public void testSelectRolesByUserId2() {
		//获取sqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			//获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//调用selectById方法，查询id=1的用户
			List<SysRole2> roleList = userMapper.selectRolesByUserId2(1L);
			//结果不为空
			Assert.assertNotNull(roleList);
			for(SysRole2 role : roleList) {
				System.err.println(role.toString());
			}
		} finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	
	public void testInsert() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			
			int result = userMapper.insert(user);
			System.out.println(result);
			Assert.assertEquals(1, result);
			Assert.assertNull(user.getId());
			System.err.println(user.toString());
		} finally {
			sqlSession.rollback();
			//sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	
	public void testInsert2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test2");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			
			int result = userMapper.insert2(user);
			Assert.assertEquals(1, result);
			Assert.assertNotNull(user.getId());
			System.err.println(user.toString());
		} finally {
			//sqlSession.rollback();
			sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	public void testInsert3() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = new SysUser();
			user.setUserName("test3");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			user.setHeadImg(new byte[] {1,2,3});
			user.setCreateTime(new Date());
			
			int result = userMapper.insert3(user);
			Assert.assertEquals(1, result);
			//Assert.assertNotNull(user.getId());
			System.err.println(user.toString());
		} finally {
			//sqlSession.rollback();
			sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	}
	
	public void testUpdateById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser user = userMapper.selectById(1L);
			user.setUserName("qinyao");
			int result = userMapper.updateById(user);
			Assert.assertEquals(1, result);
			System.err.println(user.toString());
		} finally {
			//sqlSession.rollback();
			sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	} 
	
	
	public void testDeleteById() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//法一
			SysUser user = userMapper.selectById(1027L);
			int result1 = userMapper.deleteById(user);
			//法二
			SysUser user2 = new SysUser();
			user2.setId(1030L);
			int result2 = userMapper.deleteById(user2);
			//法三
			int result3 = userMapper.deleteById(1031L);
			
			System.err.println(user.toString());
		} finally {
			//sqlSession.rollback();
			sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	} 
	
	
	public void testSelectByUserIdAndRoleEnabled() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			Long userId = 1L;
			SysUser user = new SysUser();
			user.setId(userId);
			Integer enabled = 1;
			List<SysRole> roleList = userMapper.selectByUserIdAndRoleEnabled(user, enabled);
			for(SysRole role : roleList) {
				System.err.println(role.toString());
			}
		} finally {
			//sqlSession.rollback();
			sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	} 
	
	/***
	 * 注解方式根据id删除
	 */
	public void testDeleteById2() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//法三
			int result3 = userMapper.deleteById2(1032L);
		} finally {
			//sqlSession.rollback();
			sqlSession.commit();
			//不要忘记关闭sqlSession
			sqlSession.close();
		}
	} 


}
