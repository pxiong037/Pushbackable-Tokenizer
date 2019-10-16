package Assignment3;
/**
	* @author Prechar Xiong
	* Date: 06/05/19
	* ICS-372-01 Object Oriented Design and Implementation
	* This driver class creates an instance of the PushbackTokenizer
	* and tests out the methods implemented in the PushbackTokenizer
	* class.
*/
public class driver {
	public static void main(String[]args) {
		PushbackableTokenizer pushbackTokenizer = new PushbackTokenizer("Hello this is a test");
		
		while(pushbackTokenizer.hasMoreTokens()) {
			System.out.println(pushbackTokenizer.nextToken());
		}
		
		pushbackTokenizer.pushback();
		pushbackTokenizer.pushback();
		
		while(pushbackTokenizer.hasMoreTokens()) {
			System.out.println(pushbackTokenizer.nextToken());
		}
		
		System.out.println(pushbackTokenizer.nextToken());
	}
}
