
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("OS :"+System.getProperty("os.name"));
		System.out.println("User :"+System.getProperty("user.name"));
		System.out.println("Path :"+System.getProperty("user.home"));
		
		// 환경변수
		System.out.println("Path : "+System.getenv("path"));
		System.out.println("JAVA_HOME : "+System.getenv("JAVA_HOME"));
		
	}

}
