package ch.timofey.inventory_tool_sb;

import ch.timofey.inventory_tool_sb.domain.Item.Item;
import ch.timofey.inventory_tool_sb.domain.Item.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	// Initialize the MongoDB Database With Data
	CommandLineRunner runner(ItemRepository repository){
		return args -> {
			repository.deleteAll();
			repository.insert(List.of(
					new Item("Item 1", 123, "Electronic"),
					new Item("Item 2", 3, "Material"),
					new Item("Item 3", 43, "Material"),
					new Item("Item 4", 82, "Electronic"),
					new Item("Item 5", 18, "Material")
			));
		};
	}
}
