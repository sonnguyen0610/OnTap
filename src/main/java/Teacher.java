public class Teacher extends Person {
    private int slHS;

    public int getSlHS() {
        return slHS;
    }

    public Teacher(String name, int age, int id, String subject, int slHS) {
        super(name, age, id, subject);
        this.slHS=slHS;
    }

    @Override
    public void teach() {
        super.teach();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Teacher{");
        sb.append("name='").append(name).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", age=").append(age);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
