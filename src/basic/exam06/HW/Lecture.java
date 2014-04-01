package basic.exam06.HW;
public class Lecture {
	String 		title;
	String 	  teacher;
	String 		startDate;
	String 		endDate;
	String 		classRoom;
	String    manager;
	int       hours;
	int 			year;
	int       month;
	int       day;
	
	public static Lecture fromCSV(String value) {
		String[] data = value.split(",");
		
		Lecture obj = new Lecture();
		obj.title = data[0];
		obj.teacher = data[1];
		obj.startDate = data[2];
		obj.endDate = data[3];
		obj.classRoom = data[4];
		obj.manager = data[5];
		obj.hours = Integer.parseInt(data[6]);
		
		return obj;
	}

	public static Lecture fromCSV2(String value2){
		String[] data2 = value2.split("-");
		
		Lecture obj2 = new Lecture();
		obj2.year = Integer.parseInt(data2[0]);
		obj2.month = Integer.parseInt(data2[1]);
		obj2.day = Integer.parseInt(data2[2]);
		
		return obj2;
	}
	
	@Override
  public String toString() {
	  return title + "," + teacher + "," + startDate + "," + 
	  				endDate + "," + classRoom + "," + manager + "," + hours  ;
	}
}



















