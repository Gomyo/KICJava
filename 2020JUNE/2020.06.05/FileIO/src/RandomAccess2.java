import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess2 {

	public static void main(String[] args) {
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("./score.dat", "rw");
			while (true) {
				System.out.println(raf.readInt());
			}
		}
		catch (EOFException e) {
			System.out.println("출력 완료");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf != null) try {raf.close();} catch (IOException e) {}
		}
	}

}
