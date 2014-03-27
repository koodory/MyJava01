package test_prep.step09;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentMgtSystem09 {
	private static Scanner scanner = new Scanner(System.in);

	private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();

	private static String[] promptCommand(){		
		System.out.print("명령>");
		String input = scanner.nextLine();

		return input.split(" ");
	}

	private static void executeAdd(final String value) {

		StudentScore score = StudentScore.fromCSV(value);
		System.out.println("이름 : " + score.name);
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.math);

		System.out.print("등록하시겠습니까?(y/n) : ");
		String input = scanner.nextLine();
		if("y".equals(input.toLowerCase())){
			System.out.println("등록되었습니다.");
			scoreList.add(score);
		}else{
			System.out.println("등록이 취소되었습니다.");
		}
	}

	private static void executeList() {
		int i=0;
		for(StudentScore score: scoreList){
			System.out.println(i++ + " "+ score);
		}
	}

	private static void executeDelete(final int no) {
		if(no >= 0 && no < scoreList.size()){
			scoreList.remove(no);
		}else{
			System.out.println("유효하지 않은 번호입니다.");
		}
	}

	private static void executeUpdate(final int no) {
		if(no >= 0 && no < scoreList.size()){
			StudentScore score = scoreList.get(no);
			System.out.print("이름 : ( "+score.name+" ) :");
			String input = scanner.nextLine();
			StudentScore temp = new StudentScore(input);

			System.out.print("국어 : ( "+score.kor+" ) :");
			input = scanner.nextLine();
			temp.kor = Integer.parseInt(input);

			System.out.print("영어 : ( "+score.eng+" ) :");
			input = scanner.nextLine();
			temp.eng = Integer.parseInt(input);

			System.out.print("수학 : ( "+score.math+" ) :");
			input = scanner.nextLine();
			temp.math = Integer.parseInt(input);

			System.out.print("등록하시겠습니까?(y/n) : ");
			input = scanner.nextLine();
			if("y".equals(input.toLowerCase())){
				System.out.println("등록되었습니다.");
				scoreList.set(no,temp);
			}else{
				System.out.println("등록이 취소되었습니다.");
			}
		}else{
			System.out.println("유효하지 않은 번호입니다.");
		}
	}

	private static void executeSave() {
		try{
			FileWriter out = new FileWriter("student.dat");
			for(StudentScore score: scoreList){
				out.write(score.toString() + "\n");
			}
			out.close();	
			System.out.println("데이터가 저장되었습니다.");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	private static void executeLoad() {
		try{
			FileReader in = new FileReader("student.dat");
			Scanner s = new Scanner(in);
			scoreList.clear();
			
			while(true){
				try{
					scoreList.add(StudentScore.fromCSV(s.nextLine()));
				}catch(NoSuchElementException ex){
					break;
				}
			}
			s.close();
			in.close();
			System.out.println("데이터가 로딩되었습니다.");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		do{
			String[] values = promptCommand();
			if("add".equals(values[0])){
				executeAdd(values[1]);
			}else if("list".equals(values[0])){
				executeList();
			}else if("delete".equals(values[0])){
				executeDelete(Integer.parseInt(values[1]));
			}else if("update".equals(values[0])){
				executeUpdate(Integer.parseInt(values[1]));
			}else if("load".equals(values[0])){
				executeLoad();
			}else if("save".equals(values[0])){
				executeSave();
			}else if("q".equals(values[0])){
				System.out.println("프로그램을 종료합니다.");
				break;
			}else{
				System.out.println("해당 명령어를 찾을 수 없습니다.");
			}
		}while(true);
		scanner.close();
	}
}
