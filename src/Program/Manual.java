package Program;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Manual{
	String address;
	
public Manual() {
	address=System.getProperty("user.dir");
}

public void showManual() throws FileNotFoundException{
	// address는 현재 파일의 위치를 나타낸다.
	File file = new File(address + "/src/Manual.txt");
	Scanner scan = new Scanner(file);
	
		while(scan.hasNextLine()) 
		{
			System.out.println(scan.nextLine());
		}
	}	
}
