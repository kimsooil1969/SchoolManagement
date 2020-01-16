package schoolManagement;

import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class CourseApp {
    public static void main(String[] args) throws Exception {
 
        try {
            CourseMgr courseMgr = new CourseMgr();
            Scanner sc = new Scanner(System.in);
            
            courseMgr.loading();
            
            while (true) {
                System.out.println("--------------------------------------");
                System.out.println("1.로그인");
                System.out.println("2.회원가입");
                System.out.println("0.종료");
                System.out.println("--------------------------------------");
                int menu = Integer.parseInt(sc.nextLine());
                if (menu == 1) {
                    courseMgr.login();
                } else if (menu == 2) {
                    System.out.println("--------------------------------------");
                    System.out.println("1.교수");
                    System.out.println("2.학생");
                    System.out.println("0.이전으로");
                    System.out.println("--------------------------------------");
                    int secMenu = Integer.parseInt(sc.nextLine());
                    if (secMenu == 1) {
                        courseMgr.JoinProfessor();
                    } else if (secMenu == 2) {
                        courseMgr.JoinStudent();
                    } else {
                        System.out.println("되돌아갑니다.");
                        courseMgr.logOut();
                        break;
                    }
                } else {
                    System.out.println("종료합니다.");
                    break;
                }
            }
 
        } catch (FileNotFoundException f) {
            CourseMgr.cantFindFile();
        } 
        catch (Exception e) {
            System.out.println("예기치못한 오류로 강제 종료합니다.");
            e.getMessage();
        }
    }
 
}