package basic.exam05.step03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import javax.swing.JOptionPane;
/* LayoutManager
 * - 컨테이너에 컴포넌트를 위치시키는 역활을 당담
 * 1) BorderLayout
 * - 동, 서, 남 ,북
 * 2) FlowLayout
 * - 왼쪽에서 오른쪽으로 배치 => 끝을 만나면 라인에 이어서 배치
 * 3) GridLayout
 * - 바둑판 방식으로 배치 => 모든셀의 너비와 높이가 같다.
 * 4) CardLayout
 * - 중첩하여 배치 => Tab 화면을 만들때
 * 5) GridBagLayout
 * - GridLayout + 셀 병합기능 추가
 */
public class StudentMgtSystem03 {
	static Scanner scanner = new Scanner(System.in);
		
	public static void main(String[] args) {
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 
			}
		});
		
		Panel p = new Panel();
		// FlowLayout은 자식 컴포넌트를 배치할 때
		// 자식 컴포넌트가 원하는 크기를 먼저 알아낸 다음
		// 부모 컨테이너의 크기를 결정한다. => 자식 컴포넌트를 배치한다.
    p.setSize(30,100);
		p.setPreferredSize(new Dimension(70,100)); // 선호크기
//		p.setMaximumSize(new Dimension(30,100)); // 최대크기
		
		Button btnStudentMgt = new Button("학생관리");
		// 버튼인 경우 MouseClick 또는 KeyPress 이벤트가 발생했을 때
		// Action 이벤트를 추가로 발생 시킨다.
		btnStudentMgt.addActionListener(new ActionListener() { //메소드가 하나밖에 없음
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호라 이거");
			}
		});
		/*btnStudentMgt.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {   
				JOptionPane.showMessageDialog(null, "눌렀음");
      }			
		});
		btnStudentMgt.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent e){
				JOptionPane.showMessageDialog(null,"키 눌렀음");
			}
		});*/
		
		Button btnScoreMgt = new Button("점수관리");
		
		p.add(btnStudentMgt);
		p.add(btnScoreMgt);
		
		f.setLayout(new FlowLayout());
		f.add(p);
		
		f.setVisible(true);
	}	
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














