package lection_5_Task2.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressBook {
	private ArrayList<Contact> contacts;

	public AddressBook() {
		contacts = new ArrayList<>();
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void removeContact(int id) {
		Iterator<Contact> iterator = contacts.iterator();
		while (iterator.hasNext()) {
			Contact contact = iterator.next();
			if (contact.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}

	public void loadInitialData() {
		contacts.add(new Contact("Alice", "12345678", "City1"));
        contacts.add(new Contact("Bob", "87654321", "City2"));
	}
}
