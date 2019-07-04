package egovframework.lab.ioc.service.impl;

import java.util.List;

import egovframework.lab.ioc.service.EmpService;
import egovframework.lab.ioc.service.EmpVO;

public class XmlEmpServiceImpl implements EmpService {
    
	private XmlEmpDAO empDAO;
	
	public void setEmpDAO(XmlEmpDAO empDAO){
		this.empDAO = empDAO;
	}
	
	@Override
	public void insertEmp(EmpVO empVO) throws Exception {
		empDAO.insertEmp(empVO);
	}

	@Override
	public void updateEmp(EmpVO empVO) throws Exception {
		empDAO.updateEmp(empVO);
	}

	@Override
	public void deleteEmp(EmpVO empVO) throws Exception {
		empDAO.updateEmp(empVO);
	}

	@Override
	public EmpVO selectEmp(EmpVO empVO) throws Exception {
		EmpVO resultVO;
		resultVO = empDAO.selectEmp(empVO);
		
		if(resultVO == null) {
			throw new Exception("no data found!");
		}
		
		return resultVO;
	}

	@Override
	public List<EmpVO> selectEmpList() throws Exception {
		return empDAO.selectEmpList();
	}
	
}
