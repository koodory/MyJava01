package basic.exam06;

import java.awt.Button;


@SuppressWarnings("serial")
public class ScorePanel extends ContentPanel {
	public ScorePanel() {
		super("점수관리");
	// 더이상 SudentMgtSystem은 필요하지 않다..개별적으로 리스너도 받지 않는다.
		content.add(new Button("점수관리에 뭔가 넣고 싶다!"));
		
	}
}









