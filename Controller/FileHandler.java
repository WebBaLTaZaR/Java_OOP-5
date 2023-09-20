package lection_5_Task2.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import lection_5_Task2.Model.Contact;
import lection_5_Task2.Model.FileFormat;

public class FileHandler {

	public void exportData(List<Contact> contacts, FileFormat fileFormat, String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Contact contact : contacts) {
				switch (fileFormat) {
					case FORMAT1:
						writer.write(contact.getName());
						writer.newLine();
						writer.write(contact.getNumberTel());
						writer.newLine();
						writer.write(contact.getCity());
						writer.newLine();
						writer.newLine(); // пустая строка - разделитель
						break;
					case FORMAT2:
						// Добавьте здесь логику для другого формата
						break;
				}
			}
		}
	}

	public List<Contact> importData(FileFormat fileFormat, String filePath) throws IOException {
		List<Contact> contacts = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				switch (fileFormat) {
					case FORMAT1:
						String name = line;
						String numberTel = reader.readLine();
						String city = reader.readLine();
						reader.readLine(); // Пропуск пустой строки - разделитель
						contacts.add(new Contact(name, numberTel, city));
						break;
					case FORMAT2:
						// Добавьте здесь логику для другого формата
						break;
				}
			}
		}
		return contacts;
	}
}
