package com.finanzas.letter;

import java.math.BigDecimal;
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
		System.out.println(BigDecimal.valueOf(Math.pow(1+0.3434,Double.valueOf(22)/Double.valueOf(360))-1).setScale(7,BigDecimal.ROUND_HALF_DOWN).doubleValue());
		SpringApplication.run(Application.class, args);
	}

}
