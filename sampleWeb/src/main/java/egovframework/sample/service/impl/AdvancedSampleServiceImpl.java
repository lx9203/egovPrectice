package egovframework.sample.service.impl;

public class AdvancedSampleServiceImpl {
	
	public AdvancedSampleServiceImpl() throws Exception {
		System.out.println("SampleService ===> Sample 생성");
	}
	21
	public void addSample() throws Exception {
		System.out.println("SampleService ===> Sample 등록");
	}

	public void updateSample() throws Exception {
		System.out.println("SampleService ===> Sample 수정");
	}

	public void removeSample() throws Exception {
		System.out.println("SampleService ===> Sample 삭제");
	}

	public void getSample() throws Exception {
		System.out.println("SampleService ===> Sample 상세 조회");
	}

	public void getSampleList() throws Exception {
		System.out.println("SampleService ===> Sample 목록조회");
	}
}
