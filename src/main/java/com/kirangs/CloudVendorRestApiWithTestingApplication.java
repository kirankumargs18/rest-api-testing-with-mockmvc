/**
 * @author kiran
 * */
package com.kirangs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cloud Vendor API"))
public class CloudVendorRestApiWithTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudVendorRestApiWithTestingApplication.class, args);
	}

}
