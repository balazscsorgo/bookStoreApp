package org.example;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Controller {

    public void addAuthor(String firstName, String foreName, Sex sex, LocalDate dateOfBirth) {
        Author author = new Author(firstName, foreName, sex, dateOfBirth);

        Session session = App.hibernateContext.getSession();
        session.getTransaction().begin();
        session.persist(author);
        session.getTransaction().commit();
        System.out.println("Author id = " + author.getId());
    }

    public Author addAndReturnNewAuthor(String firstName, String foreName, Sex sex,
                                        LocalDate dateOfBirth) {
        Session session = App.hibernateContext.getSession();
        Author author = new Author(firstName, foreName, sex, dateOfBirth);
        session.getTransaction().begin();
        session.persist(author);
        session.flush();
        session.getTransaction().commit();

        return findAuthorById(author.getId());
    }

    public Author findAuthorById(Long authorId) {
        Session session = App.hibernateContext.getSession();
        Transaction tx = session.beginTransaction();
        Author author = session.find(Author.class, authorId);
        tx.commit();

        return author;
    }

    public Author findAuthorByName(String firstName) {
        Session session = App.hibernateContext.getSession();
        Transaction tx = session.beginTransaction();
        Author author = session.find(Author.class, firstName);
        tx.commit();

        return author;
    }

    public void addBook(String title, Author author, String ISBN, boolean available) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setISBN(ISBN);
        book.setAvailability(available);

        Session session = App.hibernateContext.getSession();
        session.getTransaction().begin();
        session.persist(book);
        session.getTransaction().commit();
        System.out.println("Book id = " + book.getId());
    }

    //  public Book findBookByTitle(String title) {
//    Session session = App.hibernateContext.getSession();
//    Transaction tx = session.beginTransaction();
//
//    String hql = "FROM Book where title like :title and available=true";
//
//    Query q = session.createQuery(hql, Book.class).setParameter("title", "%" + title + "%");
//
//    List<Book> bookList = q.getResultList();
//    Book b = bookList.get(0);
//    tx.commit();
//    return b;
//  }
//
//  public Book findBookByISBN(String ISBN) {
//
//    Session session = model.getSession();
//    Transaction tx = session.beginTransaction();
//
//    String hql = "FROM Book where ISBN like :ISBN and available=true";
//
//    Query q = session.createQuery(hql, Book.class).setParameter("ISBN", "%" + ISBN + "%");
//
//    List<Book> bookList = q.getResultList();
//    Book b = bookList.get(0);
//    tx.commit();
//    return b;
//  }
//
//
//  public void updateBook(Book book, String[] args) {
//
//    book.setTitle(Arrays.toString(args));
//    book.setISBN(Arrays.toString(args));
//    book.setAvailability(Boolean.parseBoolean(Arrays.toString(args)));
//
//    Session session = model.getSession();
//
//    Transaction tx = session.beginTransaction();
//
//    session.persist(book);
//    tx.commit();
//    session.close();
//  }
//
//
    public void addStore(String name) {
        Store store = new Store();
        store.setName(name);

        Session session = App.hibernateContext.getSession();
        session.getTransaction().begin();
        session.persist(store);
        session.getTransaction().commit();

        System.out.println("Store id = " + store.getId());
    }

}
