package mail.dao;

import java.util.List;
import java.util.Map;

import common.dao.MyBatisDao;
import mail.vo.MailVO;

public class MailDaoImpl extends MyBatisDao implements IMailDao {

	private static IMailDao mailDao;
	
	private MailDaoImpl() {
	}
	
	public static IMailDao getInstance() {
		if(mailDao == null) {
			mailDao = new MailDaoImpl();
		}
		return mailDao;
	}
			
	@Override
	public int insertMail(MailVO mav) {
		return insert("mail.insertMail",mav);
	}

	@Override
	public int deleteMail(int mailNo) {
		return delete("mail.deleteMail", mailNo);
	}
	
	@Override
	public int updateMail(MailVO mav) {
		return update("mail.updateMail", mav);
	}

	@Override
	public String checkMail(Map<String, Object> map) {
		return selectOne("mail.checkMail");
	}

	@Override
	public List<MailVO> SendAllList(String memId) {
		List<MailVO> mailList = selectList("mail.sendAllList", memId);
		return mailList;
	}

	@Override
	public List<MailVO> receiveAllList(String memId) {
		List<MailVO> mailList = selectList("mail.receiveAllList",memId);
		return mailList;
	}

	@Override
	 public MailVO getMail(int mailNo){
		return selectOne("mail.getMail", mailNo);
	}


	
}
