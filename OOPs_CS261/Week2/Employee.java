package OOPs_CS261.Week2;

import java.util.Scanner;

public class Employee {
    Scanner obj = new Scanner(System.in);
    public int Id;
    public String name;

    Employee() {
        Id = obj.nextInt();
        name = obj.nextLine();

    }

    Employee(int Id, String name) {
        this.Id = Id;
        this.name = name;
    }

}