package br.com.assoni.mars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpiritApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiritApplication.class, args);
	}
}
