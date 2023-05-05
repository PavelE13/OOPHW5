package Controller;

import Model.Model;
import Model.MyModel;
import Model.MyModel.*;
import Model.Student;
import View.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**Контроллер*/
public class Controller {
    /**Поле список студентов*/
    private List<Student> students;
    /**Поле соединения с view*/
    private iGetView view;
    /**Поле соединения с model */
    private iGetModel model;

    /**Конструктов
     * @param view
     * @param model
     */
    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
    }

    /**Геттер getAllStudent*/
    public void getAllStudent() {
        students = model.getAllStudents();
    }
    /**Метод тестирование данных на наличие записей*/
    public boolean testData() {
        if (students.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    /**Метод обновление вью*/
    public  void updateView() {
        //MVC
        //view.printAllStudent(model.getAllStudents());
        //MVP
        getAllStudent();
        if(testData()) {
            view.printAllStudent(students);
        }
        else {
            System.out.println("Список студентов пуст");
        }
    }
    /**Метод RUN запуска команд*/
    public void run()

    {
        Scanner scanner = new Scanner(System.in);
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        /**Цикл ввода команд пока не равно exit-> false
         */
        while(getNewIteration)
        {
            String command = view.prompt("Введите команду:");
            com = Commands.valueOf(command.toUpperCase());
            switch(com) // Вариации комманд
            {
                case EXIT: // Выход
                    getNewIteration=false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST: // Список студентов
                    getAllStudent();
                    updateView();
                    break;
                case DELETE: //Удалить студента из списка
                    System.out.println("Введите ID удаляемого студента: ");
                    int id = scanner.nextInt();

                    if (getStudentsByID(id)) { //Если id совпадает с № записи в списке запускаем процесс
                        model.deleteStudent(id); //Удаляем
                        String command1 = view.prompt("Студент успешно удален.");
                    }
                    else { // иначе выводим сообщение
                        String command2 = view.prompt("Ошибка удаления студента. Студент не найден.");
                    }

                    break;
                default: System.out.println("Неправильный ввод. Повторите снова.");
            }
        }
    }
    /**Метод запуска удаления*/
    public boolean getStudentsByID(Integer id) {
        boolean flag = false;
        int count = 1;
        //ArrayList<Student> student = new ArrayList<Student>();
        for (Student student : model.getAllStudents()) {
            if (id == count) {
                flag=true;
            }
            count++;
        }
        //System.out.println(flag);
        return flag;
        }
    }

