import java.io.IOException;

public class processMain {
	public static void main(String[] args) throws IOException {
		// processbuild
		// 프로그램을 실행시키는 클래스
		// 프로그램을 실행시킨 상태 -> 프로세스
		
//		ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe");
//		ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Internet Explorer\\iexplore.exe","www.naver.com");
		// 그림판
		ProcessBuilder pb = new ProcessBuilder("C:/Windows/System32/mspaint.exe");
		pb.start();
	}
}
