/**
 * 
 */
package com.note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 * @created 2019年3月7日
 */
@SpringBootApplication
@EnableAutoConfiguration
public class MyDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyDemoApplication.class, args);
	}
}
