package test1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import test1.model.TestModel;

public interface TestMapper {
	
	List<TestModel> finAll();
	
	TestModel finOne(int id);
	
	void update(TestModel testModel);
	
	void add(TestModel testModel);
	
	void delete(int id);
	
	List<TestModel> fin(TestModel testModel);

	List<TestModel> findPages(int startPos);
	
	int finCount();
	
	void delStandardInfo(Integer[] d);
	  
	TestModel getById(long id);
	
}
