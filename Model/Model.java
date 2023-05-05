package Model;

import Controller.iGetModel;
import java.util.List;

/**класс модель с имплементацией интерфейса iGetModel*/
public class Model implements iGetModel {
    /**поле список студентов*/
    private List<Student> students;

    /**Конструктор
     * @param students
     */
    public Model(List<Student> students) {
        this.students = students;
    }

    /**Геттер
     * @return
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**метод удаления студента для модель (тип данных List)
     * @param id
     */
    public void deleteStudent(Integer id) {
            students.remove(id-1);
        }

    }
