/**
 * @author kiran
 * */
package com.kirangs.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.kirangs.entity.CloudVendor;
import com.kirangs.exception.CloudVendorNotFoundException;
import com.kirangs.repository.CloudVendorRepository;
import com.kirangs.service.CloudVendorService;

@SpringBootTest
class CloudVendorServiceImplTest {

	@Autowired
	private CloudVendorService cloudVendorService;

	@MockBean
	private CloudVendorRepository cloudVendorRepository;

//	private AutoCloseable autoCloseable;

	private CloudVendor cloudVendor;

	@BeforeEach
	void setUp() throws Exception {

//		autoCloseable = MockitoAnnotations.openMocks(this);
		cloudVendor = new CloudVendor("1", "Amazon", "USA", "xxxxx");
	}

	@AfterEach
	void tearDown() throws Exception {

//		autoCloseable.close();
	}

	@Test
	void testGetAllCloudVendor() {

		List<CloudVendor> cloudVendors = List.of(cloudVendor);

		when(cloudVendorRepository.findAll()).thenReturn(cloudVendors);
		assertThat(cloudVendorService.getAllCloudVendor()).isEqualTo(cloudVendors);

	}

	@Test
	void testCreateCloudVendor() {

//		mock(CloudVendor.class);
//		mock(CloudVendorRepository.class);

		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo(cloudVendor);
	}

	@Test
	void testGetCloudVendor() {

		Optional<CloudVendor> optionalCloudVendor = Optional.of(cloudVendor);
		when(cloudVendorRepository.findById("1")).thenReturn(optionalCloudVendor);
		assertThat(cloudVendorService.getCloudVendor("1")).isEqualTo(optionalCloudVendor.get());
	}

	@Test
	void testUpdateCloudVendor() {

		Optional<CloudVendor> optionalCloudVendor = Optional.of(cloudVendor);
		when(cloudVendorRepository.findById("1")).thenReturn(optionalCloudVendor);
		assertThat(cloudVendorService.updateCloudVendor("1", cloudVendor)).isEqualTo(optionalCloudVendor.get());
	}

	@Test
	void testDeleteCloudVendor() {

		Optional<CloudVendor> optionalCloudVendor = Optional.of(cloudVendor);
		when(cloudVendorRepository.findById("1")).thenReturn(optionalCloudVendor);
		assertThat(cloudVendorService.deleteCloudVendor("1")).isEqualTo("Deleted Successfully");
	}

	@Test
	void testGetCloudVendorThrowsCloudVendorNotFoundException() {

		Exception exception = assertThrows(CloudVendorNotFoundException.class,
				() -> cloudVendorService.getCloudVendor("2"));
		assertEquals("Cloud vendor not found with ID : 2", exception.getMessage());
	}

	@Test
	void testUpdateCloudVendorThrowsCloudVendorNotFoundException() {

		Exception exception = assertThrows(CloudVendorNotFoundException.class,
				() -> cloudVendorService.updateCloudVendor("2", cloudVendor));
		assertEquals("Cloud vendor not found with ID : 2", exception.getMessage());
	}

	@Test
	void testDeleteCloudVendorThrowsCloudVendorNotFoundException() {

		Exception exception = assertThrows(CloudVendorNotFoundException.class,
				() -> cloudVendorService.deleteCloudVendor("2"));
		assertEquals("Cloud vendor not found with ID : 2", exception.getMessage());
	}

}
