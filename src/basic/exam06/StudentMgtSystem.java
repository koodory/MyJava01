package basic.exam06;

/* 
 * 
 */
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* Custom Event 다루기
 * - 이벤트 처리 방식을 사용하여 쌍방향 참조를 제거 
 * 1) Event 정의
 * - StateChangeEvent 클래스 생성
 * 2) Event Listener 정의
 * - 이벤트가 발생했을 때 호출할 메서드를 정의
 * - caller와 callee 사이의 호출 규칙은 인터페이스 문법으로 정의한다.
 * - 인터페이스란? Caller와 Callee 사이의 호출 규칙이다.
 * - 추상클래스란? 하위 클래스들에게 상속해 줄 공통 속성과 공통 기능을 정의한 클래스이다.
 * - 추상메서드란? 하위 클래스에서 반드시 정의해야 하는 메서드이다.
 */
@SuppressWarnings("serial")
public class StudentMgtSystem extends Frame {
	public static final String MENU_PANEL = "MenuPanel";
	public static final String STUDENT_PANEL = "StudentPanel";
	public static final String SCORE_PANEL = "ScorePanel";
	
	MenuPanel menuPanel;
	StudentPanel studentPanel;
	ScorePanel scorePanel;
	
	// StateChangeListener 인터페이스를 구현한 익명 클래스 정의
	StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override //리스너 함수를 재정의함 --> StateChangeListener에서 호출됨
    public void stateChanged(StateChangeEvent e) {
		  // 메뉴화면,학생관리화면,점수관리화면 출력을 지정
			// changepanel의 내용을 등록 
			CardLayout cardLayout = 
					(CardLayout)StudentMgtSystem.this.getLayout();
			// 외부클래스.this --> 여기 this는 StateChangeListener 
			//바깥 클래스를 접근하기 위해서 직접 클래스 지정
			
			//stateName이 "back"일 경우 MENU_PANEL 보여줌
			if (e.stateName.equals("back")) {
				cardLayout.show(StudentMgtSystem.this, MENU_PANEL);
				
			} else if (e.stateName.equals("studentPanel")) {
				cardLayout.show(StudentMgtSystem.this, STUDENT_PANEL);
				
			} else if (e.stateName.equals("scorePanel")) {
				cardLayout.show(StudentMgtSystem.this, SCORE_PANEL);
			}
    }
	};
	
	public StudentMgtSystem() {
		super("학생관리시스템"); 
		setSize(800, 600);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		
		setLayout(new CardLayout()); // 메뉴화면,학생관리화면,점수관리화면 겹치게 함.
		
		menuPanel = new MenuPanel(); //더이상 생성자에게 주소를 넘겨줄 필요가 없음
		studentPanel = new StudentPanel();
		scorePanel = new ScorePanel();
		
		//리스너를 각 인스턴스에 등록해준다. 리스너 객체를 파라미터로 전달
		menuPanel.addStateChangeListener(stateChangeListener);
		studentPanel.addStateChangeListener(stateChangeListener);
		scorePanel.addStateChangeListener(stateChangeListener);
		
		// CardLayout인 경우 자식 컴포넌트를 붙일 때 
		// 이름을 함께 주어야 한다.
		add(menuPanel, MENU_PANEL);
		add(studentPanel, STUDENT_PANEL);
		add(scorePanel, SCORE_PANEL);
		
	}
	
	public static void main(String[] args) {
		StudentMgtSystem f = new StudentMgtSystem();
		f.setVisible(true);
		
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
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
			
		} while(true);
		*/
	}
	

}













