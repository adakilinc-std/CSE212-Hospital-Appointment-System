
public class Patient {
	private String patientName;
	private int patientId;
	private static int patientCount = 0;
	
	public Patient(String patientName, int patientId) {
		this.patientName = patientName;
		this.patientId = patientId;
		patientCount++;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public static int getPatientCount() {
		return patientCount;
	}
}
