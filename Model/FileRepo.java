package Model;

import Controller.iGetModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
/**Репозиторий файлов с имплементацией интерфейса iGetModel*/
public class FileRepo implements iGetModel {
    /**поле имя файла*/
    private String fileName;
    /**поле список студентов*/
    private List<Student> students;

    /**Конструктор
     * @param fileName
     * @param //students
     * метод вывода исключения (ошибки) при вводе
     */
    public FileRepo(String fileName) {
        this.fileName = fileName;
        this.students = new ArrayList<>();
        try (FileWriter fw = new FileWriter(fileName,true)){
            fw.flush();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**Метод добавления файла
     * @param student
     */
    public void addStudent (Student student) {
        this.students.add(student);
    }

    /**Метод чтения студентов из файла*/
    public void readAllStudentsFromFile() {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] param = line.split(" ");
                Student person = new Student(param[0], param[1], Integer.parseInt(param[2]),Long.parseLong(param[3]));
                students.add(person);
                line = reader.readLine();
            }
        }
        catch (Exception e) { //вывод исключения (ошибки) при нестандартном завершении проги
            System.out.println(e.getMessage());
        }
    }
    /**Метод записи студентов в файл*/
    public void saveAllStudentsToFile() {
        try (FileWriter fw = new FileWriter(fileName,true)){
            for(Student person: students) {
                fw.write(person.getFirstName() + " " + person.getSecondName() + " " + person.getAge() + " " + person.getStudentID());
                fw.append('\n');
            }
            fw.flush();
        }
        catch (Exception e) { //вывод исключения (ошибки) при нестандартном завершении проги
            System.out.println(e.getMessage());
        }
    }

    /**переопределяем метод getAllStudents()
     * @return
     */
    @Override
    public List<Student> getAllStudents() {
        readAllStudentsFromFile();
        return students;
    }
    /**переопределяем метод deleteStudent()
     * @return
     */
    @Override
    public void deleteStudent(Integer id) {
        students.remove(id);
    }
}