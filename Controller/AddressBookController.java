package lection_5_Task2.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import lection_5_Task2.Model.AddressBook;
import lection_5_Task2.Model.Contact;
import lection_5_Task2.View.AddressBookView;

public class AddressBookController {
	private AddressBook addressBook;
	private AddressBookView addressBookView;
	private Scanner scanner = new Scanner(System.in);

	public AddressBookController(AddressBook addressBook, AddressBookView addressBookView) {
		this.addressBook = addressBook;
		this.addressBookView = addressBookView;
	}

	/**
	 * @apiNote метод, предлагающий выбор пользователю, где 1 = логика для просмотра
	 *          всех контактов, 2 = логика для добавления нового контакта, 3 =
	 *          логика для удаления контакта, 4 = логика для выхода из программы
	 * 
	 */
	private void handleUserChoice(int choice) {
		switch (choice) {
			case 1:

				ArrayList<Contact> contacts = addressBook.getContacts();
				addressBookView.showContacts(contacts);
				break;
			case 2:

				addressBookView.displayAddContactScreen();
				addressBook.addContact(addressBookView.getNewContactDetails());
				break;
			case 3:

				addressBookView.displayRemoveContactScreen();
				addressBook.removeContact(addressBookView.getContactIdToRemove());
				break;
			case 4:

				System.exit(0);
				break;
			default:
				System.out.println("Неизвестный выбор. Пожалуйста, попробуйте снова.");
				break;
		}
	}

	public void init() {
		addressBook.loadInitialData();
		addressBookView.displayWelcomeScreen();
	}
	/**
	 * @apiNote метод, запускающий всю цепочку событий
	 * addressBookView.displayMenuAndGetChoice(); // Метод, который отображает доступные опции пользователю;
	 * 
	 * int choice = scanner.nextInt(); // Читаем выбор пользователя;
	 * 
	 * scanner.nextLine(); // Очистка буфера сканера;
	 * 
	 * handleUserChoice(choice); // Вызываем метод с выбором пользователя;
	 */
	public void startApplication() {
		while (true) {
			addressBookView.displayMenuAndGetChoice();
			int choice = scanner.nextInt();
			scanner.nextLine();
			handleUserChoice(choice);
		}
	}

}
