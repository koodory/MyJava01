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

public class StudentMgtSystem04 {
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

    p.setSize(30,100);
		p.setPreferredSize(new Dimension(70,100));

		Button btnStudentMgt = new Button("학생관리");
		btnStudentMgt.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호라 이거");
			}
		});
		
		Button btnScoreMgt = new Button("점수관리");
		btnScoreMgt.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호라 이거");
			}
		});
		
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














