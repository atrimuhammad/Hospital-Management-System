package task3;

import java.util.Scanner;

public class HMS
{
	public static void main(String []args)
	{
		Scanner sc  =  new Scanner(System.in);
		
		int choice;
		
		Hospital h = new Hospital();
		
	while(true)
	{
		System.out.println("\n1. Enter Hospital Details");
		System.out.println("2. Create Ward and enter ward details");
		System.out.println("3. Add patient data");
		System.out.println("4. Print Hospital Data");
		System.out.println("5. Show number of available beds in a ward");
		System.out.println("6. Show patient's data");
		System.out.println("7. Show number of patients in a ward");
		
		System.out.println("8. End");
		
		System.out.print("\nEnter your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
		
		if(choice == 8)
		{
			break;
		}
		switch(choice)
		{
			case 1:
				String name, location, contactno;
				double rating;
				double priceperbed;
				int totalnoofbeds;
				
				System.out.print("\nEnter Hospital Name: ");
				name = sc.next();
				
				System.out.print("Enter Hospital Location: ");
				location = sc.next();
				
				System.out.print("Enter Hospital Rating: ");
				rating = sc.nextDouble();
				
				System.out.print("Enter Hospital Contact No: ");
				contactno = sc.next();
				
				System.out.print("Enter Hospital's Price Per Bed: ");
				priceperbed = sc.nextDouble();
				
				System.out.print("Enter Hospital Total No of Beds: ");
				totalnoofbeds = sc.nextInt();
				
				h.CreateHospital(name, location, rating, contactno, priceperbed, totalnoofbeds);
			
				break;
				
			case 2:
				String wardno, wardname, wardsex;
				int wardcapacity;
				
				System.out.print("\nEnter Ward No: ");
				wardno = sc.nextLine();
				
				System.out.print("Enter Ward Name: ");
				wardname = sc.nextLine();
				
				System.out.print("Enter Ward Sex: ");
				wardsex = sc.nextLine();
				
				System.out.print("Enter Ward Capacity: ");
				wardcapacity = sc.nextInt();
				
				h.CreateWard(wardno, wardname, wardcapacity, wardsex);
				
				break;
				
			case 3:
				String patientID, patientName, wardNo, disease, sex, admitDate, dischargeDate;
				int age;
				
				Ward wardd;
				
				System.out.print("Enter Patient ID: ");
				patientID = sc.nextLine();
				
				System.out.print("Enter Patien Name: ");
				patientName = sc.nextLine();
				
				System.out.print("Enter Patient Ward No: ");
				wardNo = sc.nextLine();
				
				System.out.print("Enter Patient Disease: ");
				disease = sc.nextLine();
				
				System.out.print("Enter Patient Sex: ");
				sex = sc.nextLine();
				
				System.out.print("Enter Patient Admit Date: ");
				admitDate = sc.nextLine();
				
				System.out.print("Enter Patient Discharge Date: ");
				dischargeDate = sc.nextLine();
				
				System.out.print("Enter Patient Age: ");
				age = sc.nextInt();
				
		        try  
		        {  
		            // calling the method   
		        	wardd = h.returnWard(wardNo, sex);
		        	
		        	wardd.AddPatients(patientID, patientName, wardNo, disease, sex, admitDate, dischargeDate, age);
		        }
		        catch (InvalidWardException ex)  
		        {  
		            System.out.println("Caught the exception");  
		    
		            // printing the message from InvalidAgeException object  
		            System.out.println("Exception occured: " + ex);  
		        }
				
				break;
				
			case 4:
				h.PrintHospitalData();
				break;
				
			case 5:
				String WardNo;
				
				System.out.print("Enter Ward No: ");
				WardNo = sc.nextLine();
				
				Ward w = h.returnWardForNumberofPatients(WardNo);
				
				int beds_available = w.BedsAvailable();
				
				System.out.println("Number of Beds Available: " + beds_available);
				
				break;
				
			case 6:
				String PWardNo, PatientID;
				
				System.out.print("Enter Ward No: ");
				PWardNo = sc.nextLine();
				
				System.out.print("Enter Patient ID: ");
				PatientID = sc.nextLine();
				
				Ward ww = h.returnWardForNumberofPatients(PWardNo);
				
				Patient p = ww.returnPatient(PatientID);
				
				p.PrintPatientData();
				
				break;
				
			case 7:
				String WardN;
				
				System.out.print("Enter Ward No: ");
				WardN = sc.nextLine();
				
				Ward war = h.returnWardForNumberofPatients(WardN);
				
				int patientsinward = war.ShowPatients();
				
				System.out.println("Number of Patients admitted in ward: " + patientsinward);
				
				break;
		}
	}
}
}
