package ltd.storming.Domain;

public class Student extends Person{
    public static int sid;
    static {
        sid = 1;
    }

    public Student() {
    }

    public Student(int id, String name, String sex, String birthday, int age) {
        super(id, name, sex, birthday, age);
    }

    @Override
    public String getType() {
        return "学生";
    }

    @Override
    public String getWork() {
        return "学Java";
    }
}
