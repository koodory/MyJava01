package basic.exam05.step03;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/* 각 기능 별로 Control 클래스 분리
 * - 사용자가 입력한 데이터를 가공하여 Dao에게 전달
 * - Dao가 리턴한 데이터를 가공하여 Boundary에게 전달
 * - 일단, 현재는 Control이 Dao와 Boundary 역학을 겸한다. 
 * 
 */
import java.util.Scanner;
/* 익명 중첩 클래스의 활용
 * - 한번 밖에 안쓰일 클래스라면 별도로 정의하지 않고 익명 클래스로 만든다.
 * - 주로 이벤트를 처리하는 객체를 등록할 때 사용한다.ㄴ
 */
public class StudentMgtSystem02 {
	static Scanner scanner = new Scanner(System.in);
	
	private static String promptMenu() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase(); 
	}
	
	public static void main(String[] args) {
		// Java에서 제공하는 추상 클래스의 활용
		// - 우리를 대신하여 WindowListener 인터페이스를 구현한 클래스이다.
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		f.setVisible(true);
		
		// 추상클래스는 인스턴스를 생성할 수 없다. 상속받아 기능만 사용 가능
	  //WindowAdapter l = new MyWindowListener();
		// 윈도우 어뎁터는 윈도우 리스너를 상속받은 객체로서 주소를 리턴
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 
			}
		});
		scanner.close();
	}
	
	public static void main04(String[] args) {
		// 추상 클래스의 활용, 직접 인터페이스를 정의함
		// - 리스너에 선언된 클래스가 많다보니 사용하기가 불편함
		// - 미리 리스너를 구현한 중간자 역활을 수행할 클래스를 정의한다.
		// - 중간 클래스를 상속 받아서 필요한 매소드만 정의한다.
		// - 코드를 간결하게 유지할 수 있다.
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		f.setVisible(true);
		// 추상클래스는 인스턴스를 생성할 수 없다. 상속받아 기능만 사용 가능
	  //MyWindowListener l = new MyWindowListener();
		f.addWindowListener(new MyWindowListener(){
			// MyWindowListener만 상속받고
			// ==> windowClosing(_만 재정의한다
			// ==> 와우 ~ 간결하다
			public void windowClosing(WindowEvent e) {
				// 윈도우에서 X버튼을 클릭할 때 호출
				System.exit(0); 
			}
		});
		scanner.close();
	}
	
	public static void main03(String[] args) {
		// addWindowListener() 호출할 때 익명 이너 클래스 생성
		// 이미 만들어진 윈도우 리스너 인터페이스를 사용
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		f.setVisible(true);
		f.addWindowListener(new WindowListener(){
			public void windowOpened(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				// 윈도우에서 X버튼을 클릭할 때 호출
				System.exit(0); 
			}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
		});
		scanner.close();
	}
	
	public static void main02 (String[] args) {
		// 리스너를 익명 이너 클래스로 정의
		Object listener = new WindowListener(){ //인터페이스의 이름을 사용한 익명클래스
			public void windowOpened(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				// 윈도우에서 X버튼을 클릭할 때 호출
				System.exit(0); 
			}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
		};
		
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		f.setVisible(true);
		f.addWindowListener((WindowListener) listener);
	}
	
	public static void main01(String[] args) {
		// WindowListener 인터페이스
		// - 윈도우 관련 이벤트를 처리하는 리스너가 반드시 갖춰야 할 기능
		class MyWindowListener implements WindowListener{
			public void windowOpened(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				//  윈도우에서 X버튼을 클릭할 때 호출됨
				// 특정 함수만을 바로 전달할 수 없음
				System.exit(0); //아무 이상 없이 종료함
			}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
		}
		MyWindowListener listener = new MyWindowListener();
		
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		f.setVisible(true);
		f.addWindowListener(listener);
		
		scanner.close();
	}
		/*
		do {
			String menu = promptMenu();
			
			if ("1".equals(menu)) {
				StudentControl.execute();
			} else if ("2".equals(menu)) {
				StudentScoreControl.execute();
			} else if ("list".equals(menu)) {
				System.out.println("1 학생관리");
				System.out.println("2 점수관리");
				System.out.println("q 종료");
			} else if ("q".equals(menu)) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
			
		} while(true);
    */	
}














