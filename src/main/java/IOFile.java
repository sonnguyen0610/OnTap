import java.io.*;

public class IOFile {
    public static void main(String[] args) {
        Teacher[] listTeacher = new Teacher[]{
                new Teacher("Nga1", 30, 234, "GTNM", 50),
                new Teacher("Nga2", 30, 234, "GTNM",  45),
                new Teacher("Nga3", 30, 234, "GTNM",  55)
        };
        Student[] listStudent = new Student[]{
                new Student("Huy1", 21, 17130160, "LTM"),
                new Student("Huy2", 21, 17130160, "LTM"),
                new Student("Huy3", 21, 17130160, "LTM"),
                new Student("Huy4", 21, 17130160, "LTM")
        };
        String path = "ds.bin";
//        writeTeacherToFile(path, listTeacher);//test doc ghi ds giao vien
//        System.out.println("Input Teacher success");
        writeStudentToFile(path, listStudent);//test doc ghi ds hs
        System.out.println("Input Student success");
        readStudentFromFile(path);//test doc ds hs

    }

    private static void writeStudentToFile(String path, Student[] listStudent) {
        File file = new File(path);
        if (file.exists()) { //neu đường dẫn file có tồn tin thì thực hiện ghi file
            try {
                FileOutputStream fos = new FileOutputStream(path);//ghi đè lên dl cũ
//                FileOutputStream fos = new FileOutputStream(path, true); //Thêm true để ghi tiếp vào file mà k xóa du lieu cu
                DataOutputStream dos = new DataOutputStream(fos);

                for (Student person : listStudent) {//ghi file theo thứ tự khai báo
                    dos.writeUTF(person.getName());
                    dos.writeInt(person.getAge());
                    dos.writeInt(person.getId());
                    dos.writeUTF(person.getSubject());
                }
                System.out.println(file.getAbsolutePath());
                dos.flush();//đẩy hết dữ liệu vào file
                dos.close();//Đóng stream
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { //neu không tồn tại thì tạo file rồi thực hiện ghi file
            try {
                file.createNewFile();
                writeStudentToFile(path, listStudent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeTeacherToFile(String path, Teacher[] listTeacher) {
        File file = new File(path);
        if (file.exists()) { //neu đường dẫn file có tồn tin thì thực hiện ghi file
            try {
                FileOutputStream fos = new FileOutputStream(path);//ghi đè lên dl cũ
//                FileOutputStream fos = new FileOutputStream(path, true); //Thêm true để ghi tiếp vào file mà k xóa du lieu cu
                DataOutputStream dos = new DataOutputStream(fos);

                for (Teacher person : listTeacher) {//ghi file theo thứ tự khai báo
                    dos.writeUTF(person.getName());
                    dos.writeInt(person.getAge());
                    dos.writeInt(person.getId());
                    dos.writeUTF(person.getSubject());
                    dos.writeInt(person.getSlHS());
                }
                System.out.println(file.getAbsolutePath());
                dos.flush();//đẩy hết dữ liệu vào file
                dos.close();//Đóng stream
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else { //neu không tồn tại thì tạo file rồi thực hiện ghi file
            try {
                file.createNewFile();
                writeTeacherToFile(path, listTeacher);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readStudentFromFile(String path) {
        File file = new File(path);
        if (file.exists()) {

            try {
                FileInputStream fis = new FileInputStream(path);
                DataInputStream dis = new DataInputStream(fis);
                while (dis.available() > 0) {//đọc file theo thứ tự ghi
                    String name = dis.readUTF();
                    int age = dis.readInt();
                    int id = dis.readInt();
                    String subject = dis.readUTF();
                    Person person = new Student(name, age, id, subject);
                    System.out.println(person);
                }
//                fis.close();
//                dis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("File not exist!");
        }
    }
}
