
public enum Menu {
	ADD_DOCTOR(1),
	ADD_PATIENT(2),
	CREATE_APPOINTMENT(3),
	DISPLAY_APPOINTMENTS(4),
	EXIT(5);
	
	private int choice;
	
	Menu(int choice){
		this.choice = choice;
	}
	
	public int getChoice() {
		return choice;
	}
	
	public static Menu MenuOption(int number) {
		if(number == 1) return Menu.ADD_DOCTOR;
		if(number == 2) return Menu.ADD_PATIENT;
		if(number == 3) return Menu.CREATE_APPOINTMENT;
		if(number == 4) return Menu.DISPLAY_APPOINTMENTS;
		if(number == 5) return Menu.EXIT;
		
		return null;
	}
}
