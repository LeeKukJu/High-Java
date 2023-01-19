package dao;

import java.sql.SQLException;
import java.util.Map;

public interface IMemberDAO {

	//로그인 id-pw검증
	//예외가 발생한 경우 dao에서 예외를 처리하지 않고 서버에서 예외를 처리하도록 throws
	public String loginChk(Map<String, Object> map) throws SQLException;

}
