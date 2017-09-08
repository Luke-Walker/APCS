import java.util.*;

public class Password {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Username: ");
		String name = scan.nextLine();
		System.out.println("Welcome " + name + "!");
		
		String password = "";
		while (!password.equals("abc")) {
			System.out.println("Password: ");
			password = scan.nextLine();
		}
		
		System.out.println("Correct password.");
	}
}