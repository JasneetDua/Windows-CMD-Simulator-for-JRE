import java.io.File;
import java.util.Arrays;


public class FileDirManupulation {

	private String cwd;
	
	public String getCwd() {
		return cwd;
	}

		public void setCwd(String cwd) {
		this.cwd = cwd;
	}

	public FileDirManupulation() {

		setCwd(System.getProperty("user.home"));
		
	}
		
	public FileDirManupulation(String cwd){
		setCwd(cwd);
	}
		
	boolean makeDir(String dir){
		
		File f = new File(cwd,dir);	
		return f.mkdir();
		
	}
	
	boolean makeDir(String wd,String dir){
		
		File f = new File(wd,dir);	
		return f.mkdir();
	}
	
	boolean makeFile(String file){
		try{
		File f = new File(cwd,file);	
		return f.createNewFile();
		}
		catch(Exception e){
			return false;
		}
	}
	
	boolean makeFile(String wd,String file){
		try
		{	
			File f = new File(wd,file);	
			return f.createNewFile();
		}
		
		catch(Exception e){
			
			return false;
		}
	}
	
	boolean changeDir(String dir){
		
		if(dir.equals("..")){
			
			int temp = cwd.lastIndexOf('\\');
			
			setCwd(cwd.substring(0,temp));
			
			if(cwd.endsWith(":")){
				setCwd(cwd+"\\");
				return false;
			}
			else
			{
				return true;
			}
			
		}
		else if(dir.contains(":")&& dir.length()>2){
			
			File f = new File(dir);

			if(f.exists())
			{
				
				setCwd(dir.trim());
				return true;
			
			}
			else
				return false;
		}

		else
		{
			File f = new File(this.cwd,dir);
			if(f.exists())
			{
				
				setCwd(this.cwd +"\\"+ dir);
				return true;
			
			}
			else
				return false;
		}
	}
	
	void Dir(){
		
		File f = new File(cwd);
		String list[] = f.list();
		int count=0;
		for(String item : list )
		{
			System.out.println(item);
			count++;
		}
		System.out.println("\nTotal Files & Dir : "+count);
	}
	
	
	void DisplayCwd(){
		
		System.out.print("\n"+getCwd()+"> ");
		
	}

}
