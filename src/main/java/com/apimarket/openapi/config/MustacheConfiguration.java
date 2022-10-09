package com.apimarket.openapi.config;

import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.samskivert.mustache.Mustache;

@Configuration
public class MustacheConfiguration {

	@Bean
	public Mustache.Compiler mustacheCompiler(
	  Mustache.TemplateLoader templateLoader, 
	  Environment environment) {

	    MustacheEnvironmentCollector collector
	      = new MustacheEnvironmentCollector();
	    collector.setEnvironment(environment);

	    return Mustache.compiler()
	      .defaultValue("")
	      .withLoader(templateLoader)
	      .withCollector(collector);
	}
	
}
