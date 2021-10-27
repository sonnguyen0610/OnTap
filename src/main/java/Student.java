public class Student extends Person {
    private String lopHoc;


    public Student(String name, int age, int id, String subject) {
        super(name, age, id, subject);
    }

    @Override
    public void learn() {
        super.learn();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", age=").append(age);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
