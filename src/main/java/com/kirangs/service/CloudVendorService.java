/**
 * @author kiran
 * */
package com.kirangs.service;

import java.util.List;

import com.kirangs.entity.CloudVendor;

public interface CloudVendorService {

	List<CloudVendor> getAllCloudVendor();

	CloudVendor createCloudVendor(CloudVendor cloudVendor);

	CloudVendor getCloudVendor(String vendorId);

	CloudVendor updateCloudVendor(String vendorId, CloudVendor cloudVendor);

	String deleteCloudVendor(String vendorId);
	
}
