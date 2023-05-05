import Controller.Controller;
import Model.Model;
import Model.MyModel;
import Model.Student;
import View.View;
import View.ViewEng;
import Model.FileRepo;
import Controller.iGetModel;
import Controller.iGetView;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        List<Student> studentlist = new ArrayList<Student>();
        HashMap<Long, Student> studentmap = new HashMap<Long, Student>();
        Student s1 = new Student("Сергей", "Иванов",23,(long)112);
        Student s2 = new Student("Димон", "Козлов",25,(long)101);
        Student s3 = new Student("Петр", "Петров",24,(long)123);
        Student s4 = new Student("Коля", "Днепр",19,(long)110);

        studentlist.add(s1);
        studentlist.add(s2);
        studentlist.add(s3);
        studentlist.add(s4);

        studentmap.put((long)1,s1);
        studentmap.put((long)2,s2);
        studentmap.put((long)3,s3);
        studentmap.put((long)4,s4);

        for (Map.Entry <Long, Student> entry: studentmap.entrySet()) {
            System.out.println("ID " + entry.getKey() + "  " + entry.getValue());
        }
        FileRepo fileRepo = new FileRepo("StudentDb.txt");

        /*for (Student person: students) {
            fileRepo.addStudent(person);
        }
        fileRepo.saveAllStudentsToFile();*/

        //iGetModel model = new Model(students);
        //iGetModel modelFileRepo = fileRepo;
        iGetModel mymodel = new MyModel(studentmap);

        iGetView view = new View();
        iGetView engview = new ViewEng();
        Controller controller = new Controller(engview, mymodel);
        controller.run();
        //controller.updateView();

    }
}