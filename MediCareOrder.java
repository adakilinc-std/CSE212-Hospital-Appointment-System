
public class MediCareOrder extends LabOrder {
	private double base = 1000.0;
	
	public MediCareOrder(String labCode, String labTestName, MyDate orderDate, Patient forPatient) {
        super(labCode, labTestName, orderDate, forPatient);
    }
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	@Override
    public double calculateContribution() {
        return base;
    }
	
	@Override
    public String info() {
		double discountedPrice = calculateContribution() * 0.80; //Assignment VI requirements: %20 off
		
        return "A " + getLabTestName() + " (Code# " + getLabCode() + ") is ordered via the Medicare System for " + 
               getPatient().getPatientName() + " that costs " + String.format("%.2f", discountedPrice) + 
               " TRY which is 20% less from the original " + String.format("%.2f", base) + 
               " TRY price due to end of year discount";
    }
	
}
