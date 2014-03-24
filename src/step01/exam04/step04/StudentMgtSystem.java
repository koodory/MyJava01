package step01.exam04.step04;

/* 인스턴스들을 보관 : Collection
 * - 배열
 * - Collection 전문 클래스
 */
import java.util.Scanner;
public class StudentMgtSystem { 
	private static Scanner scanner = new Scanner(System.in);
	
	// StudentScore 주소를 저장할 레퍼런스 배열 생성
	private static StudentScore[] scoreList = new StudentScore[3];
	private static int scoreSize = 0;
	
	private static String[] promptCommand(){
		System.out.print("명령>");
		String input = scanner.nextLine(); // 키보드로 들어온 값을 익는다 엔터를 만날떄까지..
	
		return input.split(" ");
	}
	
	private static void excuteAdd(String value) {
	  String input;
	  
	  // 로컬 변수에 담는 대신 클래스 변수에 저장한다
	  //StudentScore score = StudentScore.fromSCV(value);
	  if(scoreSize < 3){
	  	scoreList[scoreSize++] = StudentScore.fromCSV(value);
	  } else{
	  	System.out.println("저장소가 꽉 찼습니다.");
	  	return; // 즉시를 함수를 탈출
	  }
	  
	  System.out.println("이름 : " + scoreList[scoreSize-1].name);
	  System.out.println("국어 : " + scoreList[scoreSize-1].kor);
	  System.out.println("영어 : " + scoreList[scoreSize-1].eng);
	  System.out.println("수학 : " + scoreList[scoreSize-1].math);
	  System.out.print("등록하시겠습니까?(y/n)");
	  input = scanner.nextLine();
	  if("y".equals(input.toLowerCase())){
	  	System.out.println("등록되었습니다.");
	  }else{
	  	System.out.println("등록 취소되었습니다.");
	  }
  }
	
	public static void main(String[] args) {
		String input = null; //로컬 변수는 항상 null로 초기화 한다.
		
		do{
			String[] values = promptCommand();
			
			if("add".equals(values[0])){ 
				excuteAdd(values[1]);
			}else if("quit".equals(values[0])){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{
				System.out.println("사용할 수 없는 명령어입니다.");
			}
		}while(true);
		scanner.close();
	}
}
