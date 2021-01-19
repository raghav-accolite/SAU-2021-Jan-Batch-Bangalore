
public class AssignmentQUE2 {
	static int  divide (int a,int b) throws ArithmeticException{ 
		int c;
		try {
			 c= a/b;
		}
		catch(ArithmeticException e){
			throw new ArithmeticException("Dividing by zero");
		}
     
     return c;
    }  

	public static void main(String[] args) {
		int a=5,b=0;
		try {
			divide(a,b);
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}

	}

}
