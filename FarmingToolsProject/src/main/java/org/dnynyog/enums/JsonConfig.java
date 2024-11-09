package org.dnynyog.enums;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonConfig {

	public ObjectMapper objectmapper()
	{
		return new ObjectMapper()
				.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
}
