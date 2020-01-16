package schoolManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
 
public class CourseMgr {
 
    Scanner sc = new Scanner(System.in);
 
    Professor loginedProfessor = null;
    Student loginedStudent = null;
 
    ArrayList<Professor> professorList = new ArrayList<>();
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Course> courseList = new ArrayList<>();
    ArrayList<Student> studentAplyList = new ArrayList<>();
 
    Professor joinPro = new Professor();
    Student joinStu = new Student();
 
    // 필요파일 3개 체크 및 로딩작업
    // 필요파일중 부족한파일이 있다면 예제로 만듦.
    public void loading() throws Exception {
 
        if (new File("Professor.info").canRead()) {
            System.out.println("\"Professor.info\" File load : ok");
        } else {
            System.out.println("\"Professor.info\" File load : Sample Make ");
 
            joinPro.setProfessorNo(0);
            joinPro.setProfessorId("testPro");
            joinPro.setProfessorPw("testPro");
            joinPro.setProfessorName("테스트교수");
            joinPro.setProfessorCousrse("테스트학과");
            professorList.add(joinPro);
            ObjectOutputStream infoePro = new ObjectOutputStream(new FileOutputStream("Professor.info", true));
            infoePro.writeObject(professorList);
            infoePro.flush();
            infoePro.close();
        }
 
        if (new File("Student.info").canRead()) {
            System.out.println("\"Student.info\" File load : ok");
        } else {
            System.out.println("\"Student.info\" File load : Sample Make ");
            ObjectOutputStream infoeStu = new ObjectOutputStream(new FileOutputStream("Student.info", true));
            joinStu.setStudentNo(0);
            joinStu.setStudentId("testStu");
            joinStu.setStudentPw("testStu");
            joinStu.setStudentName("테스트학과");
            joinStu.setStudentCourse("테스트학과");
            joinStu.setStudentGrade(1);
            studentList.add(joinStu);
            infoeStu.writeObject(studentList);
            infoeStu.flush();
            infoeStu.close();
        }
 
        if (new File("Course.info").canRead()) {
            System.out.println("\"Course.info\" File load : ok");
        } else {
            System.out.println("\"Course.info\" File load : Sample Make ");
            Course courseMake = new Course();
            courseMake.setCourseCode(0);
            courseMake.setCourseName("테스트강좌");
            courseMake.setCourseMaxNumber(10);
            courseMake.setCourseNowNumber(0);
            courseMake.setCourseProfessor(joinPro);
            courseMake.setCourseStudent(studentList);
            courseList.add(courseMake);
 
            ObjectOutputStream infoeCou = new ObjectOutputStream(new FileOutputStream("Course.info", true));
            infoeCou.writeObject(courseList);
            infoeCou.flush();
            infoeCou.close();
        }
 
        ObjectInputStream loadCourse = new ObjectInputStream(new FileInputStream("Course.info"));
        ArrayList<Course> loadCourseList = (ArrayList<Course>) loadCourse.readObject();
 
        for (Course c : loadCourseList) {
            courseList.add(c);
        }
 
        ObjectInputStream loadProfessor = new ObjectInputStream(new FileInputStream("Professor.info"));
        ArrayList<Professor> loadProfessorList = (ArrayList<Professor>) loadProfessor.readObject();
 
        for (Professor p : loadProfessorList) {
            professorList.add(p);
        }
 
        ObjectInputStream loadStudent = new ObjectInputStream(new FileInputStream("Student.info"));
        ArrayList<Student> loadStudentList = (ArrayList<Student>) loadStudent.readObject();
 
        for (Student s : loadStudentList) {
            studentList.add(s);
        }
 
        System.out.println("--------------------------------------");
        System.out.println("데이터 로딩 체크 : ok");
        System.out.println("--------------------------------------");
    }
 
    public void login() throws Exception {
        System.out.println("--------------------------------------");
        System.out.println("ID를 입력해주세요");
        String inputID = sc.nextLine();
        System.out.println("PW를 입력해주세요");
        String inputPW = sc.nextLine();
 
        for (Professor p : professorList) {
 
            if (p.getProfessorId().equals(inputID) && p.getProfessorPw().equals(inputPW)) {
                loginedProfessor = p;
                professorLogin();
            }
        }
        for (Student s : studentList) {
 
            if (s.getStudentId().equals(inputPW) && s.getStudentPw().equals(inputPW)) {
                loginedStudent = s;
                studentLogin();
            }
        }
    }
 
    public void professorLogin() throws Exception {
        while (true) {
 
            System.out.println("--------------------------------------");
            System.out.println("1.과정등록");
            System.out.println("2.과정조회");
            System.out.println("3.과정상세조회");
            System.out.println("0.돌아가기");
            int professorLoginMenu = Integer.parseInt(sc.nextLine());
            if (professorLoginMenu == 1) {
                Course courseMake = new Course();
                // 순서: 코스코드,코스이름,코스최대인원,코스현재인원,코스담당교수,코스학생목록
                courseMake.setCourseCode(0);
                System.out.println("--------------------------------------");
                System.out.println("1.과정등록");
                System.out.println("등록할 과정 이름을 입력해주세요");
                courseMake.setCourseName(sc.nextLine());
                System.out.println("--------------------------------------");
                System.out.println("등록할 과정 정원을 입력해주세요");
                courseMake.setCourseMaxNumber(Integer.parseInt(sc.nextLine()));
                courseMake.setCourseNowNumber(0);
                courseMake.setCourseProfessor(loginedProfessor);
                courseMake.setCourseStudent(null);
                courseList.add(courseMake);
 
                ObjectOutputStream infoeCou = new ObjectOutputStream(new FileOutputStream("Course.info", true));
                infoeCou.writeObject(courseList);
                infoeCou.flush();
                infoeCou.close();
 
            } else if (professorLoginMenu == 2) {
                System.out.println("과정조회 메뉴입니다.");
                System.out.println(loginedProfessor.getProfessorName() + "님 과정조회 메뉴입니다.");
                for (Course c : courseList) {
                    if (c.getCourseProfessor().equals(loginedProfessor)) {
                        System.out.println("===================================");
                        System.out.println("과정번호 : " + c.getCourseCode());
                        System.out.println("과정이름 : " + c.getCourseName());
                        System.out.println("과정전공 : " + loginedProfessor.getProfessorCousrse());
                        System.out.println("===================================");
                    }
                }
            } else if (professorLoginMenu == 3) {
                System.out.println("과정상세조회 메뉴입니다.");
                System.out.println(loginedProfessor.getProfessorName() + "님 과정 상세조회 메뉴입니다.");
                for (Course c : courseList) {
                    if (c.getCourseProfessor().equals(loginedProfessor)) {
                        System.out.println("===================================");
                        System.out.println("과정번호 : " + c.getCourseCode());
                        System.out.println("과정이름 : " + c.getCourseName());
                        System.out.println("과정정원 : " + c.getCourseNowNumber() + "/" + c.getCourseNowNumber());
                        System.out.println("===================================");
                    }
                }
            } else {
                System.out.println("돌아갑니다");
                break;
            }
        }
    }
 
    public void studentLogin() {
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("1.개설과정조회");
            System.out.println("2.수강신청");
            System.out.println("3.수강신청조회");
            System.out.println("0.돌아가기");
            int studentLoginMenu = Integer.parseInt(sc.nextLine());
            if (studentLoginMenu == 1) {
                if (studentLoginMenu == 1) {
                    System.out.println("전체 개설 과정입니다.");
                    for (Course c : courseList) {
                        System.out.println("===================================");
                        System.out.println("과정번호 :" + c.getCourseCode());
                        System.out.println("과정이름 :" + c.getCourseName());
                        System.out.println("과정정원 :" + c.getCourseNowNumber() + "/" + c.getCourseMaxNumber());
                        System.out.println("담당교수 :" + c.getCourseProfessor().getProfessorName());
                        System.out.println("전공 :" + c.getCourseProfessor().getProfessorCousrse());
                        System.out.println("===================================");
                    }
                } else if (studentLoginMenu == 2) {
                    System.out.println("수강신청할 과정 번호를 입력해주세요");
                    int aplyNum = Integer.parseInt(sc.nextLine());
                    for (Course c : courseList) {
                        if (c.getCourseCode() == aplyNum) {
                            System.out.println(c.getCourseName() + "을 수강신청하셨습니다.");
                            c.setCourseNowNumber(c.getCourseNowNumber() + 1);
                            studentAplyList.add(loginedStudent);
                            c.setCourseStudent(studentAplyList);
                        }
                    }
                } else if (studentLoginMenu == 3) {
                    System.out.println(loginedStudent.getStudentName() + "님의 수강신청 이력입니다.");
                    for (Course c : courseList) {
                        for (Student s : studentList) {
                            if (loginedStudent.equals(s.getStudentName()))
                                System.out.println("===================================");
                            System.out.println("과정번호 :" + c.getCourseCode());
                            System.out.println("과정이름 :" + c.getCourseName());
                            System.out.println("과정정원 :" + c.getCourseNowNumber() + "/" + c.getCourseMaxNumber());
                            System.out.println("담당교수 :" + c.getCourseProfessor().getProfessorName());
                            System.out.println("전공 :" + c.getCourseProfessor().getProfessorCousrse());
                            System.out.println("===================================");
                        }
                    }
                } else {
                    System.out.println("돌아갑니다");
                }
            }
        }
    }
 
    public void JoinProfessor() throws Exception {
        Professor joinPro = new Professor();
 
        // 순서 : 교수번호 , 교수 아이디, 교수 비밀번호 , 교수 이름 , 교수 코스
        System.out.println("--------------------------------------");
        joinPro.setProfessorNo(0);
        System.out.println("등록하실 아이디를 입력해주세요");
        joinPro.setProfessorId(sc.nextLine());
        System.out.println("등록하실 비밀번호를 입력해주세요");
        joinPro.setProfessorPw(sc.nextLine());
        System.out.println("등록하실 교수님 이름을 입력해주세요");
        joinPro.setProfessorName(sc.nextLine());
        System.out.println("교수님의 전공을 입력해주세요");
        joinPro.setProfessorCousrse(sc.nextLine());
        professorList.add(joinPro);
 
        ObjectOutputStream infoePro = new ObjectOutputStream(new FileOutputStream("Professor.info", true));
        infoePro.writeObject(professorList);
        infoePro.flush();
        infoePro.close();
    }
 
    public void JoinStudent() throws Exception {
        Student joinStu = new Student();
 
        // 순서 : 번호 , 아이디 , 비밀번호 , 이름 , 학과 , 학년
        System.out.println("--------------------------------------");
        joinStu.setStudentNo(0);
        System.out.println("등록하실 아이디를 입력해주세요");
        joinStu.setStudentId(sc.nextLine());
        System.out.println("등록하실 비밀번호를 입력해주세요");
        joinStu.setStudentPw(sc.nextLine());
        System.out.println("등록하실 이름을 입력해주세요");
        joinStu.setStudentName(sc.nextLine());
        System.out.println("등록하실 학과를 입력해주세요");
        joinStu.setStudentCourse(sc.nextLine());
        System.out.println("등록하실 학년를 입력해주세요");
        joinStu.setStudentGrade(Integer.parseInt(sc.nextLine()));
        studentList.add(joinStu);
 
        ObjectOutputStream infoeStu = new ObjectOutputStream(new FileOutputStream("Student.info", true));
        infoeStu.writeObject(studentList);
        infoeStu.flush();
        infoeStu.close();
    }
 
    public void logOut() {
        loginedProfessor = null;
        loginedStudent = null;
    }
 
    public static void cantFindFile() throws Exception {
        System.out.println("실행에 중요한 파일인 Professor.info , Student.info , Course.info 파일이 없습니다. ");
        System.out.println("샘플파일을 작성하였습니다. 재실행해주세요.");
    }
}