package lection_5_Task2.View;

import java.util.List;

import lection_5_Task2.Model.Contact;

public class ContactView {

    public void displayContact(Contact contact) {
        System.out.println(contact.toString());
    }

    public void displayContactList(List<Contact> contacts) {
        for (Contact contact : contacts) {
            displayContact(contact);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.err.println(error);
    }
}
