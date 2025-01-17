package com.literatura.model;

import com.literatura.model.BookService;
import com.literatura.model.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Mostrar libros por idioma");
            System.out.println("3. Listar autores vivos en un año");
            System.out.println("4. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    List<Book> books = bookService.searchBooksByTitle(title);
                    if (books != null && !books.isEmpty()) {
                        books.forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor().getName()));
                    } else {
                        System.out.println("No se encontraron libros.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el idioma del libro: ");
                    String language = scanner.nextLine();
                    List<Book> booksInLanguage = bookService.getBooksByLanguage(language);
                    if (booksInLanguage != null && !booksInLanguage.isEmpty()) {
                        booksInLanguage.forEach(book -> System.out.println(book.getTitle() + " - " + book.getLanguage()));
                    } else {
                        System.out.println("No se encontraron libros en ese idioma.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el año para verificar autores vivos: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    List<Author> authors = authorService.getLivingAuthors(year);
                    if (authors != null && !authors.isEmpty()) {
                        authors.forEach(author -> {
                            if (author.getDeathYear() == -1) {
                                System.out.println(author.getName() + " - " + author.getBirthYear() + " - Vivo");
                            } else {
                                System.out.println(author.getName() + " - " + author.getBirthYear() + " - Fallecido en " + author.getDeathYear());
                            }


                        });
                    } else {
                        System.out.println("No se encontraron autores vivos en ese año.");
                    }
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
