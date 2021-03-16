package com.lagou.springboot01_demo;

import com.lagou.controller.HelloController;
import com.lagou.pojo.MyProperties;
import com.lagou.pojo.Person;
import com.lagou.pojo.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)  // 测试启动器，并加载spring boot测试注解
@SpringBootTest // 标记该类为spring boot单元测试类，并加载项目的applicationContext上下文环境
class SpringbootDemoApplicationTests {
	//入门案例测试
	@Autowired
	private HelloController helloController;

    /*
      配置文件properties配置测试
     */
	@Autowired
	private Person person;

    /*
      @Value进行测试
     */
	@Autowired
	private Student student;

	/*
      @propertySource进行测试
     */
	@Autowired
	private MyProperties myProperties;

	/*
	  @Configuration进行测试
	 */
	@Autowired
	private ApplicationContext context;

	/*
	  测试随机数及参数间引用
	 */
	@Value("${tom.description}")
	private String description;

	@Test
	public void contextLoad1() {
		String demo = helloController.demo();
		System.out.println(demo);
	}

	@Test
	public void configurationTest() {
		System.out.println(person);
	}

	@Test
	public void studentTest() {
		System.out.println(student);
	}

	@Test
	public void myPropertiesTest() {
		System.out.println(myProperties);
	}

	@Test
	public void iocTest() {
		System.out.println(context.containsBean("iservice"));
	}

	@Test
	public void placeholderTest() {
		System.out.println(description);
	}

    /*
     测试随机数及参数间引用
    */
//    @Autowired
//    private SimpleBean simpleBean;
//
//
//    @Test
//    void zdyStarterTest(){
//        System.out.println(simpleBean);
//    }
}
