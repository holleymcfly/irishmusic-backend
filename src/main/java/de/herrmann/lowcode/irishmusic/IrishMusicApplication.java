package de.herrmann.lowcode.irishmusic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.herrmann.lowcode.irishmusic.repository.ImportData;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class IrishMusicApplication {

	//@Autowired
	//ImportData importData;
	
	public static void main(String[] args) {
		SpringApplication.run(IrishMusicApplication.class, args);
	}
	
	//@PostConstruct
	//public void loadTestData() {
	//	importData.loadData();
	//}
}
