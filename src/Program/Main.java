package Program;
import java.util.Scanner;
import Boards.Draw;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static String StringNum() {
	Scanner sc = new Scanner(System.in);
	String num;
	String numLists[] = {"1","2","3","4","5"};
	String number;
	
		while(true) 
		{
			System.out.print("메뉴를 선택해주세요:  ");
			num = sc.next();
			String numArr[] = num.split("");
			if(numArr.length == 1)
			{
				for(int i = 0 ; i < numLists.length; i++) 
				{
					if(numLists[i].contains(num)) 
					{
						number = num;
						return number;
					}
				}
			}
			else if(numArr.length > 1)
			{
				System.out.println("잘못된 입력입니다.입력하신 값을 확인해주세요.");
			}
		}
	
	}
	public static int SelectFile() {
		int number;
	
			while(true) 
			{
				System.out.println("\n몇 번 파일을 고르시겠습니까? (1번 ~ 5번)");
				number = sc.nextInt();
				if(number>=1 && number<=5) 
				{
					return number-1;
				}
				else
				{
				System.out.print("파일을 다시 선택하세요 (1번 ~ 5번)");
				}
			}	
	}
	static String begin(){
		String begin ="";
		System.out.println("----------------------------------------------------------------------\n");
		System.out.println("이 프로그램은 사용자로부터 좌표를 입력받아서 원하는 위치에 그림을 그릴 수 있는 그림판입니다.\n");
		System.out.println("프로그램 내에 다양한 기능들을 이용하여 그림을 그려보세요.\n");
		System.out.println("Y를 누르시면 프로그램이 실행되며 N을 누르시면 프로그램을 종료합니다.\n");
		System.out.println("프로그램을 시작하시겠습니까? ( Y or N ) >> \n");
		System.out.println("----------------------------------------------------------------------");
		
		while(true) 
		{
		begin = sc.next();
			if(begin.equals("y") || begin.equals("Y"))
			{
				return begin;
			}
			else if(begin.equals("n") || begin.equals("N")) 
			{
				return begin;
			}
			else 
			{
				System.out.println("Y 혹은 N을 입력해주세요.");
			}
		}
	}
	
	public static void main(String[] args){
		String begin;
		String select;
		int fileNum;
		String[] menu = {" 1. 그림판", " 2. 사진첩", " 3. 예시", " 4. 사용설명서", " 5. 종료"};
		Scanner scan = new Scanner(System.in);
		Draw[] drawing = new Draw[5];
		ArrayList<String> album = new ArrayList<String>();
		ArrayList<String[][]> album1 = new ArrayList<String[][]>();
		
		
		Login log = new Login();
		log.SignIn();
		begin = begin();
		for(int i = 0 ; i < drawing.length; i++)
		{
				drawing[i] = new Draw();
		}
			
			if(begin.equals("y") || begin.equals("Y")) 
			{
				System.out.println("포토샵 프로그램을 시작합니다...");
				while(true) 
				{
						System.out.println(" ㅡㅡㅡㅡㅡ메뉴ㅡㅡㅡㅡㅡ");
						for(int i = 0; i < menu.length; i++) 
						{
							System.out.println(menu[i]);
						}
						System.out.println(" ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						
						select = StringNum();
						
				if(select.equals("1")) 	//1.그림
				{
					for(int i = 0 ; i < drawing.length; i++) 
					{
						System.out.print(i+1+". ");
						System.out.println(drawing[i].getFileName());
					}
						fileNum=SelectFile();
						drawing[fileNum].editFileName();
					for(int i = 0 ; i < drawing.length; i++) 
					{
						System.out.print(i+1+". ");
						System.out.println(drawing[i].getFileName());
					}
					drawing[fileNum].DrawMenu();
				}
				
				else if(select.equals("2")) 		//2. 앨범
				{
					int count = 0;
					
					for(int i = 0 ; i < drawing.length; i++) 
					{
						if(drawing[i].save == true) 
						{
							count++;
							album.add(drawing[i].getFileName());
							album1.add(drawing[i].board);
						}
					}
					if(count > 0) 
					{
						int fileNumber=1;
						for(int i = 0 ; i < album.size(); i++)
						{
								System.out.println(+fileNumber+"번 파일");
								System.out.println(album.get(i));
								String[][] tmp = album1.get(i);
								System.out.print("  ");
								for(int j = 0; j < tmp.length; j++) 
								{
									System.out.print(" "+ j);
									if(j==tmp.length-1) 
									{
										System.out.println();
									}
								}
								for(int j = 0 ; j < tmp.length; j++) 
								{
									System.out.print(j+"  ");
									for(int k = 0 ; k < tmp[j].length; k++) 
									{
										System.out.print(tmp[j][k]);
									}
									System.out.println();
								}
								System.out.println();
								fileNumber++;
						}
					}
					else if(count == 0)
					{	
						System.out.println();
						System.out.println("------------------------");
						System.out.println("앨범에 저장된 파일이 없습니다.");
						System.out.println("------------------------\n");
					}
				}	
				
				else if(select.equals("3")) {		//3. 예시
				Sample sample = new Sample();
				sample.showSample1();
				sample.showSample2();
				}
				
				else if(select.equals("4")) {		//4. 사용설명서
					Manual man = new Manual();
					try {
						man.showManual();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				else if(select.equals("5")) {		//5. 종료
					String exit;
					System.out.println("포토샵 프로그램을 종료하시겠습니까? (Y/N)");
					exit= scan.next();
					if(exit.equals("y") || exit.equals("Y")) {
					System.out.println("<"+log.nickName+"님> 저희 포토샵 프로그램을 사용해주셔서 감사합니다.또 이용해주세요.");
					System.out.println("시스템을 종료합니다. ");
					break;                                                                                                                                                     
					}
					else {
						System.out.println("메뉴로 돌아갑니다.");
					}
				}
				else {						
					System.out.println("1번부터 5번까지의 메뉴를 입력해주세요.");
				}
			}
		}
	}			
}	




