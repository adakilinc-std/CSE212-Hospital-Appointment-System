
public class Doctor {
	private String doctorName;
	private String department;
	private int doctorId;
	private static int doctorCount = 0;
	
	public Doctor(String doctorName, String department, int doctorId) {
		this.doctorName = doctorName;
		this.department = department;
		this.doctorId = doctorId;
		doctorCount++;
	}
	
	public Doctor() {
		doctorCount++;
	}
	
	public String getDoctorName() {
		return doctorName;
	}

	public String getDepartment() {
		return department;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public static int getDoctorCount() {
		return doctorCount;
	}

}
