package com.cg.donor.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.util.DBConnection;

public class DonorDaoImpl implements IDonorDao {

	@Override
	public String addDonor(DonorBean donor) throws DonorException {
		//
		try {
			Connection connection=DBConnection.getConnection();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void viewDonorDetails(String donorId) throws DonorException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List retrieveAll() throws DonorException {
		// TODO Auto-generated method stub
		return null;
	}

}
