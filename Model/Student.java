package Model;
/**Наследуем User с имплементацией Компаратора по Студенту*/
public class Student extends User implements Comparable<Student> {
    /**поле идстудента*/
    private long studentID;

    /**Конструктор
     * @param firstName
     * @param secondName
     * @param age
     * @param studentID
     */

    public Student(String firstName, String secondName, int age, long studentID) {
        super(firstName, secondName, age);
        this.studentID = studentID;
    }

    /**Геттер
     * @return ид студена
     */
    public long getStudentID() {
        return studentID;
    }

    /**Сеттер
     * @param studentID
     */
    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    /**Переопределение вывода
     * @return
     */
    @Override
    public String toString() {
        return "\nStudent{"

                + "firstName=" + super.getFirstName()
                + ", secondName=" + super.getSecondName()
                + ", age=" + super.getAge() +
                ", studentID=" + studentID +
                '}';
    }

    /**Переопределение компаратора по студенту
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Student o) {

        // System.out.println(super.getFirstName() + " - " + o.getFirstName());
        if (super.getAge() == o.getAge()) {
            if (this.studentID == o.studentID) {
                return 0;
            }
            if (this.studentID < o.studentID) {
                return -1;
            }
            return 1;
        }
        if (super.getAge() < o.getAge()) {
            return -1;
        }
        return 1;
    }
}
