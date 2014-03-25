package basic.exam05.step01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

/* binary 스트림과 Character 스트림의 비교
 * 1) binary스트림 클래스
 *  - 바이트 단위로 데이터를 읽고 쓴다.
 *  - inputStream, outputStream의 자손 클래스이다.
 *  - 클래스 이름 뒤에 InputStream, outputStream이 붙는다.
 *  
 *  2) character 스트림 클래스
 *  - 문자단위(Unicode 2Byte)로 데이터를 읽고 쓴다.
 *  - Reader/Write의 자손 클래스이다.
 *  - 클래스 이름뒤에 Reader/Writer가 붙는다.
 *  - 출력 -> Unicode 운영체제의 기본 인코딩으로 변환하여 출력한다.
 *  - 읽기 -> 읽은 데이터를 유니코드로 변환하여 리턴한다.
 * 
 */
public class Episode04 {

	public static void main(String[] args) throws Exception {
		//텍스트 읽기를 통한 동작 비교
		// - 영어는 1바트 읽어서 2바이트 유니코드로 변환
		// - 한글(UTF-8)은 3바이트 읽어서 2바이트 유니코드로 변환
		// 변환한 유니코드로 리턴
		FileReader in = new FileReader("student4.dat");
		int i =0;
		while((i = in.read()) != -1){
			System.out.println(Integer.toHexString(i));
		}
		in.close();
	}
	
	public static void main01(String[] args) throws Exception {
		//텍스트 읽기를 통한 동작 비교
		//바이너리 스트림으로 읽기
		FileInputStream in = new FileInputStream("student4.dat");
		int i =0;
		while((i = in.read()) != -1){
			System.out.println(Integer.toHexString(i));
		}
		in.close();
	}
}
