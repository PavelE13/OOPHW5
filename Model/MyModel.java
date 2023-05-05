package Model;

import Controller.iGetModel;

import java.security.Key;
import java.util.*;
/**класс моя модель с имплементацией интерфейса iGetModel*/
public class MyModel implements iGetModel {
    /**поле карта студентов */

    private HashMap<Long, Student> students;

    public MyModel(HashMap<Long, Student> students) {
        this.students = students;
    }
    /**переопределяем метод deleteStudent() длтипа данных HASHMAP
     * @return
     */
    @Override
    public void deleteStudent(Integer id) {
        students.keySet().remove(id.longValue());
        }
    /**Геттер
     * @return
     */
    public List<Student> getAllStudents (){
        return new ArrayList<Student>(students.values());
    }
}


