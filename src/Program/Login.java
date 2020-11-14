package Program;
import java.util.Scanner;
public class Login {
	public String nickName;
	private String ID = "";
	private String PW = "";
	Scanner scan = new Scanner(System.in);
	Login(){
	
	}
	private void Access() {
		String userID;
		String userPW;
		while(true) 
		{
			System.out.println("-----------------LogIn-----------------\n");
			System.out.println("ID와 비밀번호를 입력하세요.");
			System.out.print("ID = ");
			userID=scan.next();
			System.out.print("PW = ");
			userPW=scan.next();
			if(userID.equals(ID) && userPW.equals(PW)) 
			{
				System.out.println("<"+nickName+">님 포토샵 프로그램에 오신 것을 진심으로 환영합니다. \n");
				break;
			}
			else 
			{
				System.out.println("입력하신 정보와 일치하는 계정이 존재하지 않습니다.");
			}
		}
	}
	public void SignIn(){
		System.out.println("---------------------------------------\n");
		System.out.println("포토샵 프로그램에 오신 것을 환영합니다.");
		System.out.println("프로그램 사용을 위해 회원가입 페이지 이동합니다.\n");
		setID();	
		setPW();
		setNickName();
		System.out.println("회원가입이 완료되었습니다.");
		System.out.println("로그인 페이지로 이동합니다.\n");
		Access();
	}
	private void setID() {
		String name;
		String[] nameArr;
		while(true)
		{
			System.out.println("-----------------ID생성-----------------\n");
			System.out.println("사용하실 ID를 입력해주세요.(최소 6자 이상)");
			System.out.print("ID : ");	
			name=scan.next();
		
			nameArr = name.split("");
			if(nameArr.length>=6) 
			{
				String check;
				System.out.println("입력하신 ID가 '"+ name +"' 맞습니까? (Y/N)");
				check = scan.next();
					if(check.equals("y") || check.equals("Y")) 
					{
						this.ID = name;
						System.out.println("ID가 설정되었습니다. \n");
						break;
					}
					else if(check.equals("n") || check.equals("N"))
					{
						System.out.println("ID를 다시 입력해주세요.");
					}
					else 
					{
						System.out.println("Y/N으로 입력하셔야 합니다. 첫 화면으로 돌아갑니다.\n");
					}
			}
			else 
			{
				System.out.println("ID의 길이는 6글자 이상이어야 합니다.\n");
			}
		}
	
	}
	private void setPW() {
		String pass1;
		String pass2;
		String[] ArrPw;
		
			System.out.println("-----------------PW설정-----------------\n");		
			System.out.println("비밀번호를 입력해주세요.(최소 6자 이상)");
			while(true) 
			{
				System.out.print("비밀번호 : ");
				pass1 = scan.next();
				ArrPw = pass1.split("");
				if(ArrPw.length >=6) 
				{
					System.out.print("비밀번호 확인 : ");
					pass2 = scan.next();	
					if(pass1.equals(pass2)) 
					{
						this.PW = pass1;
						System.out.println("비밀번호 설정이 완료되었습니다.\n");
						break;
					}
					else 
					{
					System.out.println("비밀번호를 다시 입력해주세요.");
					}
				}
				else 
				{
					System.out.println("비밀번호는 최소 6자 이상이어야 합니다.");
				}
			}
	}
	private void setNickName() {
		String nick;
		String check;
		
		System.out.println("---------------닉네임 설정----------------\n");
		System.out.println("마지막 단계입니다. 사용하실 닉네임을 입력해주세요.");
		while(true) 
		{
			System.out.print("닉네임: ");
			nick = scan.next();
			System.out.println("사용하실 닉네임이 "+ nick+"이 맞습니까? (Y/N)");
			check = scan.next();
				if(check.equals("y") || check.equals("Y")) 
				{
					this.nickName = nick;
					System.out.println("닉네임이 설정되었습니다. \n");
					System.out.println("---------------------------------------\n");
					break;
				}
				else if(check.equals("n") || check.equals("N"))
				{
					System.out.println("사용하실 닉네임을 다시 입력해주세요.");
				}
				else
				{
					System.out.println("Y/N으로 입력해주세요.");
				}	
		}
	}
}
