package basic.exam05.step01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* BufferedInputStream/BufferedOutputStream
 * - 파일을 읽을 때 :  바이트씩 읽는 것보다 왕창 읽는 게 빠르다.
 * - 파일 읽기 시간 = data seek time + data transfer time
 * => data seek time: HDD 헤더를 움직여 데이터가 있는 트랙으로 이동한 후
 * 										트랙이 돌 떄 셋터를 찾는 것 까지의 시간
 * 예) 1 byte 읽는 데 걸리는 시간 = data seek time(예: 0.0085초)
 *                                + data transfer time (예: 3.3 * 10 ^ -9 sec)
 * 
 */
public class Episode06{
	
	
	public static void main(String[] args) throws Exception{
	//BufferedInputStream의 사용 + buf 사용
		FileInputStream in = new FileInputStream("a.zip");
		BufferedInputStream in2 = new BufferedInputStream(in);
		
		byte[] buf = new byte[1024];
		int len = 0;
		int count = 0 ;
		long startTime = System.currentTimeMillis();
		while((len=in2.read(buf))!=-1){ //buf를 사용하면 읽은 개수를 리턴
			if((++count % 1000) == 0){
				System.out.printf(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간은 (밀리초) =" + duration);
	}
	
	public static void main03(String[] args) throws Exception{
	//BufferedInputStream의 사용
		FileInputStream in = new FileInputStream("a.zip");
		BufferedInputStream in2 = new BufferedInputStream(in);
		
		int b;
		int count = 0 ;
		long startTime = System.currentTimeMillis();
		while((b=in2.read())!=-1){ //buf를 사용하면 읽은 개수를 리턴
			if((++count % 10000000) == 0){
				System.out.printf(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간은 (밀리초) =" + duration);
	}
	
	public static void main02 (String[] args) throws Exception{
	// 버퍼로 데이터 읽기
		FileInputStream in = new FileInputStream("a.zip");
		
		byte[] buf = new byte[1024];
		int len = 0;
		int count = 0 ;
		long startTime = System.currentTimeMillis();
		while((len=in.read(buf))!=-1){ //buf를 사용하면 읽은 개수를 리턴
			if((++count % 1000) == 0){
				System.out.printf(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간은 (밀리초) =" + duration);
	}
	
	public static void main01(String[] args) throws Exception{
	// 1바이트씩 데이터 읽기
		FileInputStream in = new FileInputStream("a.zip");
		
		int b;
		int count = 0 ;
		long startTime = System.currentTimeMillis();//1970.01.01.00:00 부터 지금까지
		while((b=in.read())!=-1){
			if((++count % 1000000) == 0){
				System.out.printf(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간은 (밀리초) =" + duration);
	}
}
