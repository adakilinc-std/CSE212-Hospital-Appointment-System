
public enum Menu {
	ADD_DOCTOR(1),
	ADD_PATIENT(2),
	ADD_LABTEST_CATALOG(3),
	BOOK_APPOINTMENT(4),
	CANCEL_APPOINTMENT(5),
	ORDER_LABTEST(6),
	CANCEL_LABTEST(7),
	DISPLAY_ALL_ACCOUNTS(8),
	DISPLAY_SORTED_STATS(9),
	EXIT(0);
	
	private int choice;
	
	Menu(int choice){
		this.choice = choice;
	}
	
	public int getChoice() {
		return choice;
	}
	
	public static Menu MenuOption(int number) {
		switch(number) {
		case 1: return Menu.ADD_DOCTOR;
		case 2: return Menu.ADD_PATIENT;
		case 3: return Menu.ADD_LABTEST_CATALOG;
		case 4: return Menu.BOOK_APPOINTMENT;
		case 5: return Menu.CANCEL_APPOINTMENT;
		case 6: return Menu.ORDER_LABTEST;
		case 7: return Menu.CANCEL_LABTEST;
		case 8: return Menu.DISPLAY_ALL_ACCOUNTS;
		case 9: return Menu.DISPLAY_SORTED_STATS;
		case 0: return Menu.EXIT;
		default: return null;
		}
	}
}
