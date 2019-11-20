package com.finanzas.letter;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.finanzas.letter.util.OperationDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalDate ld2 = LocalDate.now().minusDays(10);
		System.out.println(OperationDate.restaDate(ld2, ld));
		SpringApplication.run(Application.class, args);
	}

}
