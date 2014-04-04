package com.chrylis.spring_examples.spring_generic_injection_failure;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Launcher {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Launcher.class).profiles("nongeneric").run(args);
	}
}
