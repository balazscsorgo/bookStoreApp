package org.example;


import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @OneToMany(mappedBy = "author")
    List<Book> books;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "fore_name")
    private String ForeName;

    @Column(columnDefinition = "enum('M','F')")
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public Author() {
    }

    public Author(Long id, String firstName, String foreName, Sex sex, LocalDate dateOfBirth) {
        this.id = id;
        FirstName = firstName;
        ForeName = foreName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public Author(String firstName, String foreName, Sex sex, LocalDate dateOfBirth) {
        FirstName = firstName;
        ForeName = foreName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;}

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Author{" + "id=" + id + ", FirstName='" + FirstName + '\'' + ", ForeName='" + ForeName + '\'' + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
