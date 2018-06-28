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

	public EgovMap selectCmmnClCode(CmmnClCodeVO vo) throws Exception {
		return (EgovMap) select("CmmnClCodeDAO.selectCmmnClCode", vo);
	}

	public int insertCmmnClCode(CmmnClCodeVO vo) {
		try {
			insert("CmmnClCodeDAO.insertCmmnClCode", vo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	public int insertCmmnClCode2(CmmnClCodeVO vo) {
		return update("CmmnClCodeDAO.insertCmmnClCode2", vo);
	}

	public int insertCmmnClCode3(CmmnClCodeVO vo) {
		return update("CmmnClCodeDAO.insertCmmnClCode3", vo);
	}

	public int updateCmmnClCode(CmmnClCodeVO vo) {
		return update("CmmnClCodeDAO.updateCmmnClCode", vo);
	}

	public int updateCmmnClCodeUseAt(CmmnClCodeVO vo) {
		return update("CmmnClCodeDAO.updateCmmnClCodeUseAt", vo);
	}

}
