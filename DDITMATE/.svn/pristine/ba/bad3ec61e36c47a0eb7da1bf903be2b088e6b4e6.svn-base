package mail.dao;

import java.util.List;
import java.util.Map;

import mail.vo.MailVO;

public interface IMailDao {
	
	/**
	 * mailVO에 담긴 데이터를 insert하기 위한 메서드
	 * @param mav DB에 insert할 데이터를 담은 VO 객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고 실패하면 0이 반환된다.
	 */
	public int insertMail(MailVO mav);
	
	/**
	 * mailVO에 담긴 데이터를 delete하기 위한 메서드
	 * @param mav delete할 객체를 담은 것
	 * @return 성공 1 실패 0
	 */
	public int deleteMail(int mailNo);
	
	public int updateMail(MailVO mav);
	
	/**
	 * 받는 사람 아이디를 체크하기 위한 메서드
	 * @param mailReceiver 존재여부를 체크할 회원 ID
	 * @return 받는 사람이 존재하면 true, 아니면 false를 리턴함
	 */
	public String checkMail(Map<String, Object> map);
	
	/**
	 * 보낸쪽지함을 조회하기 위한 메서드
	 * @return 보낸 쪽지 정보를 담은 list 객체
	 */
	public List<MailVO> SendAllList(String memId);
	
	
	/**
	 * 받은쪽지함을 조회하기 위한 메서드
	 * @return 
	 */
	public List<MailVO> receiveAllList(String memId);
	
	/**
	 * 쪽지 상세보기
	 * @param mav
	 * @return
	 */
	public MailVO getMail(int mailNo);

	
}
