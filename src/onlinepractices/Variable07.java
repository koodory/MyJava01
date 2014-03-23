package onlinepractices;

public class Variable07 {
	
	int a = 10;
	
	public void method1(int b){ //b= 100
		int a = 20; 
		int c = 30; 
		System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		{
			int t= 100;
		  a= 200; //
			b= 300; //
			
			c= 400; //
			{
				int p = 1000;
				t = 20;
			}
			System.out.println("a = " + a + ", b = " + b + ", c = " + c);
		}
		int VariableTest07 = 10000;
		int method1 = 10000;
		System.out.println("VariableTest_6 = " + VariableTest07 + ", Method1 =" 
		+ method1);
	}
	public static void main(String[] args) {
		Variable07 Obj = new Variable07();
		Obj.method1(100);
		
		System.out.println("Obj.a = " + Obj.a);
	}

}
