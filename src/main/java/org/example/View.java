package org.example;

public class View {


    void printMenu() {


        System.out.println("=".repeat(50));
        System.out.println("""
        ================ ADD BOOK - (B) ==================
        =============== ADD AUTHOR - (C) =================
        ==============  EDIT BOOK - (D) ==================
        ===========  FIND BOOK BY ISBN - (E) =============
        ===========  FIND BOOK BY TITLE - (H) ============
        ===========  FIND BOOK BY AUTHOR - (I) ===========
        ================== Kilepes - (Q) =================""");
        System.out.println("=".repeat(50));
    }
}
