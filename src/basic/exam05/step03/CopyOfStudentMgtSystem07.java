package basic.exam05.step03;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/* 각 기능 별로 Control 클래스 분리
 * - 사용자가 입력한 데이터를 가공하여 Dao에게 전달
 * - Dao가 리턴한 데이터를 가공하여 Boundary에게 전달
 * - 일단, 현재는 Control이 Dao와 Boundary 역학을 겸한다. 
 * 
 */
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CopyOfStudentMgtSystem07 extends Frame implements ActionListener{
	static Scanner scanner = new Scanner(System.in);
	Panel menuPanel = new Panel();
	Button btnScoreMgt = new Button("점수관리");
	Button btnStudentMgt = new Button("학생관리");
	
	public CopyOfStudentMgtSystem07(){
		super("학생관리시스템"); // 호출할 수퍼 클래스 생성자를 지정할 수 있음
	  //super(); // 호출할 수퍼 클래스 생성자를 지정하지 않는다면 기본 생성자 호출
	  //setTitle("학생관리시스텐"); //기본 생성자 호출후 setTitle()을 호출해도 됨
		setSize(400,300);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 
			}
		});
		setLayout(new FlowLayout());
    menuPanel.setSize(30,100);
	  menuPanel.setPreferredSize(new Dimension(70,100));
	  add(menuPanel);
	 	  
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this); 
				
		menuPanel.add(btnStudentMgt);
		menuPanel.add(btnScoreMgt);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStudentMgt){
		JOptionPane.showMessageDialog(null, "학생관리");
		}else{ //btnScoreMgt
			JOptionPane.showMessageDialog(null, "점수관리");	
		}
	}

	public static void main(String[] args) {
		CopyOfStudentMgtSystem07 f = new CopyOfStudentMgtSystem07();
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














