package schoolManagement;


import java.io.Serializable;

public class Professor implements Serializable {

   // 순서 : 교수번호 , 교수 아이디, 교수 비밀번호 , 교수 이름 , 교수 코스
   private int professorNo;
   private String professorId;
   private String professorPw;
   private String professorName;
   private String professorCousrse;

   public Professor() {
   }

   public Professor(int professorNo, String professorId, String professorPw, String professorName,
           String professorCousrse) {
       super();
       this.professorNo = professorNo;
       this.professorId = professorId;
       this.professorPw = professorPw;
       this.professorName = professorName;
       this.professorCousrse = professorCousrse;
   }

   @Override
   public String toString() {
       return "Professor [professorNo=" + professorNo + ", professorId=" + professorId + ", professorPw=" + professorPw
               + ", professorName=" + professorName + ", professorCousrse=" + professorCousrse + "]";
   }

   public int getProfessorNo() {
       return professorNo;
   }

   public void setProfessorNo(int professorNo) {
       this.professorNo = professorNo;
   }

   public String getProfessorId() {
       return professorId;
   }

   public void setProfessorId(String professorId) {
       this.professorId = professorId;
   }

   public String getProfessorPw() {
       return professorPw;
   }

   public void setProfessorPw(String professorPw) {
       this.professorPw = professorPw;
   }

   public String getProfessorName() {
       return professorName;
   }

   public void setProfessorName(String professorName) {
       this.professorName = professorName;
   }

   public String getProfessorCousrse() {
       return professorCousrse;
   }

   public void setProfessorCousrse(String professorCousrse) {
       this.professorCousrse = professorCousrse;
   }

}