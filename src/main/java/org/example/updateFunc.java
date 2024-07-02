package org.example;


import static org.example.AddFunc.scanner;


public class updateFunc {

    public static void main(String[] args) {

        System.out.println("please enter the details of the task you want to update");
        String task = scanner.nextLine();
        System.out.print("Enter task ID: ");
        int id=scanner.nextInt();

        CrudFunc.updateTaskById(id,task);



    }
}
