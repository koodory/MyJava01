package basic.exam06.jdbc;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentScoreControl {
	static Scanner scanner;
	// ArrayList에 저장할 인스턴스의 타입을 지정 
	public ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();
		
	public void add(final StudentScore score) {
		scoreList.add(score);
	}
	
	public void remove(final int no) {
	  scoreList.remove(no);
  }
	
	public void update(final int no, final StudentScore s) {
		scoreList.set(no,s);
  }
	
	public void save() {
		try {
			FileWriter out = new FileWriter("studentscore.data");
			for(StudentScore score : scoreList) {
				out.write(score.toString() + "\n");
			}
			out.close();
			System.out.println("File Save!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void load() {
		try {
			FileReader in = new FileReader("studentscore.data");
			Scanner s = new Scanner(in);
			while(true) {
				try {
					scoreList.add(StudentScore.fromCSV(s.nextLine()));
				} catch (NoSuchElementException ex) {
					break;
				}
			}
			s.close();
			in.close();
			System.out.println("File Load!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}














