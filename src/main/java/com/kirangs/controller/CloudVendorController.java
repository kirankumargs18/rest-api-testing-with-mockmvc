/**
 * @author kiran
 * */
package com.kirangs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirangs.entity.CloudVendor;
import com.kirangs.service.CloudVendorService;

@RestController
@RequestMapping("/api/v1/cloud-vendor")
public class CloudVendorController {

	@Autowired
	private CloudVendorService cloudVendorService;

//	private CloudVendorService cloudVendorService;
//
//	public CloudVendorController(CloudVendorService cloudVendorService) {
//		super();
//		this.cloudVendorService = cloudVendorService;
//	}

	@GetMapping
	public ResponseEntity<List<CloudVendor>> fetchAllCloudVendor() {

		return new ResponseEntity<List<CloudVendor>>(cloudVendorService.getAllCloudVendor(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CloudVendor> saveCloudVendor(@RequestBody CloudVendor cloudVendor) {

		return new ResponseEntity<CloudVendor>(cloudVendorService.createCloudVendor(cloudVendor), HttpStatus.CREATED);
	}

	@GetMapping("/{vendorId}")
	public ResponseEntity<CloudVendor> fetchCloudVendorById(@PathVariable String vendorId) {

		return new ResponseEntity<CloudVendor>(cloudVendorService.getCloudVendor(vendorId), HttpStatus.OK);
	}

	@PutMapping("/{vendorId}")
	public ResponseEntity<CloudVendor> updateCloudVendor(@PathVariable String vendorId,
			@RequestBody CloudVendor cloudVendor) {

		return new ResponseEntity<CloudVendor>(cloudVendorService.updateCloudVendor(vendorId, cloudVendor),
				HttpStatus.OK);
	}

	@DeleteMapping("/{vendorId}")
	public ResponseEntity<String> removeCloudVendor(@PathVariable String vendorId) {

		return new ResponseEntity<String>(cloudVendorService.deleteCloudVendor(vendorId), HttpStatus.OK);
	}

}
