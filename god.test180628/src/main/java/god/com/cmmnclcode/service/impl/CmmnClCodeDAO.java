package god.com.cmmnclcode.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import god.com.cmmnclcode.service.CmmnClCodeVO;

@Repository("CmmnClCodeDAO")
public class CmmnClCodeDAO extends EgovComAbstractDAO {

	@SuppressWarnings("unchecked")
	public List<EgovMap> selectCmmnClCodeList(CmmnClCodeVO vo) throws Exception {
		return (List<EgovMap>) list("CmmnClCodeDAO.selectCmmnClCodeList", vo);
	}

}
