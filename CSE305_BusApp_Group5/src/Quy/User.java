package Quy;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.SecureRandom;

public class User {

	private String UserID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private static String storedPassword;
	private static String storedEmail;
	private static String storedFirstName;
	private static String storedLastName;

	public User(String userID, String firstName, String lastName, String email, String password) {
		this.UserID = userID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Password = password;
	}

	public void Login() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("User Login:");

		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		System.out.print("Enter Password: ");
		String password = scanner.nextLine();

		if (checkCredentials(email, password)) {
			System.out.println("Login successful!");
		} else {
			System.out.println("Login failed. Invalid input!!!");
		}
	}

	private static boolean checkCredentials(String email, String password) {
		return email.equals(storedEmail) && password.equals(storedPassword);
	}

	public void UpdateProfile() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("User Profile Update:");

		System.out.print("Enter New First Name (leave blank to keep current): ");
		String newFirstName = scanner.nextLine();
		isNameValid(newFirstName);
		if (!newFirstName.isEmpty()) {
			storedFirstName = newFirstName;
		}

		System.out.print("Enter New Last Name (leave blank to keep current): ");
		String newLastName = scanner.nextLine();
		isNameValid(newLastName);
		if (!newLastName.isEmpty()) {
			storedLastName = newLastName;
		}

		System.out.print("Enter New Email (leave blank to keep current): ");
		String newEmail = scanner.nextLine();
		isValidEmail(newEmail);
		if (!newEmail.isEmpty()) {
			storedEmail = newEmail;
		}

		System.out.print("Enter New Password (leave blank to keep current): ");
		String newPassword = scanner.nextLine();
		verifyPassword(newPassword);
		if (!newPassword.isEmpty()) {
			storedPassword = newPassword;
		}

		System.out.println("User Profile Updated Successfully:");
		System.out.println("First Name: " + storedFirstName);
		System.out.println("Last Name: " + storedLastName);
		System.out.println("Email: " + storedEmail);
		System.out.println("Password: " + storedPassword);

	}

	public void ResetPassword() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Password Reset:");

		System.out.print("Enter your Email: ");
		String userEmail = scanner.nextLine();

		if (userEmail.equals(storedEmail)) {
			String newPassword = RandomPasswordGenerator.generatePassword();

			storedPassword = newPassword;

			System.out.println("Password reset successful! Your new temporary password is: " + newPassword);
		} else {
			System.out.println("Password reset failed. Invalid email.");
		}

	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

	public static boolean verifyPassword(String password) {
		if (password.length() < 8) {
			return false;
		}

		if (!password.matches(".*\\d.*")) {
			return false;
		}

		if (!password.matches(".*[A-Z].*")) {
			return false;
		}

		Pattern specialChars = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = specialChars.matcher(password);
		if (!matcher.find()) {
			return false;
		}

		return true;
	}

	public static boolean isNameValid(String name) {
		for (char c : name.toCharArray()) {
			if (Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

}

class RandomPasswordGenerator {

	private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}|;:,<.>/?";

	public static String generatePassword() {
		SecureRandom random = new SecureRandom();

		StringBuilder password = new StringBuilder();

		password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));

		password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

		password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

		int remainingLength = 5;
		for (int i = 0; i < remainingLength; i++) {
			int type = random.nextInt(3);
			switch (type) {
				case 0:
					password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
					break;
				case 1:
					password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
					break;
				case 2:
					password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
					break;
				case 3:
					password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
					break;
			}
		}

		String shuffledPassword = shuffleString(password.toString());
		return shuffledPassword;
	}

	private static String shuffleString(String input) {
		char[] characters = input.toCharArray();
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < characters.length; i++) {
			int randomIndex = random.nextInt(characters.length);
			char temp = characters[randomIndex];
			characters[randomIndex] = characters[i];
			characters[i] = temp;
		}
		return new String(characters);
	}

	public static void main(String[] args) {
		String generatedPassword = generatePassword();
		System.out.println("Generated Password: " + generatedPassword);
	}
}
