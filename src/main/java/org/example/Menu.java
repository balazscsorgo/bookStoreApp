package org.example;

public class Menu {
    String menu="""
        +--------------------BOOK APP--------------------+
        |------------------------------------------------|
        |              * Available options *             |
        |------------------------------------------------|
        | ADD BOOK - (B)                                 |
        | ADD AUTHOR - (C)                               |
        | EDIT BOOK - (D)                                |
        | FIND BOOK BY ISBN - (E)                        |
        | FIND BOOK BY TITLE - (H)                       |
        | FIND BOOK BY AUTHOR - (I)                      |
        |                                                |
        | QUIT  - (Q)                                    |
        |------------------------------------------------|
        |                                                |
        +------------------------------------------------+""";

    void printMenu() {
        System.out.println("*".repeat(50));
        System.out.println(menu);
        System.out.println("*".repeat(50));
    }
}