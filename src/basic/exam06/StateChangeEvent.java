package basic.exam06;

import java.util.EventObject;

// 개념
// 1) 기본생성자: 개발자가 만들지 않으면 컴파일러가 자동생성
// 2) 생성자에서 super 클래스의 생성자를 지정하지 않으면 , 수퍼의 기본생상자 호출
// 3) java.op.Serializable 구현 클래스는 가능한 데이터 버전 정보를 가져야 한다.
// - 부모 클래스가 구현하면 자식 클래스는 자동 적용
// 4) Overloading : 같은 기능을 하는 메서드에 대해 같은 이름 부여 ->
//                   프로그래밍의 일관성 부여
// 5) 상속 : 수퍼클래스의 속성과 메소드를 물려받는다. 기존코드 재사용


public class StateChangeEvent extends EventObject {
	// 구체적인 생성자를 생성해야함..
  private static final long serialVersionUID = 1L; 
  //BitStream으로 이벤트 객체를 전달하므로 번호 부여해야 함. 

  public String stateName;//전달할 이벤트 상태
  
  //기본생성자
  /*
  public StateChangeEvent(){
  	super();
  }
  */
  
	public StateChangeEvent(Object source) {
		// Object source, source 인스턴스에 이벤트 주소가 담겨있음
	  super(source);
  }
	
	public StateChangeEvent(Object source, String stateName) {
	  super(source);
	  this.stateName = stateName;
  }

}
