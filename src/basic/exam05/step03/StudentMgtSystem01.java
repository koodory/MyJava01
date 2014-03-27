package basic.exam05.step03;

/* Frame 클래스의 사용
 * - Component: 윈도우의 기본 기능을 갖고 있다.
 * => Automic Comp. : 기본 윈도우 객체(widget)
 * 	  ex) Button, CheckBox, Canvas..
 * => Container : 다른 윈도우를 담을 수 있는 기능
 *    Panel
 *      Window
 *         Frame, Dialog
 *         
 * Java의 리스너
 * - 인터페이스의 규칙에 따라 클래스를 작성해야 한다.
 * - 인터페이스 규칙을 따른다 => 인터페이스에 선언된 모든 메서드를 정의한다.
 * - 자바스크립트와 차이점은 메서드가 아니라 객체를 등록해야 한다.
 */
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/* 각 기능 별로 Control 클래스 분리
 * - 사용자가 입력한 데이터를 가공하여 Dao에게 전달
 * - Dao가 리턴한 데이터를 가공하여 Boundary에게 전달
 * - 일단, 현재는 Control이 Dao와 Boundary 역학을 겸한다. 
 * 
 */
import java.util.Scanner;
public class StudentMgtSystem01 {
	static Scanner scanner = new Scanner(System.in);
	
	private static String promptMenu() {
		System.out.printf("\n\n< 학적부 조회 시스템 >\n");
		System.out.println("----------------------");
		System.out.println("1. 학생관리");
		System.out.println("2. 점수관리");
		System.out.println("q. 종료");
		System.out.println("----------------------");
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase(); 
	}
	
	public static void main(String[] args) {
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
}













