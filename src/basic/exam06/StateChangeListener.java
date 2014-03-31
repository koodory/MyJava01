package basic.exam06;

import java.util.EventListener;

// EventListener
// - 이벤트 처리 규칙을 표시용.
// - 메서드가 없다. 태깅용.
// - 즉 이 인터페이스는 이벤트의 규칙을 정의한다는 사실을 표시.
// 
// 인터페이스
// - 모든 메서드는 추상메서드이다. 하위 클래스에서 반드시 구현해야 한다.
//  문법) public abstract 리턴타입 메서드명(파라미터 선언...);
//       public sbstract를 생략할 수 있다.
//
// - 모든 변수는 상수이다.
//  문법) public static final 타입 변수 = 값;
// 인터페이스는 요청자와 요청받는자의 규칙
// 누가 호출하고 누가 호출당하는가를 파악하자
// 인터페이스의 모든 메서드는 public 이면서 callee다.

//이벤트 리스너를 상속받는다!!! 
//이벤트를 전달할 규칙을 정의함 --> STATECHANGE 함수
//이벤트 리스너가 호출할 함수너를 정의함, 이벤트 객체는 항상 e이다.
public interface StateChangeListener extends EventListener{
	/*public abstract*/ void stateChanged(StateChangeEvent e);
	// 메서드 시그너처 (function prototype) 만 존재, 메서드의 존재를 알림
	// 반드시 공개된다. implicit public 적용됨
}















