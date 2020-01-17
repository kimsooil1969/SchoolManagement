package classTest;

public class MainClassTest {

	public static void main(String[] args) {
		System.out.println("메인 화면입니다.");

		
		while(true) {
		
			System.out.println("\n[INFO] 고객 수: " + SubClassTest.count + ", 인덱스: " + SubClassTest.index);
			System.out.println("\n메뉴를 입력하세요.\n");
			System.out.println("(I)nsert, (P)revious, " + "(N)ext, (C)urrent, (U)pdate, " + "(D)elete, (Q)uit");
			System.out.print("\n메뉴 입력: ");
	
			SubClassTest.insertMenu();
			//System.out.println(SubClassTest.m);
			
		
			switch (SubClassTest.m) {
	
			case 'i':
			case 'ㅑ':
				System.out.println("\n고객정보를 입력하세요.");
				SubClassTest.insertData();
				System.out.println("고객정보입력이 완료되었습니다.");
				break;
			case 'p':
			case 'ㅔ':
				System.out.println("\n이전 고객정보를 출력합니다.");
	
				System.out.println("이전 고객정보가 존재하지 않습니다.");
				break;
			case 'n':
			case 'ㅜ':
				System.out.println("\n다음 고객정보를 출력합니다.");
	
				System.out.println("다음 고객정보가 존재하지 않습니다.");
				break;
			case 'c':
			case 'ㅊ':
				System.out.println("\n현재 고객정보를 출력합니다.");
	
				System.out.println("현재 고객정보가 존재하지 않습니다.");
				break;
			case 'u':
			case 'ㅕ':
				System.out.println("\n이전 고객정보를 출력합니다.");
	
				System.out.println("이전 고객정보가 존재하지 않습니다.");
				break;
			case 'd':
			case 'ㅇ':
				System.out.println("\n고객정보입력을 시작합니다.");
	
				System.out.println("고객정보입력이 완료되었습니다.");
				break;
			case 'q':
			case 'ㅂ':
				System.out.println("\n고객정보입력을 시작합니다.");
	
				System.out.println("고객정보입력이 완료되었습니다.");
				break;
			} // end switch
		}  //end while
	} // end main method
} // end class
