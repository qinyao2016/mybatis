package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysRole2;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	/***
	 * 通过id查询用户
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);

	/***
	 * 查询全部用户
	 * 
	 * @return
	 */
	List<SysUser> selectAll();
	
	/***
	 * 根据用户ID获取角色信息
	 * 
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	
	/***
	 * 根据用户ID获取角色信息
	 * 
	 * @param userId
	 * @return
	 */
	List<SysRole2> selectRolesByUserId2(Long userId);
	
	/***
	 * 新增用户
	 * 
	 * @param sysUser
	 * @return
	 */
	int insert(SysUser sysUser);
	
	int insert2(SysUser sysUser);
	
	int insert3(SysUser sysUser);
	
	/***
	 * 根据主键更新
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
	
	/***
	 * 根据主键删除
	 * @param id
	 * or @param sysUser
	 * @return
	 */
	int deleteById(Long id);
	int deleteById(SysUser sysUser);
	
	/***
	 * 根据用户id和角色的enabled状态获取用户的角色
	 * 
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectByUserIdAndRoleEnabled(
			//两种不同方式的注解
			@Param("user")SysUser user, 
			@Param("enabled")Integer enabled);
	
	@Delete("delete from sys_user where id = #{id}")
	int deleteById2(Long id);
}
