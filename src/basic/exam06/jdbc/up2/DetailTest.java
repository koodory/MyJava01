package basic.exam06.jdbc.up2;

import java.util.Scanner;

/* PreparedStatement 사용
 */
public class DetailTest {

	public static void main(String[] args) throws Throwable {
		SubjectDao dao = new SubjectDao();
		Scanner sc = new Scanner(System.in);
		
		SubjectVo subject = dao.detail(Integer.parseInt(sc.nextLine()));
		
		System.out.print(subject.no);
		System.out.print(subject.title);
		System.out.println(subject.description);
		sc.close();
	}
}












