package View;

import Controller.iGetView;
import Model.Student;

import java.util.List;
import java.util.Scanner;

public class ViewEng implements iGetView {
    public void printAllStudent(List<Student> students) {
        System.out.println("////////List of Students////////");
        for (Student person: students) {
            System.out.println(person);
        }
        System.out.println("////////End of List////////");
    }
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
