package god.com.cmmnclcode.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.com.cmmnclcode.service.CmmnClCodeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:egovframework/spring/com/**/context-*.xml")
public class CmmnClCodeDAOTest {

	protected Logger egovLogger = LoggerFactory.getLogger(getClass());

	@Resource(name = "CmmnClCodeDAO")
	private CmmnClCodeDAO cmmnClCodeDAO;

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	// @Test
	public void selectCmmnClCodeList() throws Exception {
		CmmnClCodeVO vo = new CmmnClCodeVO();
		vo.setUseAt("Y");

		List<EgovMap> results = cmmnClCodeDAO.selectCmmnClCodeList(vo);

		egovLogger.debug("results=" + results);

		results.forEach(result -> {
			egovLogger.debug("result=" + result);
			egovLogger.debug("clCode=" + result.get("clCode"));
			egovLogger.debug("clCodeNm=" + result.get("clCodeNm"));
		});
	}

	@SuppressWarnings("unchecked")
	@Test
	public void selectCmmnClCode() throws Exception {
		CmmnClCodeVO vo = new CmmnClCodeVO();
		vo.setClCode("EFC");

		EgovMap result = cmmnClCodeDAO.selectCmmnClCode(vo);

		egovLogger.debug("result=" + result);

		result.forEach((k, v) -> {
			egovLogger.debug("k=" + k);
			egovLogger.debug("v=" + v);
		});
	}

}
