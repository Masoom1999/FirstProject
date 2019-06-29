import java.io.FileInputStream;
import java.io.FileOutputStream;

class C1 extends Thread
{
	public void run(){
	try{
		FileInputStream fis = new FileInputStream("/home/masoom/workspace1/MyProj1/abc.txt");
		FileOutputStream fos = new FileOutputStream("/home/masoom/workspace1/MyProj1/test");
	    int b = fis.read();
		
		while(b != -1){
			fos.write(b);				
			b = fis.read();
		}
		b=0;
		fis.close();
		fos.close();
		//System.out.println("Okay Byee!!");
	}
	
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
}


class C2 extends Thread
{
	public void run(){
		for(int i=0; i<10 ; i++){
			System.out.println("*");
			try {Thread.sleep(1000);} 
			catch(InterruptedException e) {e.printStackTrace();}
		}		
	}
		
}
public class FinalProg1 {

	public static void main(String[] args) {
		C1 obj1 = new C1();
		C2 obj2 = new C2();
		
		obj1.start();
		obj2.start();			

	}
}





