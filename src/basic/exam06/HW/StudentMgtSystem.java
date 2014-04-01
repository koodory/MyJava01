package basic.exam06.HW;


import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class StudentMgtSystem extends Frame{/* 적절한 클래스를 상속 받으시오 */ 
	public static final String MENU_PANEL = "MenuPanel";
	public static final String STUDENT_PANEL = "StudentPanel";
	public static final String SCORE_PANEL = "ScorePanel";
	public static final String LECTURE_PANEL = "lecturePanel";
	
	MenuPanel menuPanel;
	ScorePanel scorePanel;
	LecturePanel lecturePanel;
	StudentPanel studentPanel;
	
	StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override
    public void stateChanged(StateChangeEvent e) {
			CardLayout cardLayout = (CardLayout)StudentMgtSystem.this.getLayout();
			if(e.stateName.equals("back")){
				cardLayout.show(StudentMgtSystem.this, MENU_PANEL);
			}else if(e.stateName.equals("studentPanel")){
				cardLayout.show(StudentMgtSystem.this, STUDENT_PANEL);
      }else if(e.stateName.equals("scorePanel")){
				cardLayout.show(StudentMgtSystem.this, SCORE_PANEL);
			}else if(e.stateName.equals("lecturePanel")){
				cardLayout.show(StudentMgtSystem.this, LECTURE_PANEL);
			}
		}
	};
	
	public StudentMgtSystem() {
		super("학생관리시스템"); 
		setSize(800, 600);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			  scorePanel.save();
			  lecturePanel.save();
			  studentPanel.save();
			  System.exit(0);
			}
		
		});
		setLayout(new CardLayout()); 
		
		menuPanel = new MenuPanel();
		scorePanel = new ScorePanel();
		lecturePanel = new LecturePanel();
		studentPanel = new StudentPanel();
		
		lecturePanel.addStateChangeListener(stateChangeListener);
		menuPanel.addStateChangeListener(stateChangeListener);
		scorePanel.addStateChangeListener(stateChangeListener);
		studentPanel.addStateChangeListener(stateChangeListener);
		
		add(menuPanel, MENU_PANEL);
		add(scorePanel, SCORE_PANEL);
		add(lecturePanel, LECTURE_PANEL);
		add(studentPanel, STUDENT_PANEL);
	}
	
	public static void main(String[] args) {
		StudentMgtSystem f = new StudentMgtSystem();
		f.setVisible(true);
	}
	

}













