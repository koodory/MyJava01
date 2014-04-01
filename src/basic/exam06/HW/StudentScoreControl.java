package basic.exam06.HW;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentScoreControl {
			
		public ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();
		
		public void add(StudentScore score){
			scoreList.add(score);
		}
	    
		public void remove(final int no){
			scoreList.remove(no);
		}
		
		public void update(final int no, StudentScore s){
			scoreList.set(no, s);
		}
		public void save(){
			try{
				FileWriter out = new FileWriter("studentscore.dat");
				for(StudentScore score: scoreList){
					out.write(score + "\n");
				}
				out.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		public void load(){
			try{
				FileReader in = new FileReader("studentscore.dat");
				Scanner s = new Scanner(in);
				while(true){
					try{
						scoreList.add(StudentScore.fromCSV(s.nextLine()));
					}catch(NoSuchElementException ex){
						break;
					}
				}
				s.close();
				in.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
}














