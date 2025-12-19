
public class Surgeon extends Doctor{
	
	public Surgeon(String doctorName, String department, int doctorId) {
        super(doctorName, department, doctorId);

        this.maxAppointmentsPerPatient = 3;
        this.maxLabsPerPatient = 3;
    }
	
	@Override
    public double calculateContribution() {
    	double total = this.getBookedAppointmentCount() * 5000.00;
		
    	return total;
    }
}
