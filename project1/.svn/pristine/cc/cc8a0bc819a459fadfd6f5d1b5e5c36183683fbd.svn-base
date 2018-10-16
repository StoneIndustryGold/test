package test1.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test1.mapper.TestMapper;
import test1.model.TestModel;

@Service
public class TestServiceImpl implements test1.service.TestService {
	private TestMapper testMapper;
	
	@Autowired
	public TestServiceImpl(TestMapper testMapper) {
		this.testMapper = testMapper;
	}

	public List<TestModel> finAll() {
		// TODO Auto-generated method stub
		return testMapper.finAll();
	}

	public TestModel finOne(int id) {
		// TODO Auto-generated method stub
		return testMapper.finOne(id);
	}

	public void update(TestModel testModel) {
		testMapper.update(testModel);
		
	}

	public void add(TestModel testModel) {
		testMapper.add(testModel);
		
	}

	public void delete(int id) {
		testMapper.delete(id);
		
	}

	public List<TestModel> fin(TestModel testModel) {
		// TODO Auto-generated method stub
		return testMapper.fin(testModel);
	}

	@Override
	public List<TestModel> findPages(int startPos) {
		// TODO Auto-generated method stub
		return testMapper.findPages(startPos);
	}

	@Override
	public int finCount() {
		
		return testMapper.finCount();
	}

	@Override
	public void delStandardInfo(Integer[] d) {
		testMapper.delStandardInfo(d);
		
	}

	@Override
	public TestModel getById(long id) {
		return testMapper.getById(id);
	}

	


}
