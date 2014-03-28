package basic.exam05.step04;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ScorePanel extends Panel implements ActionListener {
	StudentMgtSystem parent;
	Label title = new Label("점수관리");
	Button btnBack = new Button("메뉴로");
	
	public ScorePanel(StudentMgtSystem parent) {
		this.parent = parent; // 부모 윈도우의 주소를 보관
		add(title);
		btnBack.addActionListener(this);
		add(btnBack);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBack) {
			parent.changePanel(StudentMgtSystem.MENU_PANEL);
		} 
	}
}
