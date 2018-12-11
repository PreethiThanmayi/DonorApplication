package com.cg.donor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.dao.DonorDaoImpl;
import com.cg.donor.dao.IDonorDao;
import com.cg.donor.exception.DonorException;

public class DonorServiceImpl implements IDonorService{

	IDonorDao donordao=new DonorDaoImpl();
	
	@Override
	public String addDonor(DonorBean donor) throws DonorException {
		String donorSeq;
		donorSeq=donordao.addDonor(donor);
		return null;
	}

	@Override
	public void viewDonorDetails(String donorId) throws DonorException {
		//donordao.
	}

	@Override
	public List retrieveAll() throws DonorException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void validateDonor(DonorBean bean) throws DonorException
	{
		List<String> validationErrors=new ArrayList<String>();
		if(!(isValidName(bean.getDonorName()))) {
			validationErrors.add("\n donor name sholud be in alphabets and minimum 3 characters long");
		}
		
		if(!(isValidAddress(bean.getDonorName())))
		{
			validationErrors.add("\n address should be greater than 5 characters");
			
		}
		
		if(!(isValidPhoneNumber(bean.getPhoneNumber())))
		{
			validationErrors.add("\n phone number should be 10 digits");
			
		}
		
		if(!(isValidAmount(bean.getDonationAmount()))) {
			validationErrors.add("\n Amount should be a positive value");
			
		}
		
		if(!validationErrors.isEmpty()) {
			throw new DonorException(validationErrors +"");
		}
	}
	
	private boolean isValidAmount(double donationAmount)
	{
		return donationAmount>0;
		
	}

	private boolean isValidPhoneNumber(String phoneNumber)
	{
		Pattern phonePattern=Pattern.compile("^[6-9]{1}[0-9]{9}");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return false;
		
	}

	private boolean isValidAddress(String address)
	{
		
		return (address.length()>6);
		
	}

	private boolean isValidName(String donorName)
	{
		Pattern namePattern=Pattern.compile("^[A-Z a-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(donorName);
		return false;
		
	}
	
	private boolean validateDonorId(String donorId)
	{
		Pattern idPattern=Pattern.compile("[0-9]{1,4}");
		Matcher idMatcher=idPattern.matcher(donorId);
		if(idMatcher.matches())
			return true;
		else
			return false;
		
	}
	
	

}
