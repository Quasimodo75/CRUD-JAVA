package org.example;

import java.util.Scanner;

public class DeleteFunc {



    static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {

        System.out.println("please enter the id of the task you want to delete");
        int id = scanner.nextInt();
       CrudFunc.deleteTask(id);
    }
}
