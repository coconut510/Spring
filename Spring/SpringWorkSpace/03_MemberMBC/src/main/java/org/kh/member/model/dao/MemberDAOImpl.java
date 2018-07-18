package org.kh.member.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{

	@Override
	public Member selectOneMember(JdbcTemplate jdbc, Member vo) {
		
		//query 메소드의 인자값은 2개 혹은 3개
		// 2개 => 쿼리문, RowMapper
		// 3개 => 쿼리문, 쿼리문 Parameter, RowMapper
		// 쿼리문  : 말그대로 SQL구문
		// RowMapper : 작동한쿼리문에 대한 결과값을 처리하는 것이 명시된 객체
		// 쿼리문 Parameter : 쿼리문에 ? 가 있을경우에 사용되는 인자값

		// 쿼리문
		String query = "select * from member where user_id=? and user_pw =? ";
		
		// 쿼리문 파라미터(Object형 배열)
		Object [] params = {vo.getUserId(), vo.getUserPw()};
		
		List list = jdbc.query(query,  params, new MemberRowMapper());
		
		if(!list.isEmpty()){			
			return (Member)list.get(0);
		}
		else{
			return null;
		}
	}

	public int logout(JdbcTemplate jdbc, Member m) {
		String query = "select * from member where user_id=? and user_pw=?";
		
		Object [] params = {m.getUserId(), m.getUserPw()};
		
		int result = jdbc.update(query, params);
		return result;
	}

	public int updateMember(JdbcTemplate jdbc, Member vo) {
		String query = "update member set user_pw = ?, user_phone = ? where user_id=?";
		Object[] params = {vo.getUserPw(), vo.getPhone(), vo.getUserId()};
		
		int result = jdbc.update(query, params);
		return result;
	}

	public int insertMember(JdbcTemplate jdbc, Member vo) {
		String query = "insert into member values(?,?,?,?)";
		Object[] params = {vo.getUserId(), vo.getUserPw(), vo.getUserName(), vo.getPhone()};
		
		int result = jdbc.update(query, params);
		return result;
	}

	public int deleteMember(JdbcTemplate jdbc, Member vo) {
		String query = "delete member where user_id=?";
		Object[] params = {vo.getUserId()};
		
		int result = jdbc.update(query, params);
		return result;
	}

	public ArrayList<Member> selectAllMember(JdbcTemplate jdbc) {
		String query = "select * from member";
		List list =  jdbc.query(query, new MemberRowMapper());
		return (ArrayList<Member>) list;
	}

}
