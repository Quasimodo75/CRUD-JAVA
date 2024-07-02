package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class AddFunc {


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.print("Enter task name: ");
        String task = scanner.nextLine();

        System.out.print("Enter task ID: ");
        int id = scanner.nextInt();


        // Add the task using the user input
        CrudFunc.addTask(id, task);

    }
}
