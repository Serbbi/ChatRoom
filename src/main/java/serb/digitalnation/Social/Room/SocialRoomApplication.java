package serb.digitalnation.Social.Room;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "serb.digitalnation.Social.Room.model")
public class SocialRoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialRoomApplication.class, args);
	}

}
