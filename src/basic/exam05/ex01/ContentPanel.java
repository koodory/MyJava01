package basic.exam05.ex01;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ContentPanel extends Panel implements ActionListener {
	protected Label title = new Label();
	protected Button btnBack = new Button("뒤로");
	protected Panel content = new Panel();
	
	protected ArrayList<StateChangeListener> listeners = 
			new ArrayList<StateChangeListener>();
	
	//protected : package가 달라도 subclass라도 접근가능
 	public ContentPanel(String title){
		this.setLayout(new BorderLayout());
		this.title.setText(title);
		
		Panel titlebar = new Panel();
		titlebar.add(this.title);
		titlebar.add(btnBack);
		this.add(titlebar, BorderLayout.NORTH);
		this.add(content, BorderLayout.CENTER);
		
		btnBack.addActionListener(this);
	}
	@Override
  public void actionPerformed(ActionEvent e) {
	  fireEvent(new StateChangeEvent(this, "back"));
  }
	
	public void addStateChangeListener(StateChangeListener l){
		listeners.add(l);
	}
	
	public void removeStateChangeListener(StateChangeListener l){
		listeners.remove(l);
	}
	
	public void fireEvent(StateChangeEvent e){
		for(StateChangeListener l : listeners){
			l.stateChanged(e);
		}
	}
}
