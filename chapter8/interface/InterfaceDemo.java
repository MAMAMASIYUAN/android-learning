import java.util.Arrays;

public class InterfaceDemo {
    public static void main(String[] args) {
        Student s1 = new Student("D", 90);
        Student s2 = new Student("F", 70);
        Student s3 = new Student("E", 60);
        Student s4 = new Student("C", 80);
        Student[] students = {s1, s2, s3, s4};
        Arrays.sort(students);

        int i = 1;
        for (Student s : students) {
            System.out.println(i++ + "-" + s.score + ":" + s.name);
        }

        Teacher t1 = new Teacher("AA", 9000);
        Teacher t2 = new Teacher("XX", 7000);
        Teacher t3 = new Teacher("GG", 6000);
        Teacher t4 = new Teacher("JJ", 8000);
        Teacher[] teachers = {t1, t2, t3, t4};
        Arrays.sort(teachers);

        i = 1;
        for (Teacher t : teachers) {
            System.out.println(i++ + "-" + t.name + ":" + t.wage);
        }
    }
}

class Student implements Comparable < Student > {
    public String name;
    public int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Student st) {
        if (score == st.score)
            return 0;
        else if (score < st.score) // 如果 score > st.score？
            return 1;
        else
            return -1;
    }
}

class Teacher implements Comparable < Teacher > {
    String name;
    int wage;
    Teacher(String name, int wage) {
        this.name = name;
        this.wage = wage;
    }

    public int compareTo(Teacher st) {
        // if (wage == st.wage)
        //     return 0;
        // else if (wage > st.wage)
        //     return 1;
        // else
        //     return -1;
        return name.compareTo(st.name);
    }
}