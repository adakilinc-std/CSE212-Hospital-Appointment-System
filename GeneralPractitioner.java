

public class GeneralPractitioner extends Doctor {
	
	public GeneralPractitioner(String doctorName, String department, int doctorId) {
		super(doctorName, department, doctorId);
		this.maxAppointmentsPerPatient = 1;
		this.maxLabsPerPatient = 1;
	}
	
	@Override
	public double calculateContribution() {
		double total = this.getBookedAppointmentCount() * 1000.00;
	
		return total;
	}
}
