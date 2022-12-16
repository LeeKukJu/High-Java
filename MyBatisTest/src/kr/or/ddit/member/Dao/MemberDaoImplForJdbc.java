package kr.or.ddit.member.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDaoImplForJdbc implements IMemberDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insertMember(MemberVO mv) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "insert into mymember " + " (MEM_ID, MEM_NAME, mem_tel, mem_addr, reg_dt) "
					+ " values (?,?,?,?,sysdate)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());

			cnt = pstmt.executeUpdate(); // 성공적으로 됬으면 1리턴 아니면 0리턴

		} catch (SQLException ex) {
			throw new RuntimeException("회원정보 등록 중 예외발생했어요ㅠㅠ", ex);
		} finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public boolean checkMember(String memId) {

		boolean isExist = false;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " select count(*) as cnt from mymember " + " where mem_id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId); // 첫번째 ?에 memId 값 넣기

			rs = pstmt.executeQuery();

			int cnt = 0;

			while (rs.next()) {
				cnt = rs.getInt("CNT"); // CNT 또는 1
			}

			if (cnt > 0) {
				isExist = true;
			}

		} catch (SQLException ex) {
			throw new RuntimeException("회원정보 체크 중 예외발생했어요ㅠㅠ", ex);
		}

		return isExist;
	}

	@Override
	public int updateMemeber(MemberVO mv) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = " UPDATE mymember " + "    SET " + "        mem_name = ?, " + "        mem_tel = ?, "
					+ "        mem_addr = ? " + " WHERE " + "    mem_id = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new RuntimeException("회원정보 수정 중 예외발생했어요ㅠㅠ", ex);
		} finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		int cnt = 0;

		try {
			conn = JDBCUtil3.getConnection();

			String sql = "delete form mymember where mem_id = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			cnt = pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new RuntimeException("회원정보 삭제 중 예외발생했어요ㅠㅠ", ex);
		} finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}

		return cnt;
	}

	@Override
	public List<MemberVO> printAllMember() {

		List<MemberVO> memList = new ArrayList<MemberVO>();

		try {
			conn = JDBCUtil3.getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery("select * from mymember");

//			MemberVO mv = null;

			while (rs.next()) {
				MemberVO mv = new MemberVO();

				mv.setMemId(rs.getString("mem_id"));
				mv.setMemName(rs.getString("mem_name"));
				mv.setMemTel(rs.getString("mem_tel"));
				mv.setMemAddr(rs.getString("mem_addr"));

				memList.add(mv);
			}

		} catch (SQLException ex) {
			throw new RuntimeException("회원목록 조회 중 예외발생했어요ㅠㅠ", ex);
		} finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}

		return memList;
	}

	@Override
	public List<MemberVO> searchMember(MemberVO mv) {

		List<MemberVO> memList = new ArrayList<MemberVO>();

		try {
			conn = JDBCUtil3.getConnection();
			
			String sql = " select * from mymember " + 
					" where 1=1 ";
			
			if(mv.getMemId() != null && !mv.getMemId().equals("")) {
				sql += " and mem_id = ? ";
			}
			if(mv.getMemName() != null && !mv.getMemName().equals("")) {
				sql += " and mem_name = ? ";
			}
			if(mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				sql += " and mem_tel = ? ";
			}
			if(mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				sql += " and mem_addr like '%' || ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			int index = 1; // 물음표 위치
			
			if(mv.getMemId() != null && !mv.getMemId().equals("")) {
				pstmt.setString(index++, mv.getMemId());
			}
			if(mv.getMemName() != null && !mv.getMemName().equals("")) {
				pstmt.setString(index++, mv.getMemName());
			}
			if(mv.getMemTel() != null && !mv.getMemTel().equals("")) {
				pstmt.setString(index++, mv.getMemTel());
			}
			if(mv.getMemAddr() != null && !mv.getMemAddr().equals("")) {
				pstmt.setString(index++, mv.getMemAddr());
			}
			
			rs = pstmt.executeQuery();

//			MemberVO mv2 = null;

			while (rs.next()) {
				MemberVO mv2 = new MemberVO();

				mv2.setMemId(rs.getString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));

				memList.add(mv2);
			}

		} catch (SQLException ex) {
			throw new RuntimeException("회원목록 조회 중 예외발생했어요ㅠㅠ", ex);
		} finally {
			JDBCUtil3.close(conn, pstmt, pstmt, rs);
		}

		return memList;
	}

}
