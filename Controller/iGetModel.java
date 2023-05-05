package Controller;

import Model.Student;

import java.util.HashMap;
import java.util.List;

/**Интерфейс для модели*/
public interface iGetModel {
    /**поле доступа к студентам - обязательный метод в модели*/
    List<Student> getAllStudents();
    /**поле доступа к удалению студента - обязательный метод в модели*/
    void deleteStudent(Integer id);
}
