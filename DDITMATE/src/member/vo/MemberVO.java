package member.vo;

import java.io.File;

public class MemberVO {
	
	private String memId;
	private String memPw;
	private String memName;
	private String memEmail;
	private String memBirth;
	private String memTel;
	private String memDate;
	private String memNick;
	private String memIntro;
	private File memPic;
	
	public MemberVO() {
	}

	public MemberVO(String memId, String memPw) {
		this.memId = memId;
		this.memPw = memPw;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemDate() {
		return memDate;
	}

	public void setMemDate(String memDate) {
		this.memDate = memDate;
	}

	public String getMemNick() {
		return memNick;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}

	public String getMemIntro() {
		return memIntro;
	}

	public void setMemIntro(String memIntro) {
		this.memIntro = memIntro;
	}

	public File getMemPic() {
		return memPic;
	}

	public void setMemPic(File memPic) {
		this.memPic = memPic;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memEmail=" + memEmail
				+ ", memBirth=" + memBirth + ", memTel=" + memTel + ", memDate=" + memDate + ", memNick=" + memNick
				+ "]";
	}
	
	
	
}
