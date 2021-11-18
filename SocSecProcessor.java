import java.util.Scanner;

public class SocSecProcessor {
	public static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssn;
		String name;
		String answer;
		char responce = 'y';
		
		while(responce == 'y') {
			try {
				System.out.print("Name? ");
				name = s.nextLine();
				System.out.print("SSN? ");
				ssn = s.nextLine();
				
				if(isValid(ssn)) {
					System.out.println(name + " " + ssn + " is valid");
				}
				
			}catch (SocSecException e) {
				System.out.println(e.getMessage());
			}
				System.out.print("Continue? ");
				answer = s.nextLine();
				responce = answer.toLowerCase().charAt(0);
		}
	}
	


	public static boolean isValid(String ssn) throws SocSecException {
		
		boolean ssnIsValid = true;
		
		/*
		 * checks the Length of the entered SSN is correct length , equals to 11
		 */
		if(ssn.length() != 11) {
			 ssnIsValid = false;
 			 throw new SocSecException("wrong number of characters ");
		}
		
		/*
		 * Checks if the '-' are in the correct Spot, if not , throws an exception
		 */
		if(ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {
			ssnIsValid = false;
			throw new SocSecException("dashes at wrong positions");
		}
		
		/*
		 * Checks if SSN is all numbers
		 * Skipes if it finds '-' in the 3rd and 6th index
		 */
			for(int i=0; i< ssn.length(); i++) {
				if(i != 3 && i != 6) {
				  if(!Character.isDigit(ssn.charAt(i))) {
						ssnIsValid = false;
						throw new SocSecException("contains a character that is not a digit");
					}
				}
		}
		return ssnIsValid;
	}
	
}
