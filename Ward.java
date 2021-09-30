package task3;

import java.lang.reflect.Array;

public class Ward
{
	String WardNo;
	String WardName;
	int WardCapacity;
	int NoofPatientsAdmittedinthisWard;
	String WardSex;

	Patient[] patients;
	
	public Patient returnPatient(String patientID)
	{
		int i = 0;
		int size = Array.getLength(patients);
			
		int index = -1;
			
		while(i < size)
		{
			if(patients[i].PatientID == patientID)
			{
				index = i;
				break;
			}
			i++;
		}
			
		return patients[index];
	}
	public void SpecifyWardDetails(String wardno, String wardname, int wardCapacity, String wardSex)
	{
		WardNo = wardno;
		WardName = wardname;
		WardCapacity = wardCapacity;
		WardSex = wardSex;
		NoofPatientsAdmittedinthisWard = 0;
		
		patients = new Patient[WardCapacity];
	}
	public void AddPatients(String patientID, String patientName, String wardno, String disease, String sex, String admitDate, String dischargeDate, int age)
	{
		patients[NoofPatientsAdmittedinthisWard] = new Patient();
		patients[NoofPatientsAdmittedinthisWard].SpecifyPatientDetails(patientID, patientName, wardno, disease, sex, admitDate, dischargeDate, age);
		NoofPatientsAdmittedinthisWard++;
	}
	public int BedsAvailable()
	{
		return WardCapacity - NoofPatientsAdmittedinthisWard;
	}
	public int ShowPatients()
	{
		return NoofPatientsAdmittedinthisWard;
	}
}
