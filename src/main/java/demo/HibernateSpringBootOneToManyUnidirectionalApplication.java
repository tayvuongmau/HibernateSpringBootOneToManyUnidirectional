package demo;

import demo.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateSpringBootOneToManyUnidirectionalApplication {
    private final BookstoreService bookstoreService;

    public HibernateSpringBootOneToManyUnidirectionalApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateSpringBootOneToManyUnidirectionalApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert one author with three books  ...");
            bookstoreService.insertAuthorWithBooks();

            System.out.println("\n---------------------------------------------");

            System.out.println("\nInsert new book to an author  ...");
            bookstoreService.insertNewBook();

            System.out.println("\n---------------------------------------------");

            System.out.println("\nDelete first book of an author  ...");
            bookstoreService.deleteFirstBook();
        };
    }
}
