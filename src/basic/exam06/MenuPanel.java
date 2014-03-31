package basic.exam06;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 더이상 parent는 필요없다. ContentPanel을 상속받에 만듬
@SuppressWarnings("serial")
public class MenuPanel extends ContentPanel implements ActionListener {
	Button btnStudentMgt = new Button("학생관리");
	Button btnScoreMgt = new Button("점수관리");
	
	public MenuPanel() {
		super("메뉴");
		// 생성자에서 자식 컴포넌트들을 준비한다.
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this);
		
		// 상속받은 컨텐츠 패널안의 자식 content에 버튼을 추가해야 함
		this.content.add(btnStudentMgt);
		this.content.add(btnScoreMgt);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStudentMgt) {
			this.fireEvent(new StateChangeEvent(this, "studentPanel"));
			// btnStudentMgt을 누르면 이벤트 소스와 비교하고 맞을 경우 이벤트 발생
		} else { // btnScoreMgt
			this.fireEvent(new StateChangeEvent(this, "scorePanel"));
		// btnScoreMgt을 누르면 이벤트 소스와 비교하고 맞을 경우 이벤트 발생
		}
		
	}
	
}













