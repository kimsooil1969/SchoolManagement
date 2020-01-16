package schoolManagement;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {

   // 순서: 코스코드,코스이름,코스최대인원,코스현재인원,코스담당교수,코스학생목록
   private int courseCode;
   private String courseName;
   private int courseMaxNumber;
   private int courseNowNumber;
   private Professor courseProfessor;
   private ArrayList<Student> courseStudent;

   public Course() {
   }

   public Course(int courseCode, String courseName, int courseMaxNumber, int courseNowNumber,
           Professor courseProfessor, ArrayList<Student> courseStudent) {
       super();
       this.courseCode = courseCode;
       this.courseName = courseName;
       this.courseMaxNumber = courseMaxNumber;
       this.courseNowNumber = courseNowNumber;
       this.courseProfessor = courseProfessor;
       this.courseStudent = courseStudent;
   }

   @Override
   public String toString() {
       return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", courseMaxNumber="
               + courseMaxNumber + ", courseNowNumber=" + courseNowNumber + ", courseProfessor=" + courseProfessor
               + ", courseStudent=" + courseStudent + "]";
   }

   public int getCourseCode() {
       return courseCode;
   }

   public void setCourseCode(int courseCode) {
       this.courseCode = courseCode;
   }

   public String getCourseName() {
       return courseName;
   }

   public void setCourseName(String courseName) {
       this.courseName = courseName;
   }

   public int getCourseMaxNumber() {
       return courseMaxNumber;
   }

   public void setCourseMaxNumber(int courseMaxNumber) {
       this.courseMaxNumber = courseMaxNumber;
   }

   public int getCourseNowNumber() {
       return courseNowNumber;
   }

   public void setCourseNowNumber(int courseNowNumber) {
       this.courseNowNumber = courseNowNumber;
   }

   public Professor getCourseProfessor() {
       return courseProfessor;
   }

   public void setCourseProfessor(Professor courseProfessor) {
       this.courseProfessor = courseProfessor;
   }

   public ArrayList<Student> getCourseStudent() {
       return courseStudent;
   }

   public void setCourseStudent(ArrayList<Student> courseStudent) {
       this.courseStudent = courseStudent;
   }

}