package lection_5_Task2.Model;

public class Contact {
	private static int counter = 0;
	private final int id;
	private final String name;
	private final String numberTel;
	private final String city;

	public Contact(String name, String numberTel, String city) {
		this.id = ++counter;
		this.name = name;
		this.numberTel = numberTel;
		this.city = city;
		validateFields();
	}
	private void validateFields() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (numberTel == null || numberTel.length() != 8) {
            throw new IllegalArgumentException("Номер телефона должен содержать 8 символов");
        }
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("Название города не может быть пустым");
        }
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNumberTel() {
		return numberTel;
	}

	public String getCity() {
		return city;
	}

	public String toString() {
		return "Контакт: ID = " + id + ", Имя: " +
				name + ", Номер телефона: " +
				numberTel + ", Город: " +
				city + ";";
	}
}
