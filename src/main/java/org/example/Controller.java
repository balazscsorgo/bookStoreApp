package org.example;


import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.time.LocalDate;
import java.util.*;

public class Controller implements AutoCloseable {

    Scanner sc = new Scanner(System.in);

    private HibernateContext model = new HibernateContext();


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

    public void addBook(String title, Author author, String ISBN, boolean available) {
        Book book = new Book(title, author, ISBN, available);

        Session session = App.hibernateContext.getSession();
        session.getTransaction().begin();
        session.persist(book);
        session.getTransaction().commit();
        System.out.println("Book id = " + book.getId());
    }

    public Book findABookByTitle(String title) {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM book where title like :title and available=true";

        Query q = session.createQuery(hql, Book.class).setParameter("title", "%" + title + "%");

        List<Book> bookList = q.getResultList();
        Book b = bookList.get(0);
        tx.commit();
        return b;
    }

    public Book findABookByISBN(String ISBN) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM book where ISBN like :ISBN and available=true";

        Query q = session.createQuery(hql, Book.class).setParameter("ISBN", "%" + ISBN + "%");

        List<Book> bookList = q.getResultList();
        Book b = bookList.get(0);
        tx.commit();
        return b;
    }


    public List<Book> listBooksByAuthorId(Author id) {

        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM book where author_id like :id and available=true";

        Query q = session.createQuery(hql, Book.class).setParameter("author_id", "%" + id + "%");

        List<Book> bookList = q.getResultList();
        tx.commit();
        return bookList;
    }

    public List<Book> listAllBooks() {
        Session session = model.getSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM book";

        List<Book>bookList = session.createQuery(hql, Book.class).getResultList();

        tx.commit();
        return bookList;
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

    public void deleteAnAuthorById(Author id) {
        Session session = model.getSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            //    String hql = "FROM author where id like :id";
            //    Query q = session.createQuery(hql, Author.class).setParameter("id", "%" + id + "%");

            Author a = session.find(Author.class, id);

            session.remove(a);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void addStore(Long id, List<Book> bookList) {

        Store store = new Store(id);

        Session session = model.getSession();
        session.getTransaction().begin();
        session.persist(store);
        session.flush();
        session.getTransaction().commit();
        System.out.println("Store id = " + store.getId());
    }

    public void updateStore(Store store, String[] args) {


        store.setId(Long.parseLong(Arrays.toString(args)));

        Session session = model.getSession();


        Transaction tx = session.beginTransaction();


        session.persist(store);
        tx.commit();
        session.close();
    }

    public void deleteAStoreById(Store id) {
        Session session = model.getSession();
        Transaction tx = null;
        try {

            tx = session.beginTransaction();
            //    String hql = "FROM store where id like :id";
            //    Query q = session.createQuery(hql, Store.class).setParameter("id", "%" + id + "%");
            Store s = session.find(Store.class, id);

            session.remove(s);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public void close() throws Exception {

    }
}
