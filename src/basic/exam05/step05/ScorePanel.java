package basic.exam05.step05;

import java.awt.Button;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ScorePanel extends ContentPanel implements ActionListener {
	
	public ScorePanel(StudentMgtSystem parent) {
		super(parent,"학생관리");
		content.add(new Button("점수 관리에 무언가를 넣고 싶으면 컨텐츠에 넣어라"));
	}
}
