package cn.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.bdqn.dao")
@SpringBootApplication
public class Springbootdemo03Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo03Application.class, args);
	}
}
