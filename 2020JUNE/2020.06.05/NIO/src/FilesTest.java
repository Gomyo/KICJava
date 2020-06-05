import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FilesTest {
	public void copyTest() throws IOException {
		Path src = Paths.get("c:/windows/explorer.exe");
		Path target = Paths.get("c:/Temp/files_copy_explorer.exe");
		if (Files.isReadable(src)) {
			Files.copy(src, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("복사 완료");
		}
	}
	public void readTextFile() throws IOException {
		Path target = Paths.get("./개포1동.txt");
		BufferedReader br = Files.newBufferedReader(target);
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		List<String> lines = Files.readAllLines(target);
		for (String line2 : lines ) {
			System.out.println(line2);
		}
	}
	public static void main(String[] args) throws IOException {
		FilesTest ft = new FilesTest();
//		ft.copyTest();
		ft.readTextFile();
	}

}
