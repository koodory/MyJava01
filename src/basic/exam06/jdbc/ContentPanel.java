package basic.exam06.jdbc;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// 이벤트 리스너가 완성되면 더이상 parent(super class)는 필요하지 않으므로 삭제한다.
// 
@SuppressWarnings("serial")
public class ContentPanel extends Panel implements ActionListener{
	protected Label title = new Label();
	protected Button btnBack = new Button("뒤로");
	protected Panel content = new Panel(); //Menu pannel이 차후 새로운 객체 생성할 인스턴스 
	
	// 리스너를 여러개 저장할 수 있는 공간이 필요 --> ArrayList 생성
	// StateChangeListener에 해당하는 객체만 담겠다!! - Generic 설정
	protected ArrayList<StateChangeListener> listeners = 
			new ArrayList<StateChangeListener>();
	
	public ContentPanel(String title) {
		this.setLayout(new BorderLayout());
		
		this.title.setText(title);
		
		Panel titlebar = new Panel();
		titlebar.add(this.title);
		titlebar.add(btnBack);
		this.add(titlebar, BorderLayout.NORTH);
		
		this.add(content, BorderLayout.CENTER);
		
		btnBack.addActionListener(this); 
		//누르는 순간 actionPerformed 호출 --> fireEvent호출 --> 저장된 모든 event 호출하여 전달
	}

	@Override
  public void actionPerformed(ActionEvent e) {
	  fireEvent(new StateChangeEvent(this, "back")); 
	  //이벤트가 발생할 때 상태를 전달하는 메서드
	  // StateChangeEvent에 이 이벤트와 이벤트 behavior를 같이 전달
  }
	
	// 이벤트 관련 메서드 정의, 여기서 이벤트를 발생했을 때 처리하는 이벤트 생성 
	public void addStateChangeListener(StateChangeListener l) {
		listeners.add(l); //Array 추가 메서드 
	}
	
	public void removeStateChangeListener(StateChangeListener l) {
		listeners.remove(l);//Array 삭제 메서드
	}
	
	public void fireEvent(StateChangeEvent e) {
		// 반복문을 돌면서 모든 메소드에 이벤트 전달
		for(StateChangeListener l : listeners) {
			l.stateChanged(e);
		} 
	}
}














