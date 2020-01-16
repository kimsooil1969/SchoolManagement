package schoolManagement;

import java.io.Serializable;

public class Student implements Serializable {
 
    // 순서 : 번호 , 아이디 , 비밀번호 , 이름 , 학과 , 학년
    private int studentNo;
    private String studentId;
    private String studentPw;
    private String studentName;
    private String studentCourse;
    private int studentGrade;
 
    public Student() {
    }
 
    public Student(int studentNo, String studentId, String studentPw, String studentName, String studentCourse,
            int studentGrade) {
        super();
        this.studentNo = studentNo;
        this.studentId = studentId;
        this.studentPw = studentPw;
        this.studentName = studentName;
        this.studentCourse = studentCourse;
        this.studentGrade = studentGrade;
    }
 
    @Override
    public String toString() {
        return "Student [studentNo=" + studentNo + ", studentId=" + studentId + ", studentPw=" + studentPw
                + ", studentName=" + studentName + ", studentCourse=" + studentCourse + ", studentGrade=" + studentGrade
                + "]";
    }
 
    public int getStudentNo() {
        return studentNo;
    }
 
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }
 
    public String getStudentId() {
        return studentId;
    }
 
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
 
    public String getStudentPw() {
        return studentPw;
    }
 
    public void setStudentPw(String studentPw) {
        this.studentPw = studentPw;
    }
 
    public String getStudentName() {
        return studentName;
    }
 
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
 
    public String getStudentCourse() {
        return studentCourse;
    }
 
    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }
 
    public int getStudentGrade() {
        return studentGrade;
    }
 
    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }
 
}