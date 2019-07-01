import java.io.FileInputStream;
import java.io.FileOutputStream;

class A1 extends Thread
{
	public static int b;
	public void run(){
	try{
		FileInputStream fis = new FileInputStream("/home/masoom/workspace1/MyProj1/abc.txt");
		FileOutputStream fos = new FileOutputStream("/home/masoom/workspace1/MyProj1/test");
		b = fis.read();
		
		while(b != -1){
			fos.write(b);				
			b = fis.read();
		}
		fis.close();
		fos.close();
		
	}
	
	catch (Exception e) {
		System.out.println(e.getMessage());
		System.exit(0);
	}
	}
}


class A2 extends Thread
{
	public void run(){
			while(A1.b != -1){
			System.out.println("*");
			
			try {Thread.sleep(1000);} 
			catch(InterruptedException e) {e.printStackTrace();}
		}		
	}
	public static void main(String[] args) {
		A1 obj1 = new A1();
		A2 obj2 = new A2();
		
		obj1.start();
		obj2.start();
	}
		
}

