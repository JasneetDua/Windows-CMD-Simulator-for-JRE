import java.util.Scanner;


public class Manupulation {

	
	public static void main(String[] args) {
		
		String command=null;
		String parameter=null;
		boolean flag =true;
		
		Scanner input = new Scanner(System.in);
		
		FileDirManupulation o = new FileDirManupulation(System.getProperty("user.home"));
		
		while(flag)
		{
			
			o.DisplayCwd();
			String s = input.nextLine();
			
			if(s.trim().contains(" "))
			{
				command = s.trim().substring(0, s.indexOf(' ')).toLowerCase();
				parameter = s.substring(s.indexOf(' ')).toLowerCase().trim();
			}
			else
			{
					command = s.trim().toLowerCase();
			}
		
			switch(command)
			{
			
				case "dir" : o.Dir(); break;
				case "cd"  : 
					
					o.changeDir(parameter);
				
				case "exit" : flag = false; break;
				
				default : System.out.println("Invalid Command.... Please try Again");break;
				
			}
		}
		
		input.close();
	}
}
