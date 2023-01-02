/**
 * @author kiran
 * */
package com.kirangs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirangs.entity.CloudVendor;
import com.kirangs.exception.CloudVendorNotFoundException;
import com.kirangs.repository.CloudVendorRepository;
import com.kirangs.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

//	private CloudVendorRepository cloudVendorRepository;
//
//	// constructor type DI
//	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
//		this.cloudVendorRepository = cloudVendorRepository;
//	}

	@Autowired
	private CloudVendorRepository cloudVendorRepository;

	/**
	 * @description : Retrievs all cloud vendors
	 * @return : List of vendors
	 * */
	@Override
	public List<CloudVendor> getAllCloudVendor() {

		List<CloudVendor> cloudVendors = cloudVendorRepository.findAll();
		return cloudVendors;
	}

	/**
	 * @description : creates cloud vendor
	 * @param : cloud vendor entity
	 * @return : created cloud vendor entity
	 * */
	@Override
	public CloudVendor createCloudVendor(CloudVendor cloudVendor) {

		CloudVendor savedCloudVendor = cloudVendorRepository.save(cloudVendor);
		return savedCloudVendor;
	}

	/**
	 * @description : Gets cloud vendor
	 * @param : cloud vendor id
	 * @return : cloud vendor entity
	 * @throws : CloudVendorNotFoundException
	 * */
	@Override
	public CloudVendor getCloudVendor(String vendorId) {

		Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
		if (optionalCloudVendor.isEmpty()) {
			throw new CloudVendorNotFoundException("Cloud vendor not found with ID : " + vendorId);
		}
		CloudVendor cloudVendor = optionalCloudVendor.get();
		return cloudVendor;
	}

	/**
	 * @description : Updates cloud vendor
	 * @param : cloud vendor id, cloud vendor entity
	 * @return : cloud vendor entity
	 * @throws : CloudVendorNotFoundException
	 * */
	@Override
	public CloudVendor updateCloudVendor(String vendorId, CloudVendor cloudVendor) {

		Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
		if (optionalCloudVendor.isEmpty()) {
			throw new CloudVendorNotFoundException("Cloud vendor not found with ID : " + vendorId);
		}
		CloudVendor updatedCloudVendor = optionalCloudVendor.get();
		updatedCloudVendor.setVendorId(cloudVendor.getVendorId());
		updatedCloudVendor.setVendorName(cloudVendor.getVendorName());
		updatedCloudVendor.setVendorAddress(cloudVendor.getVendorAddress());
		updatedCloudVendor.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
		return updatedCloudVendor;
	}

	/**
	 * @description : Deletes cloud vendor
	 * @param : cloud vendor id
	 * @return : String
	 * @throws : CloudVendorNotFoundException
	 * */
	@Override
	public String deleteCloudVendor(String vendorId) {

		Optional<CloudVendor> optionalCloudVendor = cloudVendorRepository.findById(vendorId);
		if (optionalCloudVendor.isEmpty()) {
			throw new CloudVendorNotFoundException("Cloud vendor not found with ID : " + vendorId);
		}
		cloudVendorRepository.deleteById(vendorId);
		return "Deleted Successfully";
	}

}
