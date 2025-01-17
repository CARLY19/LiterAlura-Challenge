package com.literatura.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getLivingAuthors(int age) {
        // Llamada al repositorio para obtener los autores cuya edad es mayor que la indicada
        return authorRepository.findByAgeGreaterThan(age);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    public List<Author> searchAuthorsByName(String name) {
        return authorRepository.findByAgeGreaterThan(Integer.parseInt(name));
    }
}
