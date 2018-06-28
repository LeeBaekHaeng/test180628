package god.com.cmmnclcode.service;

import egovframework.com.cmm.ComDefaultVO;

@SuppressWarnings("serial")
public class CmmnClCodeVO extends ComDefaultVO {

	private String clCode;
	private String clCodeNm;
	private String clCodeDc;
	private String useAt;
	private String frstRegistPnttm;
	private String frstRegisterId;
	private String lastUpdtPnttm;
	private String lastUpdusrId;

	public String getClCode() {
		return clCode;
	}

	public void setClCode(String clCode) {
		this.clCode = clCode;
	}

	public String getClCodeNm() {
		return clCodeNm;
	}

	public void setClCodeNm(String clCodeNm) {
		this.clCodeNm = clCodeNm;
	}

	public String getClCodeDc() {
		return clCodeDc;
	}

	public void setClCodeDc(String clCodeDc) {
		this.clCodeDc = clCodeDc;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public String getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	public void setFrstRegistPnttm(String frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	public String getLastUpdtPnttm() {
		return lastUpdtPnttm;
	}

	public void setLastUpdtPnttm(String lastUpdtPnttm) {
		this.lastUpdtPnttm = lastUpdtPnttm;
	}

	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

}
