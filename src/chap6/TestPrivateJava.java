package chap6;

/**
 * Created by Administrator on 2017/1/8 0008.
 */
public class TestPrivateJava {
    private static class Person{
        private String name = "<Peron";
        public void print(){
            System.out.println(this.name);
        }
    }
    private static class Student extends Person{
        private String name = "<student";
    }


    public static void main(String[] args) {
        Student student = new Student();
        student.print();

    }
}
