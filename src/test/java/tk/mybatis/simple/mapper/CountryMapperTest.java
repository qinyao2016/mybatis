package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.mapper.BaseMapperTest;
import tk.mybatis.simple.model.Country;

public class CountryMapperTest extends BaseMapperTest {
	public void testSelectAll() {
		SqlSession sqlSession = getSqlSession();
		try {
			List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
			printCountryList(countryList);
		} finally {
			//不要忘记关闭sqlSession
			sqlSession.close();
		}

	}

	private void printCountryList(List<Country> countryList) {
		for (Country country : countryList) {
			System.out.printf("%-4d%4s%4s \n", country.getId(),
					country.getCountryname(), country.getCountrycode());
		}

	}
}
