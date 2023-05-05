package Controller;

import Model.Student;
import java.util.List;
/**Интерфейс для вью*/
public interface iGetView {
    /**поле доступа к выводу всех студентов - обязательный метод во вью*/
    void printAllStudent (List<Student> students);

    /**поле доступа к сообщениям*/
    String prompt(String message);
}