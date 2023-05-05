package View;

import Controller.iGetView;
import Model.Student;

import java.util.List;
import java.util.Scanner;

/**вью с имплементацией интерфейса iGetView*/
public class View implements iGetView {
    /**метод вывода на печать всех студентов
     * @param students
     */
    public void printAllStudent(List<Student> students) {
        System.out.println("////////Вывод списков студентов////////");
        for (Student person: students) {
            System.out.println(person);
        }
        System.out.println("////////Конец списка////////");
    }

    /**Метод вывода на печать сообщений
     * @param message
     * @return
     */
    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
