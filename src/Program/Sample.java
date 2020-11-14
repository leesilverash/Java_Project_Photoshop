package Program;

public class Sample{
private String board[][];

Sample() {
	this.board=new String[10][10];
	Intro();
}

void Intro() {
	System.out.println("-----------------------------------------");
	System.out.println("저희 프로그램을 통해 만들 수 있는 다양한 예시들입니다.");
}

void setSample1(){
	
	for(int i = 0; i < board.length; i++)
	{
		for(int j = 0; j<board[i].length; j++) 
		{
			board[i][j]= "  ";
		}
	}
	board[2][3]=" ♥"; 
	board[2][5]=" ♥";
	board[3][2]=" ♥"; 
	board[3][4]=" ♥"; 
	board[3][6]=" ♥"; 
	board[4][2]=" ♥";
	board[4][6]=" ♥"; 
	board[5][3]=" ♥";
	board[5][5]=" ♥"; 
	board[6][4]=" ♥"; 
}

void setSample2() {
	for(int i = 0; i < board.length; i++)
	{
		for(int j = 0; j<board[i].length; j++) 
		{
			if(i%2!=0 && j%2==0) {
				this.board[i][j]= " ❀";
			}
			else if(i%2==0 && j%2!=0) {
				this.board[i][j]= " ❀";	
			}
			else {
				this.board[i][j]="  ";
			}
		}
	}
}

public void showSample1() 
		{
			setSample1();
			System.out.println();
			System.out.println("  --------HEART--------\n");
			System.out.print("   ");
			for(int i = 0; i < board.length; i++) 
			{
				System.out.print(" "+ i);
				if(i==board.length-1) 
				{
					System.out.println();
				}
			}
			for(int i = 0 ; i < board.length; i++) 
			{
				System.out.print(i+"  ");
				for(int j = 0 ; j < board[i].length; j++) 
				{
					System.out.print(board[i][j]);
				}
				System.out.println();
			}
			
			System.out.println();
		}

public void showSample2() {
	{
		setSample2();
		System.out.println();
		System.out.println("  ------SNOWFLAKES------\n");
		System.out.print("   ");
		for(int i = 0; i < board.length; i++) 
		{
			System.out.print(" "+ i);
			if(i==board.length-1) 
			{
				System.out.println();
			}
		}
		for(int i = 0 ; i < board.length; i++) 
		{
			System.out.print(i+"  ");
			for(int j = 0 ; j < board[i].length; j++) 
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
}

