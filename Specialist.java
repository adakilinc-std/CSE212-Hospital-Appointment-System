
public class Specialist extends GeneralPractitioner{

	    public Specialist(String doctorName, String department, int doctorId) {
	        super(doctorName, department, doctorId);

	        this.maxAppointmentsPerPatient = 2;
	        this.maxLabsPerPatient = 2;
	    }
	    
	    @Override
	    public double calculateContribution() {
	    	double total = this.getBookedAppointmentCount() * 2000.00;
			
	    	return total;
	    }

}
