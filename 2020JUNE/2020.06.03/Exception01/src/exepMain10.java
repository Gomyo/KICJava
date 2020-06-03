import java.io.IOException;

public class exepMain10 {

	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("C:/Windows/System32/mspain3t.exe");
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[Error] "+e.getMessage());
		}
	}

}
