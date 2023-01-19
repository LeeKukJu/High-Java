package mail.service;

import java.util.List;
import java.util.Map;

import mail.dao.IMailDao;
import mail.dao.MailDaoImpl;
import mail.vo.MailVO;

public class MailServiceImpl implements IMailService{
	
	private IMailDao mailDao;
	
	private static IMailService mailService;
	
	private MailServiceImpl() {
		mailDao = MailDaoImpl.getInstance();
	}
	
	public static IMailService getInstance() {
		if(mailService == null) {
			mailService = new MailServiceImpl();
		}
		return mailService;
	}

	@Override
	public int registerMail(MailVO mav) {
		return mailDao.insertMail(mav);
	}

	@Override
	public int removeMail(int mailNo) {
		return mailDao.deleteMail(mailNo);
	}

	@Override
	public int modifyMessage(MailVO mav) {
		return mailDao.updateMail(mav);
	}

	@Override
	public String checkMail(Map<String, Object> map) {
		return mailDao.checkMail(map);
	}

	@Override
	public List<MailVO> SendAllList(String memId) {
		return mailDao.SendAllList(memId);
	}

	@Override
	public List<MailVO> receiveAllList(String memId) {
		return mailDao.receiveAllList(memId);
	}

	@Override
	public MailVO getMail(int mailNo){
		return mailDao.getMail(mailNo);
	}



	

}
