package lection_5_Task2.App;

import lection_5_Task2.Controller.AddressBookController;
import lection_5_Task2.Model.AddressBook;
import lection_5_Task2.View.AddressBookView;

public class Main {
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
        AddressBookView view = new AddressBookView();
        AddressBookController controller = new AddressBookController(addressBook, view);

        controller.init();
		controller.startApplication();
	}
}
