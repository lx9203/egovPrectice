package egovframework.lab.aop.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.lab.aop.common.BizException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:META-INF/spring/context-common.xml",
		"classpath*:META-INF/spring/context-emp.xml", "classpath*:META-INF/spring/context-aspectj-annotation.xml",
		"classpath*:META-INF/spring/context-advice-xml.xml" })
public class EmpServiceTest {

	// TODO [Step 1-8, 2-8] EmpServiceTest 작성
	@Resource(name = "xmlEmpService")
	EmpService empService;

	public EmpVO makeVO() {
		return makeVO(101);
	}

	public EmpVO makeVO(int empNo) {
		EmpVO vo = new EmpVO();
		vo.setEmpNo(empNo);
		vo.setEmpName("홍길동" + empNo);
		vo.setJob("개발자");
		return vo;
	}

	public void checkResult(EmpVO vo, EmpVO resultVO) {
		assertNotNull(resultVO);
		assertEquals(vo.getEmpNo(), resultVO.getEmpNo());
		assertEquals(vo.getEmpName(), resultVO.getEmpName());
		assertEquals(vo.getJob(), resultVO.getJob());
	}

	@Test
	public void testInsetEmp() throws Exception {
		EmpVO vo = makeVO();
		empService.insertEmp(vo);
		EmpVO resultVO = empService.selectEmp(vo);
		checkResult(vo, resultVO);
	}

	@Test
	public void testUpdateEmp() throws Exception {
		EmpVO vo = makeVO(102);
		empService.insertEmp(vo);
		vo.setEmpName("홍길순");
		vo.setJob("설계자");
		empService.updateEmp(vo);
		EmpVO resultVO = empService.selectEmp(vo);
		checkResult(vo, resultVO);
	}

	@Test
	public void testDeleteEmp() throws Exception {
		EmpVO vo = makeVO(103);
		empService.insertEmp(vo);
		empService.deleteEmp(vo);
		try {
			@SuppressWarnings("unused")
			EmpVO resultVO = empService.selectEmp(vo);
			fail("Biz Excpetion 이 발생해야 합니다.");

		} catch (Exception e) {
			assertNotNull(e);
			assertTrue(e instanceof BizException);
			assertEquals("에러가 발생했습니다.", e.getMessage());
			assertEquals("no data found!", e.getCause().getMessage());
		}

	}
	
	@Test
	public void testSelectEmpList() throws Exception {
		List<EmpVO> resultList = empService.selectEmpList();
		int firstListSize = resultList.size();
		assertEquals(1, resultList.get(0).getEmpNo());
		EmpVO empVO = new EmpVO();
		empVO.setEmpNo(1);
		
		empService.deleteEmp(empVO);
		resultList = empService.selectEmpList();
		assertEquals(firstListSize -1, resultList.size());
		assertEquals(2, resultList.get(0).getEmpNo());
		assertEquals("EmpName 2", resultList.get(0).getEmpName());
		assertEquals("SALESMAN", resultList.get(0).getJob());
		
	}
}
