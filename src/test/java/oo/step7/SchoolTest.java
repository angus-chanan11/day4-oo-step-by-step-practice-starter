package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_print_nothing_when_startSchool_given_empty_teacher_and_student_in_school() {
        School school = new School(List.of(), List.of());

        school.startSchool();

        String expected = "";

        assertThat(systemOut()).isEqualTo(expected);
    }

    @Test
    public void should_introduce_all_students_when_startSchool_given_3_student_in_school() {
        Klass klass = new Klass(1);
        Student studentWithKlass = new Student(1, "Tom", 18);
        studentWithKlass.join(klass);
        Student leaderStudent = new Student(2, "Jerry", 19);
        leaderStudent.join(klass);
        klass.assignLeader(leaderStudent);
        Student studentWithoutKlass = new Student(3, "John", 20);

        List<Student> students = List.of(studentWithKlass, leaderStudent, studentWithoutKlass);
        School school = new School(students, List.of());

        school.startSchool();

        String expected = "My name is Tom. I am 18 years old. I am a student. I am in class 1."
                + "My name is Jerry. I am 19 years old. I am a student. I am the leader of class 1."
                + "My name is John. I am 20 years old. I am a student.";

        assertThat(systemOut()).isEqualTo(expected);
    }

    @Test
    public void should_introduce_all_teachers_when_startSchool_given_2_teacher_in_school() {
        Klass klass = new Klass(10);
        Teacher teacherWithKlass = new Teacher(1, "Linda", 30);
        teacherWithKlass.assignTo(klass);
        Teacher teacherWithoutKlass = new Teacher(2, "Bob", 29);

        List<Teacher> teachers = List.of(teacherWithKlass, teacherWithoutKlass);
        School school = new School(List.of(), teachers);

        school.startSchool();

        String expected = "My name is Linda. I am 30 years old. I am a teacher. I teach Class 10."
                + "My name is Bob. I am 29 years old. I am a teacher.";

        assertThat(systemOut()).isEqualTo(expected);
    }

    @Test
    public void should_introduce_all_students_and_teachers_when_startSchool_given_2_teacher_2_student_in_school() {
        List<Student> students = List.of(new Student(1, "Tom", 18),
                                         new Student(2, "Jerry", 19));
        List<Teacher> teachers = List.of(new Teacher(1, "Linda", 30),
                                         new Teacher(2, "Bob", 29));
        School school = new School(students, teachers);

        school.startSchool();

        String expected = "My name is Tom. I am 18 years old. I am a student."
                + "My name is Jerry. I am 19 years old. I am a student."
                + "My name is Linda. I am 30 years old. I am a teacher."
                + "My name is Bob. I am 29 years old. I am a teacher.";

        assertThat(systemOut()).isEqualTo(expected);
    }
}
