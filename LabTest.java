
public class LabTest {
	private String labTestName;
	private String labCode;
	private Patient patient;
	
	public LabTest(String labTestName, String labCode, Patient patient) {
		this.labTestName = labTestName;
		this.labCode = labCode;
		this.patient = patient;
	}
	
	public LabTest(String labTestName, String labCode) {
        this.labTestName = labTestName;
        this.labCode = labCode;
    }
	
	public String getLabTestName() {
		return labTestName;
	}
	
	public String getLabCode() {
		return labCode;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) { 
		this.patient = patient; 
	}
	
	public String getInfo() {
        if (patient == null) {
            return labTestName + " — Code: " + labCode;
        } else {
            return labTestName + " — Code: " + labCode +
                   " — Patient: " + patient.getPatientName();
        }
    }
}
