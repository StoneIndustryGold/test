package test1.appConfig;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages="test1") 
@EnableWebMvc
@MapperScan("test1.mapper")//扫描mapper包
@PropertySource("classpath:jdbc.properties")//调用配置文件
@EnableTransactionManagement//开启事务支持
public class AppConfig extends WebMvcConfigurerAdapter{
	@Override//jsp 路径
	public void configureViewResolvers(ViewResolverRegistry registry){
		registry.jsp("/WEB-INF/jsp/",".jsp");
	}
	
	@Bean//jdbc链接
	public DataSource dataSource(Environment env) {
		DriverManagerDataSource dmd=new DriverManagerDataSource(
				env.getProperty("jdbc.url"),
				env.getProperty("jdbc.username"),
				env.getProperty("jdbc.password"));
		dmd.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		return dmd;
	}
	@Bean//mybatis工厂
	public SqlSessionFactoryBean bean(DataSource dataSource) {
		SqlSessionFactoryBean sqlbean=new SqlSessionFactoryBean();
		sqlbean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sqlbean.setDataSource(dataSource);
		return sqlbean;
	}
	@Bean//密码加密
	public PasswordEncoder passwordEncoder() {
		return	 new BCryptPasswordEncoder();
	}
	   //获取静态资源如css,js，图片等
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
