package test1.conrtoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test1.model.TestModel;
import test1.service.TestService;

@Controller
public class TestController {
	private TestService testService;
	
	@Autowired
	public TestController(TestService testService) {
		this.testService = testService;
	}

	//详情id查找
	@RequestMapping(method=RequestMethod.GET,value="/test/{id}")
	public String finOne(@PathVariable int id,
							Model model){
		
		TestModel tests=testService.finOne(id);
		model.addAttribute("tests",tests);
		return "test-details";
	}
	//模糊寻
	@RequestMapping(method=RequestMethod.GET,value="/test/fin")
	public String fin(@ModelAttribute TestModel testModel,
										Model model){
		
		System.out.println("测试模糊寻"+testModel.getName());
		
		List<TestModel> test=testService.fin(testModel);
		for(TestModel t:test){
			
			System.out.println(""+t);
		}
		
		model.addAttribute("tests",test);
		return "pages-list";
	}
	
	//修改数据
	@RequestMapping(method=RequestMethod.GET,value="/test/update/{id}")
	public String update(@PathVariable int id,Model model){
		TestModel tests=testService.finOne(id);
		
		model.addAttribute("tests",tests);
		System.out.println("测试三"+id);
		return "test-update";
	}
	//修改
	@RequestMapping(method=RequestMethod.POST,value="/test/update/{id}")
	public String updatePost(@ModelAttribute TestModel testModel){
		System.out.println("修改"+testModel.getName());
		testService.update(testModel);
		return "redirect:/test";
	}
	//添加
	@RequestMapping(method=RequestMethod.GET,value="/test/add")
	public String add(){
		System.out.println("添加方法");
		return "test-update";
	}
	//添加
	@RequestMapping(method=RequestMethod.POST,value="/test/add")
	public String addTest(@ModelAttribute TestModel testModel){
		testService.add(testModel);
		
		return "redirect:/Pages";
	}
	//删除
	@RequestMapping(method=RequestMethod.POST,value="/test/delete/{id}")
	public String delete(@PathVariable int id){
		
		testService.delete(id);
		
		return "redirect:/Pages";
	}
	//分页查询
	@RequestMapping(method=RequestMethod.GET,value="/Pages")
	public String findPages(Model model){		
		int startPos=0;//从第几页开始
		int rownum=0; 
		List<TestModel> tests=testService.findPages(startPos);
		System.out.println("下一页a"+rownum);
		model.addAttribute("tests", tests);
		model.addAttribute("rownum", rownum);
		return "pages-list";
	}
	@RequestMapping(method=RequestMethod.GET,value="/pageDown/{rownum}")
	public String pageDown(@ModelAttribute TestModel testModel,
						@PathVariable int rownum,Model model){				
		int id=testService.finCount();	
				if(rownum >=0 && (rownum)*4 <id){																	
					int startPos=rownum*4;
					System.out.println("第几页"+startPos);
						List<TestModel> tests=testService.findPages(startPos);			
						model .addAttribute("tests", tests);
						model.addAttribute("rownum", rownum);
						model.addAttribute("id",id );
						return "pages-list";
						
				}
		return "redirect:/Pages";
	}
	@RequestMapping("/peopleSelect")
    @ResponseBody
    public TestModel peopleSelect(@RequestBody Map<String,String> map) {
        //使用map.get方法得到JSON中id对应的值
        long id = Long.parseLong(map.get("id"));
        //查找对应id的用户信息
        System.out.println("js的"+id);
        TestModel people = testService.getById(id);
        //返回用户信息，要使用@ResponseBody将返回值转换为JSON
        
        return people;//直接返回到了当前查找的页面
    }
	
}
