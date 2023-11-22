package com.example.Library.Management.System.Services;

import com.example.Library.Management.System.Entities.Author;
import com.example.Library.Management.System.Entities.Book;
import com.example.Library.Management.System.Enums.Genre;
import com.example.Library.Management.System.Exceptions.AuthorNotFoundException;
import com.example.Library.Management.System.Repositories.AuthorRepository;
import com.example.Library.Management.System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book,Integer authorId) throws Exception
    {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(!optionalAuthor.isPresent()){
            throw new AuthorNotFoundException("Author Id Entered is invalid");
        }

        Author author = optionalAuthor.get();


        book.setAuthor(author);


        author.getBookList().add(book);


        authorRepository.save(author);


        return "Book has been added to the DB";
    }


    public List<String> getBooksByGenre(Genre genre){

        List<Book> bookList = bookRepository.findBooksByGenre(genre);

        List<String> bookNames = new ArrayList<>();

        for(Book book:bookList) {

            bookNames.add(book.getBookName());
        }
        return bookNames;
    }
}
