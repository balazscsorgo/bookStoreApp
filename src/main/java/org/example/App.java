package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


class App extends View {
    private Controller controller;

    private void mainMenu(Scanner sc) throws ParseException {
        String option = "";
        do {
            switch (option) {

                case "Q" -> {
                    System.exit(0);
                }
                case "B" -> {
                    System.out.println("Id of a new book: ");
                    Long id = sc.nextLong();

                    System.out.println("Title of a new book: ");
                    String title = sc.next();

                    System.out.println("Id of a new author: ");
                    Long id1 = sc.nextLong();

                    System.out.println("Firstname of a new author: ");
                    String firstName = sc.next();

                    System.out.println("Forename of a new author: ");
                    String foreName = sc.next();

                    System.out.println("Sex of a new author (M/F): ");
                    Sex sex = Sex.valueOf(sc.next());

                    System.out.println("Date of birth of a new author: ");
                    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dob = sc.next();
                    Date dateOfBirth = new Date();
                    try {
                        dateOfBirth = sdf.parse(dob);
                    } catch (ParseException e) {
                        System.out.println("Parse Exception");
                    }

                    System.out.println("ISBN of a new book: ");
                    String isbn = sc.next();

                    System.out.println("Is the book available (true/false) : ");
                    boolean available = sc.nextBoolean();

                    controller.addAuthor(id1, firstName, foreName,sex,dateOfBirth );
                    Author a = controller.findAuthorById(id1);
                    controller.addBook(id, title, a, isbn, available);
                }
                case "C" -> {
                    System.out.println("Id of a new author: ");
                    Long id1 = sc.nextLong();

                    System.out.println("Firstname of a new author: ");
                    String firstName = sc.next();

                    System.out.println("Forename of a new author: ");
                    String foreName = sc.next();

                    System.out.println("Sex of a new author (M/F): ");
                    Sex sex = Sex.valueOf(sc.next());

                    System.out.println("Date of birth of a new author: ");
                    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String dob = sc.next();
                    Date dateOfBirth = new Date();
                    try {
                        dateOfBirth = sdf.parse(dob);
                    } catch (ParseException e) {
                        System.out.println("Parse Exception");
                    }
                    controller.addAuthor(id1, firstName, foreName, sex, dateOfBirth);

                }
                default -> {
                    if (!option.equalsIgnoreCase("ghyt")) {
                        System.out.println("publisherApp");
                    }
                }
            }
            printMenu();
            System.out.println("What would you like to do?");
        }
        while (!"Q".equalsIgnoreCase(option = sc.nextLine()));
    }


    public static void main(String[] args) throws Exception {
        App a = new App();


        try (
                Scanner sc = new Scanner(System.in);
                Controller c = new Controller()
        ) {
            a.controller = c;
            a.mainMenu(sc);

        }
    }
}