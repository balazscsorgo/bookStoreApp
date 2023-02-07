package org.example;


import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "fore_name")
    private String ForeName;

    @Column(columnDefinition = "sex('M','F')")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(fetch = FetchType.EAGER)
    @MapsId("id")
    private List<Book> bookList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getForeName() {
        return ForeName;
    }

    public void setForeName(String foreName) {
        ForeName = foreName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", ForeName='" + ForeName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", bookList=" + bookList +
                '}';
    }

    public Author() {
    }

    public Author(Long id, String firstName, String foreName,Sex sex, Date dateOfBirth) {
        this.id = id;
        FirstName = firstName;
        ForeName = foreName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }
}
