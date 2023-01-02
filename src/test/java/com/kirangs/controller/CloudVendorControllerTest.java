/**
 * @author kiran
 * */
package com.kirangs.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kirangs.entity.CloudVendor;
import com.kirangs.service.CloudVendorService;


@WebMvcTest(value = CloudVendorController.class)
class CloudVendorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CloudVendorService cloudVendorService;

	private CloudVendor cloudVendorOne;

	private CloudVendor cloudVendorTwo;

	private List<CloudVendor> cloudVendorList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {

		cloudVendorOne = new CloudVendor("1", "Amazon", "USA", "xxxxx");
		cloudVendorTwo = new CloudVendor("2", "GCP", "UK", "xxxxx");

		cloudVendorList.addAll(Arrays.asList(cloudVendorOne, cloudVendorTwo));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFetchAllCloudVendor() throws Exception {
		
		when(cloudVendorService.getAllCloudVendor()).thenReturn(cloudVendorList);
		
		this.mockMvc.perform(get("/api/v1/cloud-vendor"))
		.andDo(print())
		.andExpect(status().isOk());

	}

	@Test
	void testSaveCloudVendor() throws Exception {
		
		//converting object to json
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
//		String requestJson = ow.writeValueAsString(cloudVendorOne);
		
		ObjectMapper objectMapper=new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(cloudVendorOne);
		
		when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn(cloudVendorOne);
		
		this.mockMvc.perform(post("/api/v1/cloud-vendor")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
		.andDo(print())
		.andExpect(status().is(201));
		
	}

	@Test
	void testFetchCloudVendorById() throws Exception {

		when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);

		// mocking url
		this.mockMvc.perform(get("/api/v1/cloud-vendor/1"))
		.andDo(print())
		.andExpect(status().isOk());
	}

	@Test
	void testUpdateCloudVendor() throws Exception {
		
		//converting object to json
//		ObjectMapper mapper = new ObjectMapper();
//		String requestJson = mapper.writeValueAsString(cloudVendorOne);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(cloudVendorOne);
		
		when(cloudVendorService.updateCloudVendor("1", cloudVendorOne)).thenReturn(cloudVendorOne);
		
		this.mockMvc.perform(put("/api/v1/cloud-vendor/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson))
		.andDo(print())
		.andExpect(status().isOk());

	}

	@Test
	void testRemoveCloudVendor() throws Exception {
		
		when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Deleted Successfully");
		
		this.mockMvc.perform(delete("/api/v1/cloud-vendor/1"))
		.andDo(print())
		.andExpect(status().isOk());
		
	}

}
