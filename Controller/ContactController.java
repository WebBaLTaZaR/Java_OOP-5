package lection_5_Task2.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lection_5_Task2.Model.Contact;
import lection_5_Task2.View.ContactView;

public class ContactController {

	private List<Contact> contactList = new ArrayList<>();
	private ContactView contactView = new ContactView();

	public void addContact(String name, String numberTel, String city) {
		try {
			Contact newContact = new Contact(name, numberTel, city);
			contactList.add(newContact);
			contactView.displayMessage("Контакт успешно добавлен");
		} catch (IllegalArgumentException e) {
			contactView.displayError(e.getMessage());
		}
	}

	public void viewContacts() {
		contactView.displayContactList(contactList);
	}

	public void deleteContact(int id) {
		Iterator<Contact> iterator = contactList.iterator();
		while (iterator.hasNext()) {
			Contact contact = iterator.next();
			if (contact.getId() == id) {
				iterator.remove();
				contactView.displayMessage("Контакт успешно удален");
				return;
			}
		}
		contactView.displayError("Контакт с указанным ID не найден");
	}
}
