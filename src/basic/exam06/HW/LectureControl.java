package basic.exam06.HW;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LectureControl {
			
		public ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
		
		public void add(Lecture lecture){
			lectureList.add(lecture);
		}
	    
		public void remove(final int no){
			lectureList.remove(no);
		}
		
		public void update(final int no, Lecture l){
			lectureList.set(no, l);
		}
		public void save(){
			try{
				FileWriter out = new FileWriter("lecture.dat");
				for(Lecture lecture: lectureList){
					out.write(lecture + "\n");
				}
				out.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		public void load(){
			try{
				FileReader in = new FileReader("lecture.dat");
				Scanner s = new Scanner(in);
				while(true){
					try{
						lectureList.add(Lecture.fromCSV(s.nextLine()));
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














