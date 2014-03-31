package basic.exam06;

import java.awt.Button;


@SuppressWarnings("serial")
public class StudentPanel extends ContentPanel {
// 더이상 SudentMgtSystem은 필요하지 않다..개별적으로 리스너도 받지 않는다.
	public StudentPanel() {
		super("학생관리");
		
		content.add(new Button("okok"));
		
	}
}








