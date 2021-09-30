package task3;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.FileWriter;

class InvalidWardException extends Exception  
{  
    public InvalidWardException(String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
    }  
} 

public class Hospital
{
	String Name;
	String Location;
	double Rating;
	String ContactNo;
	double PricePerBed;
	int TotalNoOfBeds;
	int assignedwards = 0;
	
	Ward[] wards = new Ward[25];
    
	public Ward returnWardForNumberofPatients(String wardNo)
	{
		int i = 0;
		int size = Array.getLength(wards);
		
		int index = -1;
		
		while(i < size)
		{
			if(wards[i].WardNo == wardNo)
			{
				index = i;
				break;
			}
			i++;
		}
		
		return wards[index];
	}
	public Ward returnWard(String wardNo, String sex) throws InvalidWardException
	{
		int i = 0;
		int size = Array.getLength(wards);
		
		Ward w = new Ward();
		
		while(i < size)
		{
			if(wards[i].WardNo == wardNo)
			{
				if((wards[i].NoofPatientsAdmittedinthisWard >= wards[i].WardCapacity) || (wards[i].WardSex != sex))
				{
					throw new InvalidWardException("Can not be admitted to this ward");
				}
				else
				{
					w = wards[i];
				}
				break;
			}
			i++;
		}
		
		return w;
	}
	public void CreateHospital(String name, String location, double rating, String contact_no, double pricePerBed, int totalNoOfBeds)
	{
		Name = name;
		Location = location;
		Rating = rating;
		ContactNo = contact_no;
		PricePerBed = pricePerBed;
		TotalNoOfBeds = totalNoOfBeds;
	}
	public void PrintHospitalData()
	{
		System.out.println("Hospital Name: " + Name);
		System.out.println("Hospital Location: " + Location);
		System.out.println("Hospital Rating: " + Rating);
		System.out.println("Hospital Contact No: " + ContactNo);
		System.out.println("Hospital Price Per Bed: " + PricePerBed);
		System.out.println("Total # of Beds in Hospital: " + TotalNoOfBeds);
		
	    try
	    {
	    	FileWriter myWriter = new FileWriter("hospitaldata.txt");
	    	
	    	myWriter.write("Hospital Name: " + Name);
	    	myWriter.write("Hospital Location: " + Location);
	    	myWriter.write("Hospital Rating: " + Rating);
	    	myWriter.write("Hospital Contact No: " + ContactNo);
	    	myWriter.write("Hospital Price Per Bed: " + PricePerBed);
	    	myWriter.write("Total # of Beds in Hospital: " + TotalNoOfBeds);
	    	
	    	myWriter.close();
	    	
	    	System.out.println("Successfully wrote to the file.");
	    }
	    catch(IOException e)
	    {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
	}
	public void CreateWard(String wardno, String wardname, int wardcapacity, String wardsex)
	{
		wards[assignedwards] = new Ward();
		wards[assignedwards].SpecifyWardDetails(wardno, wardname, wardcapacity, wardsex);
		assignedwards++;
	}
}
