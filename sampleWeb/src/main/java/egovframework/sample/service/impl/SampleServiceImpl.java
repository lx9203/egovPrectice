package egovframework.sample.service.impl;

import egovframework.sample.service.impl.SampleService;

public class SampleServiceImpl implements SampleService {
	public SampleServiceImpl() throws Exception {
		System.out.println("SampleService ===> Sample 생성");
	}
	
	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleService#insertSample()
	 */
	public void insertSample() throws Exception {
		System.out.println("SampleService ===> Sample 등록");
	}

	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleService#updateSample()
	 */
	public void updateSample() throws Exception {
		System.out.println("SampleService ===> Sample 수정");
	}

	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleService#deleteSample()
	 */
	public void deleteSample() throws Exception {
		System.out.println("SampleService ===> Sample 삭제");
	}

	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleService#selectSample()
	 */
	public void selectSample() throws Exception {
		System.out.println("SampleService ===> Sample 상세 조회");
	}

	/* (non-Javadoc)
	 * @see egovframework.sample.service.impl.SampleService#selectSampleList()
	 */
	public void selectSampleList() throws Exception {
		System.out.println("SampleService ===> Sample 목록조회");
	}
}
