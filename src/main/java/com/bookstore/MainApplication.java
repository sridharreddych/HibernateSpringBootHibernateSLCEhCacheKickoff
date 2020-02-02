package com.bookstore;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bookstore.service.BookstoreService;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.persistTwoBooks();

            System.out.println("\n\n===========================================");
            
            System.out.println("First call fetchBook() ................");
            bookstoreService.fetchBook();

            System.out.println("Second call fetchBook() ................");
            bookstoreService.fetchBook();           
            
            System.out.println("\n\n===========================================");
            
            System.out.println("First call fetchBookByPrice() ................");
            bookstoreService.fetchBookByPrice();

            System.out.println("Second call fetchBookByPrice() ................");
            bookstoreService.fetchBookByPrice();           
        };
    }
}
/*
 * How To Cache Entities And Query Results In Second Level Cache (EhCache)

Description: This is a SpringBoot application that enables Hibernate Second Level Cache and EhCache provider. It contains an example of caching entities and an example of caching a query result.

Key points:

enable Second Level Cache (EhCache)
rely on @Cache
rely on JPA hint HINT_CACHEABLE
 * 
 */
