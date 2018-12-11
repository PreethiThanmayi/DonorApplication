package com.cg.donor.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.service.DonorServiceImpl;
import com.cg.donor.service.IDonorService;

public class DonorMain {
	static Scanner sc=new Scanner(System.in);
	static DonorServiceImpl donorServiceImpl=null;
	static IDonorService donorService=null;
	
	public static void main(String[] args) {
		
		DonorBean donorBean=null;
		
		String donorId=null;
		int option=0;
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("Icare capegemini trust");
			System.out.println("------------------------\n");
			System.out.println("1.Add Donator");
			System.out.println("2.View Donator");
			System.out.println("3.retrieve all");
			System.out.println("4.Exit");
			System.out.println("-----------------------");
			System.out.println("select an option");
			
			try 
			{
				option=sc.nextInt();
				switch(option) {
				case 1:
					while(donorBean==null) 
					{
						donorBean=populateDonorBean();
					}
					
					try 
					{
						donorService=new DonorServiceImpl();
						donorService.addDonor(donorBean);
						System.out.println("donor details have been successfully added");
						System.out.println("Donator id :"+donorId);
					}
					
					catch(DonorException donorException) 
					{
						System.err.println("Error:"+donorException.getMessage());
					}
					finally
					{
						donorId=null;
						donorService=null;
						donorBean=null;
					}
					break;
				
				case 2:
					break;
				
				case 3:
					break;
				
				case 4:
					break;
					default:
						break;
				}
			}
			catch(Exception e)
			{
				
			}
		}
	}

	private static DonorBean populateDonorBean() {
		
		DonorBean donorBean=new DonorBean();
		System.out.println("enter the details");
		
		System.out.println("Enter the donor name");
		donorBean.setDonorName(sc.next());
		
		System.out.println("Enter donor contact");
		donorBean.setPhoneNumber(sc.next());
		
		System.out.println("Enter donor address");
		donorBean.setAddress(sc.next());
		
		System.out.println("Enter donation amount");
		
		try 
		{
			donorBean.setDonationAmount(sc.nextFloat());
		}
		
		catch(InputMismatchException ime)
		{
			sc.nextLine();
			System.out.println("please enter a numeric value for donation amount");
		}
		
		donorServiceImpl =new DonorServiceImpl(); 
		
		try
		{
			donorServiceImpl.validateDonor(donorBean);
			return donorBean;
		}
		
		catch(DonorException donorException)
		{
			System.err.println("Invalid data");
			System.err.println(donorException.getMessage() +"\n try again..");
			System.exit(0);
			
		}
		
		return null;
	}

}
