package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.net.ssl.HandshakeCompletedEvent;
import java.util.*;

public class Controller implements AutoCloseable {

    Scanner sc = new Scanner(System.in);

    private HibernateContext model = new HibernateContext();

    public void addAuthor(Long id, String firstName, String foreName, Sex sex, Date dateOfBirth) {
        Author author = new Author();

        author.setId(id);
        author.setFirstName(firstName);
        author.setForeName(foreName);
        author.setSex(sex);
        author.setDateOfBirth(dateOfBirth);

        Session session = model.getSession();
        session.getTransaction().begin();
        session.persist(author);
        session.flush();
        session.getTransaction().commit();
        System.out.println("Author id = " + author.getId());
    }

    public Author findAuthorById(Long authorId) {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM author where id like :authorId";

        Query q = session.createQuery(hql, Author.class).setParameter("title", "%" + authorId + "%");


        List<Author> authorList = q.getResultList();
        Author a = authorList.get(0);
        tx.commit();

        return a;
    }

    public void addBook(Long id, String title, Author author, String ISBN, boolean available) {
        Book book = new Book();

        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        book.setAvailability(available);

        Session session = model.getSession();
        session.getTransaction().begin();
        session.persist(book);
        session.flush();
        session.getTransaction().commit();
        System.out.println("Book id = " + book.getId());
    }

    public Book findBookByTitle(String title) {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM Book where title like :title and available=true";

        Query q = session.createQuery(hql, Book.class).setParameter("title", "%" + title + "%");

        List<Book> bookList = q.getResultList();
        Book b = bookList.get(0);
        tx.commit();
        return b;
    }

    public Book findBookByISBN(String ISBN) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM Book where ISBN like :ISBN and available=true";

        Query q = session.createQuery(hql, Book.class).setParameter("ISBN", "%" + ISBN + "%");

        List<Book> bookList = q.getResultList();
        Book b = bookList.get(0);
        tx.commit();
        return b;
    }


    public void updateBook(Book book, String[] args) {


        book.setTitle(Arrays.toString(args));
        book.setISBN(Arrays.toString(args));
        book.setAvailability(Boolean.parseBoolean(Arrays.toString(args)));

        Session session = model.getSession();


        Transaction tx = session.beginTransaction();


        session.persist(book);
        tx.commit();
        session.close();
    }


    public void addStore(Long id, List<Book> bookList) {

        Store store = new Store();

        store.setId(id);
        store.setBookList(bookList);

        Session session = model.getSession();
        session.getTransaction().begin();
        session.persist(store);
        session.flush();
        session.getTransaction().commit();
        System.out.println("Store id = " + store.getId());
    }

    @Override
    public void close() throws Exception {

    }
}
