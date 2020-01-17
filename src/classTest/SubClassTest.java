package classTest;

import java.util.Scanner;

public class SubClassTest {
	
	static final int MAX = 100; //상수이기 때문에 변수를 대문자로 하였음
	static String[] nameList = new String[MAX];
	static char[] genderList = new char[MAX];
	static String[] emailList = new String[MAX];
	static int[] birthList = new int[MAX];
	
	static int count = 0;
	static int index = -1;
	static char m;
	static Scanner scan = new Scanner(System.in);
	
	static char insertMenu() {
		String menu = scan.next();
		menu = menu.toLowerCase();
		m = menu.charAt(0);
		return m;
	}
	
	static void insertData() {
		
		System.out.println("========== 고객 정보 입력 ==========");
		System.out.print("이름 : ");
		String name = scan.next();
		
		System.out.print("성별(M/F): ");
        String str = scan.next();
        char gender = str.charAt(0);
        
        System.out.print("이메일: ");
        String email = scan.next();
        
        System.out.print("출생년도: ");
        int birth = scan.nextInt();
        
        System.out.println("===========================");
	} //end insertData()
} // end class
