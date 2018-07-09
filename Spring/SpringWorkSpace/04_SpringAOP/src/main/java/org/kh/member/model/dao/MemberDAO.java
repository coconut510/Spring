package org.kh.member.model.dao;

import java.sql.Connection;

import org.kh.member.model.vo.Member;
import org.springframework.jdbc.core.JdbcTemplate;

public interface MemberDAO {
	public Member selectOneMember(JdbcTemplate jdbc, Member vo);
	public int logout(JdbcTemplate jdbc, Member m);
	public int updateMember(JdbcTemplate jdbc, Member vo);
}
