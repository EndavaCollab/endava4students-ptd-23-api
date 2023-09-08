package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static MyAppProperties appProperties;

	@Autowired
	public DemoApplication(MyAppProperties appProperties) {
		this.appProperties = appProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		DemoApplication app = new DemoApplication(appProperties);
		app.splitAndPrintMessage();
	}

	// Example usage of the property
	public static void splitAndPrintMessage() {
		insertSpaces();

		String myAppMessage = appProperties.getMessage();
		String[] splitedMessage = myAppMessage.split("[;:_.!?/-]");
		System.out.print("My property is: ");
		for (String message: splitedMessage) {
			if (!message.isEmpty() || !message.isBlank()) {
				System.out.print(message + " ");
			}
		}

		insertSpaces();
	}

	public static void insertSpaces() {
		System.out.println();
		System.out.println();
	}
}
