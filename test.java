import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Logger;

public class test {

	private static final Logger LOGGER = Logger.getLogger(temp.class.getName());
	public static int b;

	class inner1 extends Thread {

		public void run() {
			try {
				FileInputStream fis = new FileInputStream("/home/masoom/workspace1/MyProj1/abc.txt");
				FileOutputStream fos = new FileOutputStream("/home/masoom/workspace1/MyProj1/test");
				b = fis.read();

				while (b != -1) {
					fos.write(b);
					b = fis.read();
				}
				fis.close();
				fos.close();

			}

			catch (Exception e) {
				LOGGER.info(e.getMessage());
				System.exit(0);
			}
		}

	}

	class inner2 extends Thread {

		public void run() {
			while (test.b != -1) {
				LOGGER.info("*");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		test.inner1 obj_in1 = new test().new inner1();
		test.inner2 obj_in2 = new test().new inner2();

		obj_in1.start();
		obj_in2.start();

	}

}
