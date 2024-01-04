package api.agendame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgendameApplication {

	public static String CUR_TOKEN = "";
	public static void main(String[] args) {
		SpringApplication.run(AgendameApplication.class, args);
	}
}
