package test;


class PackageMemberClass{
	static class TopLevelInnerClass{}
	class MemberInnerClass{}
	public void Method(){
		class LocalInnerClass{}

		LocalInnerClass loc = new LocalInnerClass();
	}
	public void Method2(){
		class Student{
			String name;
			int age;
		}
		Student s1 = new Student();
		Student s2 = new Student();

		Object anonymous = new Object(){
			String name;
			int age;
		};

		Object anonymous2 = new Object(){
			String title;
			int price;
			int qty;
		};
	}
}


public class TestEpisode {
	public static void main(String[] args) {
		PackageMemberClass out = new PackageMemberClass();
		PackageMemberClass.MemberInnerClass in = out.new MemberInnerClass();
		PackageMemberClass.MemberInnerClass in2 = new PackageMemberClass.MemberInnerClass();


	}

}
