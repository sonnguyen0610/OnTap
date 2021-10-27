public abstract class Person {
    protected String name,subject;
    protected int age, id;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }


    public Person(String name, int age, int id, String subject) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.subject=subject;

    }

    public void learn() {
        System.out.println("Student is learn");
    }

    public void teach() {
        System.out.println("Teacher is teach");
    }

    @Override
    public String toString() {
        final StringBuilder sb = null;
        return sb.toString();
    }
}
