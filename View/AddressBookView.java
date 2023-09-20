package lection_5_Task2.View;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lection_5_Task2.Model.Contact;

public class AddressBookView {
	public void showContacts(ArrayList<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

	public void showContact(Contact contact) {
		System.out.println(contact);
	}

	public void displayWelcomeScreen() {
		System.out.println("Добро пожаловать в адресную книгу!");
	}

	Scanner scanner = new Scanner(System.in);

	public void closeScanner() {
		scanner.close();
	}

	public void displayAddContactScreen() {
		System.out.println("Добавление нового контакта:");
		System.out.println("Пожалуйста, введите детали контакта ниже.");
	}

	public Contact getNewContactDetails() {
		System.out.print("Введите имя: ");
		String name = scanner.nextLine();

		System.out.print("Введите номер телефона: ");
		String numberTel = scanner.nextLine();

		System.out.print("Введите город: ");
		String city = scanner.nextLine();

		return new Contact(name, numberTel, city);
	}

	public void displayRemoveContactScreen() {
		System.out.println("---- Удаление контакта ----");
		System.out.println("Для удаления контакта, пожалуйста, введите его ID.");
	}

	public int getContactIdToRemove() {
		System.out.println("Введите ID контакта для удаления: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		return id;
	}

	public int displayMenuAndGetChoice() {

		while (true) {
			System.out.println("Выберите одну из следующих опций:");
			System.out.println("1. Просмотреть все контакты");
			System.out.println("2. Добавить новый контакт");
			System.out.println("3. Удалить контакт");
			System.out.println("4. Выход");

			try {
				int choice = scanner.nextInt();
				if (choice >= 1 && choice <= 4) {
					return choice;
				} else {
					System.out.println("Пожалуйста, выберите действительный номер опции.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Пожалуйста, введите допустимый номер опции.");
				scanner.next();
			}
		}
	}

}
