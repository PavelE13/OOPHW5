package Model;

/**Создане базового класса User*/
public class User {
    /**поле Имя*/
    private String firstName;
    /**поле Фамилия*/
    private String secondName;
    /**поле Возраст*/
    private int age;

    /**Конструктор
     * @param firstName
     * @param secondName
     * @param age
     */
    public User(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    /**Геттре
     * @return имя
     */
    public String getFirstName() {
        return firstName;
    }

    /**Сеттер
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**Геттер
     * @return фамилия
     */
    public String getSecondName() {
        return secondName;
    }

    /**Сеттер
     * @param secondName
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**Геттер
     * @return возраст
     */
    public int getAge() {
        return age;
    }

    /**Сеттер
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**Переопределениие сортировки
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "firstName=" + firstName  +
                ", secondName=" + secondName  +
                ", age=" + age +
                '}';
    }
}
