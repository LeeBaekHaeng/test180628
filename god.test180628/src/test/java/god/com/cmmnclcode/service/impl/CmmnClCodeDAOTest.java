package god.com.cmmnclcode.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.rte.fdl.string.EgovDateUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.com.cmmnclcode.service.CmmnClCodeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:egovframework/spring/com/**/context-*.xml")
public class CmmnClCodeDAOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Resource(name = "CmmnClCodeDAO")
	private CmmnClCodeDAO cmmnClCodeDAO;

	// @Test
	public void test() {
		// fail("Not yet implemented");
	}

	// @Test
	public void selectCmmnClCodeList() throws Exception {
		CmmnClCodeVO vo = new CmmnClCodeVO();
		vo.setUseAt("Y");
		// vo.setUseAt("N");
		vo.setClCodeNm("공통");

		List<EgovMap> results = cmmnClCodeDAO.selectCmmnClCodeList(vo);

		egovLogger.debug("results=" + results);

		results.forEach(result -> {
			egovLogger.debug("result=" + result);
			egovLogger.debug("clCode=" + result.get("clCode"));
			egovLogger.debug("clCodeNm=" + result.get("clCodeNm"));
		});
	}

	@SuppressWarnings("unchecked")
	// @Test
	public void selectCmmnClCode() throws Exception {
		CmmnClCodeVO vo = new CmmnClCodeVO();
		// vo.setClCode("EFC");
		vo.setClCode("AAA");
		// vo.setClCode("AAB");

		EgovMap result = cmmnClCodeDAO.selectCmmnClCode(vo);

		egovLogger.debug("result=" + result);

		egovLogger.debug("frstRegistPnttm=" + result.get("frstRegistPnttm"));
		Timestamp frstRegistPnttmTimestamp = (Timestamp) result.get("frstRegistPnttm");
		Date frstRegistPnttmDate = (Date) result.get("frstRegistPnttm");
		egovLogger.debug("frstRegistPnttmTimestamp=" + EgovDateUtil.toString(frstRegistPnttmTimestamp, "", null));
		egovLogger.debug("frstRegistPnttmDate=" + EgovDateUtil.toString(frstRegistPnttmDate, "", null));

		result.forEach((k, v) -> {
			egovLogger.debug("k=" + k);
			egovLogger.debug("v=" + v);
		});
	}

	// @Test
	public void insertCmmnClCode() throws Exception {
		CmmnClCodeVO vo = new CmmnClCodeVO();

		vo.setClCode("AAA");
		vo.setClCodeNm("에이 에이 에이");

		// vo.setClCode("AAB");
		// vo.setClCodeNm("에이 에이 비");

		vo.setUseAt("Y");
		vo.setFrstRegistPnttm(EgovDateUtil.getCurrentDateTimeAsString());
		vo.setFrstRegisterId("SYSTEM2");

		int result = cmmnClCodeDAO.insertCmmnClCode(vo);

		egovLogger.debug("result=" + result);
	}

	// @Test
	public void insertCmmnClCode2() throws Exception {
		CmmnClCodeVO vo = new CmmnClCodeVO();

		vo.setClCode("AAA");
		vo.setClCodeNm("에이 에이 에이");

		// vo.setClCode("AAB");
		// vo.setClCodeNm("에이 에이 비");

		vo.setUseAt("Y");
		vo.setFrstRegistPnttm(EgovDateUtil.getCurrentDateTimeAsString());
		vo.setFrstRegisterId("SYSTEM2");

		int result = cmmnClCodeDAO.insertCmmnClCode2(vo);

		egovLogger.debug("result=" + result);
	}

	// @Test
	public void insertCmmnClCode3() throws Exception {
		CmmnClCodeVO vo = new CmmnClCodeVO();

		vo.setClCode("AAA");
		vo.setClCodeNm("에이 에이 에이");

		// vo.setClCode("AAB");
		// vo.setClCodeNm("에이 에이 비");

		vo.setUseAt("Y");
		// vo.setFrstRegistPnttm(EgovDateUtil.getCurrentDateTimeAsString());
		vo.setFrstRegistPnttm2(new Date());
		vo.setFrstRegisterId("SYSTEM2");

		int result = cmmnClCodeDAO.insertCmmnClCode3(vo);

		egovLogger.debug("result=" + result);
	}

	// @Test
	public void updateCmmnClCode() throws Exception {
		// String currentDateTimeAsString =
		// EgovDateUtil.getCurrentDateTimeAsString();
		String currentDateTimeAsString = EgovDateUtil.toString(new Date(), "", null);

		CmmnClCodeVO vo = new CmmnClCodeVO();

		vo.setClCode("AAA");
		vo.setClCodeNm("에이 에이 에이 수정 " + currentDateTimeAsString);

		// vo.setClCode("AAB");
		// vo.setClCodeNm("에이 에이 비");

		vo.setClCodeDc(vo.getClCodeNm() + " 설명");

		// vo.setUseAt("Y");
		vo.setUseAt("N");
		vo.setLastUpdtPnttm(currentDateTimeAsString);
		vo.setLastUpdusrId("SYSTEM2");

		int result = cmmnClCodeDAO.updateCmmnClCode(vo);

		egovLogger.debug("result=" + result);
	}

	// @Test
	public void updateCmmnClCodeUseAt() throws Exception {
		// String currentDateTimeAsString =
		// EgovDateUtil.getCurrentDateTimeAsString();
		String currentDateTimeAsString = EgovDateUtil.toString(new Date(), "", null);

		CmmnClCodeVO vo = new CmmnClCodeVO();

		vo.setClCode("AAA");
		vo.setClCodeNm("에이 에이 에이 수정 " + currentDateTimeAsString);

		// vo.setClCode("AAB");
		// vo.setClCodeNm("에이 에이 비");

		vo.setClCodeDc(vo.getClCodeNm() + " 설명");

		// vo.setUseAt("Y");
		vo.setUseAt("N");
		vo.setLastUpdtPnttm(currentDateTimeAsString);
		vo.setLastUpdusrId("SYSTEM2");

		int result = cmmnClCodeDAO.updateCmmnClCodeUseAt(vo);

		egovLogger.debug("result=" + result);
	}

}
