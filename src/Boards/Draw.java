package Boards;
import java.util.Scanner;

interface Function{		//interface
	String StringNum();
}

public class Draw extends Board implements Function{	
//Draw 클래스는 Function 인터페이스를 사용하며 Board 클래스를 상속받는다.
Scanner sc = new Scanner(System.in);

public boolean save = false;								

public Draw() {
	
}
boolean Save() {
	
	return true;
}
public void DrawMenu() {
	System.out.println();
	showFileName();
	showBoard();
	
		while(true) 
		{
			String option;
			System.out.print("1번: 그리기 | ");
			System.out.print("2번: 선 그리기 | ");
			System.out.print("3번: 지우개 | ");
			System.out.print("4번: 브러쉬 선택 | ");
			System.out.print("5번: 초기화 | ");
			System.out.println();
			System.out.print("6번: 앨범에 저장  | ");
			System.out.print("7번: 텍스트 파일로 저장 | ");
			System.out.print("8번: 종료 | ");
			System.out.println();
			option =  StringNum();
				if(option.equals("1")) {
				Sketch();
				}
				else if(option.equals("2")) {
					DrawLine();
				}
				else if(option.equals("3")) {
					Eraser();
				}
				else if(option.equals("4")) {
					SelectTool();
				}
				else if(option.equals("5")){
					System.out.println("그림을 초기화합니다. 진행하시겠습니까? (Y/N)");
					while(true) 
					{
					String clear = sc.next();
					if(clear.equals("y") || clear.equals("Y")) 
						{
							Clear();
							showFileName();
							showBoard();
							break;
						}
					else if(clear.equals("n") || clear.equals("N"))
						{
							System.out.println("그림을 초기화하지 않습니다. 그림판으로 돌아갑니다. ");
							showFileName();
							showBoard();
							break;
						}
					else
						System.out.println("Y와 N을 입력해주세요.");
					}
				}
					
				else if(option.equals("6")) 
				{		
						//저장
					String saveFile;
					System.out.println("앨범에 파일을 저장하시겠습니까? (Y/N)");
					while(true) 
					{
						saveFile = sc.next();
						if(saveFile.equals("y") || saveFile.equals("Y")) 
						{
							this.save = Save();
							System.out.println("파일을 저장하였습니다. 파일이 앨범에 추가됩니다.");
							break;
							}
						else if((saveFile.equals("n")) || !(saveFile.equals("N"))) 
						{
						System.out.println("파일을 앨범에 저장하지 않습니다. ");
						break;
						}
						else
							System.out.println("Y와 N을 입력해주세요.");
						}
				}
					else if(option.equals("7")) 	
				{									
					while(true) 
					{
						String printFile;
						System.out.println("텍스트 파일에 사진을 저장하시겠습니까? (Y/N)");
						printFile=sc.next();
						if(printFile.contentEquals("y") || printFile.contentEquals("Y")) 
						{
							writeFile(board);
							System.out.println("해당 그림은 해당 프로그램 src 파일 안에 txt 파일로 저장하였습니다.");
							break;
						}
						else if(printFile.contentEquals("n") || printFile.contentEquals("N")) 
						{
							System.out.println("그림판으로 돌아갑니다...");
							break;
						}	
						else
						{
							System.out.println("잘못 입력하셨습니다.Y 혹은 N을 입력해주세요.");
						}
					}
				}
				else if(option.equals("8")) 
				{
					String close;
					System.out.println("사진첩을 종료하시겠습니까? (Y/N)");
					while(true) 
					{
						close= sc.next();
						if(close.equals("y")||close.equals("Y")) 
						{
							System.out.println("사진첩을 종료합니다.");
							break;
							}
						else if((close.equals("n")) || !(close.equals("N"))) 
						{
						
						System.out.println("그림판으로 돌아갑니다.");
						}
						else
							System.out.println("Y와 N을 입력해주세요.");
					}		
					break;
				}
				else
					System.out.println("잘못 입력하셨습니다. 1번~8번 메뉴에서 선택해주세요.");
			}
}

public void Sketch(){		//1번 그리기
	int x;
	int y;
	
	while(true) 
	{
		System.out.println("그림을 넣을 좌표를 입력해주세요. ");
		System.out.print("행: ");
		y=sc.nextInt();
		System.out.print("열: ");
		x=sc.nextInt();
		if(x>=0 && x<=9) 
		{
			if(y>=0 && y<=9)
			{
				board[y][x] = tools[tool]+" ";
				break;
			}
		}
		else
		{
			System.out.println("입력하신 좌표가 그림판의 범위를 넘었습니다.");
		}
	}
	System.out.println();
	showFileName();
	showBoard();
}


public void DrawLine() {		//2번 선 그리기
	
	int x1;
	int y1; 		// 선 시작 좌표
	int x2;
	int y2; 		// 선 끝 좌표
	
	System.out.println("선을 그리실 시작 좌표와 끝 좌표를 입력해주세요");
	System.out.println("예시>> 시작좌표 행: 0 시작좌표 열: 0");
	System.out.println("예시>> 끝 좌표 행: 0 끝좌표 열: 5");
			while(true){
				System.out.println("시작 좌표 행: ");
					y1=sc.nextInt();
				System.out.println("시작 좌표 열: ");
					x1 = sc.nextInt();
				if((y1>=0 && y1 <=9) && (x1>=0 && x1<=9))
				{
					break;
				}
				else 
				{
					System.out.println("입력이 잘못되엇습니다. 다시 입력해주세요.");
				}
			}
			while(true) 
			{
				System.out.println("끝 좌표 행: ");
					y2=sc.nextInt();
				System.out.println("끝 좌표 열: ");
					x2=sc.nextInt();
				if((y2>=0 && y2<=9) && (x2>=0 && x2<=9)) 
				{
					break;
				}
				else 
				{
					System.out.println("입력이 잘못되엇습니다. 다시 입력해주세요.");
				}
			}
				int absX = absoluteNumber(x1,x2);
				int absY = absoluteNumber(y1,y2);
				if(y1==y2) 							// 행 값이 같으면 horizontal Line
					{
						HorizontalLine(x1, y1, x2, y2);
					}
				else if(x1==x2)						// 열 값이 같으면 vertical Line
					{
						VerticalLine(x1,y1,x2,y2);
					}
				else if(absX==absY)
					{
						Diagonal(x1,y1,x2,y2);
					}
				else
					{
						System.out.println("입력이 잘못되었습니다. 수직선, 수평선, 대각선(45도 각도)만 그릴 수 있습니다.");
					}
			System.out.println();
			showFileName();
			showBoard();
		}


public int absoluteNumber(int n1, int n2) {
int absDistance = n1 - n2;

	if(n1-n2<0) 
	{
		absDistance = -absDistance;
	}
	return absDistance;
}

public void HorizontalLine(int x1, int y1,int x2,int y2) {
	int tmp;
	
	if(x1 > x2)
	{
		tmp=x1;
		x1=x2;
		x2=tmp;
	}
	for(int i = x1; i <= x2; i++) 
	{
		board[y1][i]=tools[tool]+" ";
	}
}

public void VerticalLine(int x1, int y1, int x2, int y2) {
	int tmp;
	
	if(y1 > y2) 
	{
		tmp=y1;
		y1=y2;
		y2=tmp;
	}
	for(int i = y1; i <= y2; i++) 
	{
		board[i][x1]=tools[tool]+" ";
	}
}

public void Diagonal(int x1, int y1, int x2, int y2) {
	int count = absoluteNumber(x2, x1);
	
	if(x2 > x1 && y2 > y1) 
	{
		for(int i = 0 ; i <= count; i++) 
		{
			board[y1][x1]=tools[tool]+" ";
		x1++;
		y1++;
	}
	}
	else if(x2 > x1 && y2 < y1)
	{
		for(int i = 0; i <= count; i++) 
		{
			board[y1][x1]=tools[tool]+" ";
			x1++;
			y1--;
		}
	}
	else if(x2 < x1 && y2 > y1) 
	{
		for(int i = 0; i <= count; i++) 
		{
			board[y1][x1]=tools[tool]+" ";
			x1--;
			y1++;
		}
	}
	else if(x2 < x1 && y2 < y1)
	{
		for(int i = 0 ; i <= count; i++) 
		{
			board[y1][x1]=tools[tool]+" ";
		x1--;
		y1--;
		}
	}
	else 
	{
		System.out.println("잘못된 입력입니다. 수직선, 수평선, 대각선(45도 각도)만 그릴 수 있습니다.");
	}
	
}
	

public void Eraser() {			//3번 지우개
		int x;
		int y;
		
		while(true)
		{
			System.out.println("지우개를 사용할 좌표를 입력해주세요. ");
			System.out.print("행: ");
			y=sc.nextInt();
			System.out.print("열: ");
			x=sc.nextInt();
			if((x>=0 && x<=9) && (y>=0 && y<=9))
			{
				break;
			}
		else 
		{
			System.out.println("입력하신 좌표가 그림판의 범위를 넘었습니다. ");
		}	
		}
		board[y][x] = "  ";
		System.out.println();
		showFileName();
		showBoard();
	}
	

public void SelectTool(){		//4번 브러쉬 선택
	int num;
	
	while(true)
	{
	System.out.println("그리기 도구를 선택하세요.");
	for(int i = 0; i < tools.length; i++) 
	{
		System.out.println((i+1)+"번: "+tools[i]);
	}
	num = sc.nextInt();
	if(num >=1 && num <=5) 
	{
		this.tool = num-1;
		break;
	}
	else
		System.out.println("없는 도구입니다.");
	}
	System.out.println(num+"번 "+ "브러쉬가 선택되었습니다." + "( "+ tools[tool] +" )");
}

public void Clear() {		//5번 초기화
	for(int i = 0; i < board.length; i++) 
	{
		for(int j = 0; j<board[i].length; j++) 
		{
			board[i][j]= "  ";
		}
	}
	System.out.println("-------------------");
	System.out.println(" 그림이 초기화되었습니다.");
	System.out.println("-------------------");
	System.out.println();
}
public String getFileName() {
	return fileName;
}

public String editFileName() {
	changeFileName();
	return fileName;
}

@Override
public String StringNum() {
	Scanner sc = new Scanner(System.in);
	String num;
	String numLists[] = {"1","2","3","4","5","6","7","8"};
	String numArr[];
	String number;
	
	while(true) {
		System.out.print("숫자를 입력해주세요: ");
		num = sc.next();
		numArr = num.split("");
		if(numArr.length ==1)
		{
			for(int i = 0 ; i < numLists.length; i++) 
			{
				if(numLists[i].equals(num))
				{
					number = num;
					return number;
				}
			}
		}
		else if(numArr.length > 0) {
			System.out.println("잘못된 입력입니다.입력하신 값을 확인해주세요.");
		}
	
	
	}
	
}
}
