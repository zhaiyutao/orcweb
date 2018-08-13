package com.zhaiyt.ocr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <启动类>
 * @author ASUS
 *
 */
@SpringBootApplication
public class OrcwebApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OrcwebApplication.class, args);
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// 注意这里要指向原先用main方法执行的Application启动类
		return builder.sources(OrcwebApplication.class);
	}*/
}
