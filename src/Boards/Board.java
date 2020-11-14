package Boards;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
public class Board {

	Scanner sc = new Scanner(System.in);
	protected String tools[] = {"◼︎", "⦿", "◎","♥","︎❀"};
	public String board[][];
	protected int tool=0;
	public  String fileName = "빈 파일";
		
	public Board() 
		{
			setBoard();
		}
		
	public void writeFile(String[][] board) {
	       try 
	       {
	    	   	String address = System.getProperty("user.dir");
	            File file = new File(address+"/src/"+fileName+".txt");
	            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	            
		           if(file.isFile() && file.canWrite()) 
		           {
		        	   String line = "";
		        	   line+= "--"+fileName+"--";
			             for(int i = 0; i < board.length; i++) 
			             { 
			            	 for(int j= 0 ; j < board[i].length; j++) 
			            	 {
			            		 line += board[i][j];
			            	 }
			            	 line += "\n";
			             }
			             writer.write(line);
			               writer.close();
		          }
	       }
	       catch (IOException e) 
	       {
	           e.printStackTrace();
	       }
 }
	public void showBoard() 
		{
		System.out.print("  ");
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

	public void showFileName() 
	{
		System.out.println("--"+this.fileName+"--");
	}
		
	public void changeFileName() 
	{
		System.out.println("파일 이름을 입력해주세요.");
		this.fileName =sc.nextLine();
	}	
		
	public void setBoard()
	{				
		board = new String[10][10];
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j<board[i].length; j++) 
			{
				board[i][j]= "  ";
			}
		}
	}
}


