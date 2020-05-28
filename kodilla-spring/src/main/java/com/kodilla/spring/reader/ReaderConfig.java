package com.kodilla.spring.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ReaderConfig {
    @Autowired //pole wiązane automatycznie
    @Qualifier("book1") //wskazanie beana, bo są dwa
            Book book;

    @Bean
    public Reader getReader() {
        return new Reader(book);
    }

    @Bean(name = "book1")
    @Scope("prototype")
    public Book getBookOne() {
        return new Book("The book number one");
    }

    @Bean(name = "book2")
    @Scope("prototype")
    @Conditional(IfDayIsOddCondition.class) //ten bean zostanie utworzony tylko wtedy, gdy metoda zwróci true
    public Book getBookTwo() {
        return new Book("The book number two");
    }
}