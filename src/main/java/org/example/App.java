package org.example;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


class App extends Menu {

    public static HibernateContext hibernateContext = new HibernateContext();
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Controller controller;

    App(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) throws Exception {
        App app = new App(new Controller());
        try (Scanner sc = new Scanner(System.in)) {
            app.mainMenu(sc);
        }
        System.exit(0);
    }

    private void mainMenu(Scanner sc) throws ParseException {
        String option = "";
        do {
            switch (option) {

                case "Q" -> {
                    hibernateContext.getSession().flush();
                    return;
                }

                case "B" -> {
                    System.out.println("Title of a new book: ");
                    String title = sc.nextLine();

                    System.out.println("Firstname of a new author: ");
                    String firstName = sc.nextLine();

                    System.out.println("Forename of a new author: ");
                    String foreName = sc.nextLine();

                    System.out.println("Sex of a new author (M/F): ");
                    Sex sex = Sex.fromString(sc.nextLine());

                    System.out.println("Date of birth of a new author: ");
                    LocalDate dateOfBirth;
                    try {
                        dateOfBirth = LocalDate.parse(sc.nextLine(), dtf);
                    } catch (DateTimeParseException e) {
                        System.err.println("Unable to parse date!");
                        return;
                    }

                    System.out.println("ISBN of a new book: ");
                    String isbn = sc.nextLine();

                    System.out.println("Is the book available (true/false) : ");
                    boolean available = Boolean.parseBoolean(sc.nextLine());

                    Author author = controller.addAndReturnNewAuthor(firstName, foreName, sex, dateOfBirth);
                    controller.addBook(title, author, isbn, available);
                }

                case "C" -> {
                    System.out.println("Firstname of a new author: ");
                    String firstName = sc.nextLine();

                    System.out.println("Forename of a new author: ");
                    String foreName = sc.nextLine();

                    System.out.println("Sex of a new author (M/F): ");
                    String s=sc.nextLine();
                    Sex sex = Sex.valueOf(s);

                    System.out.println("Date of birth of a new author: ");
                    LocalDate dateOfBirth;
                    try {
                        dateOfBirth = LocalDate.parse(sc.nextLine(), dtf);
                    } catch (DateTimeParseException e) {
                        System.err.println("Unable to parse date!");
                        return;
                    }
                    controller.addAuthor(firstName, foreName, sex, dateOfBirth);

                }
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("publisherApp");
                    }
                }
            }
            printMenu();
            System.out.println("Option: ");
        }
        while (!"Q".equalsIgnoreCase(option = sc.nextLine()));
    }
}