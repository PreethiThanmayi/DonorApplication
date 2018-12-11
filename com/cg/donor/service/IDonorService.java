package com.cg.donor.service;

import java.util.List;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;

public interface IDonorService {
	 public String addDonor(DonorBean donor)throws DonorException;
	 public void viewDonorDetails(String donorId)throws DonorException;
	 public List retrieveAll()throws DonorException;
	 
}
