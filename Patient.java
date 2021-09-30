package task3;

public class Patient
{
	String PatientID;
	String PatientName;
	String WardNo;
	String Disease;
	String Sex;
	String AdmitDate;
	String DischargeDate;
	int Age;
	
	public void SpecifyPatientDetails(String patientID, String patientName, String wardno, String disease, String sex, String admitDate, String dischargeDate, int age)
	{
		PatientID = patientID;
		PatientName = patientName;
		WardNo = wardno;
		Disease = disease;
		Sex = sex;
		AdmitDate = admitDate;
		DischargeDate = dischargeDate;
		Age = age;
	}
	public void PrintPatientData()
	{
		System.out.println("Patient ID: ");
		System.out.println(PatientID);
		System.out.println("Patient Name: ");
		System.out.println(PatientName);
		System.out.println("Ward No: ");
		System.out.println(WardNo);
		System.out.println("Disease: ");
		System.out.println(Disease);
		System.out.println("Sex: ");
		System.out.println(Sex);
		System.out.println("Admit Date: ");
		System.out.println(AdmitDate);
		System.out.println("Discharge Date: ");
		System.out.println(DischargeDate);
		System.out.println("Age: ");
		System.out.println(Age);
	}
}
