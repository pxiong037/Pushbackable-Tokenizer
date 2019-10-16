package Assignment3;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 	* @author Prechar Xiong
	* Date: 06/05/19
	* ICS-372-01 Object Oriented Design and Implementation
	* This PushbackTokenizer class implements the PushbackableTokenizer
	* interface and overrides it's methods to allow a stringTokenizer 
	* and Stack to be used compatibly. By doing this it allows the user
	* to pushback tokens which is not possible in the StringTokenizer
	* class.  
*/
public class PushbackTokenizer implements PushbackableTokenizer {
/**
	* The notReadStack contains the tokens that have been supplied to the
	* client reading the PushbackableTokenizer and have been pushed back 
	* (perhaps multiple times), but have not been read back after the last
	* pushback.
 */
	protected Stack<String> notReadStack = new Stack<String>();
/**
	* The readStack contains the tokens that have been supplied to the client
	* reading the PushbackableTokenizer and were either not pushed back or were
	* pushed back but then reread as many times as the number of pushbacks.
 */
	protected Stack<String> readStack = new Stack<String>();	
/**
 	* The PushbackTokenizer constructor takes in a String and creates a string
 	* tokenizer out of the string passed into the constructor. It then reverses
 	* the string in the string tokenizer to properly store the tokens into the
 	* notReadStack.
 */
	public PushbackTokenizer(String data) {
		StringTokenizer stringTokenizer = new StringTokenizer(data);
		String stringReversed = "";
		while(stringTokenizer.hasMoreTokens()) {
			String s = stringTokenizer.nextToken();
			stringReversed = s + " " + stringReversed;
		}
		
		stringTokenizer = new StringTokenizer(stringReversed);
		
		while(stringTokenizer.hasMoreTokens()) {
			notReadStack.push(stringTokenizer.nextToken());
		}
	}
/**
 	* Overrides the nextToken method from the PushbackableTokenizer interface
 	* that this class implements. The nextToken method pops a token from the 
 	* notReadStack on to the readStack and returns that token if the 
 	* notReadStack is not empty. If the notReadStack is empty then it'll let
 	* the user know that there are not more tokens
 */
	@Override
	public String nextToken() {
		if(notReadStack.isEmpty() == false) {
			String string = notReadStack.pop();
			readStack.add(string);
			return string;
		} else {
			return "The PushbackTokenizer is empty. \n";
		}
	}
/**
 	* Overrides the hasMoreTokens method from the PushbackableTokenizer 
 	* interface that this class implements. The hasMoreTokens method
 	* returns false if the notReadStack is empty and returns true if
 	* the notReadStack is not empty.
 */
	@Override
	public boolean hasMoreTokens() {
		if(notReadStack.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
/**
 	* Overrides the pushback method from the PushbackableTokenizer 
 	* interface that this class implements. The pushback method allows
 	* the user to push tokens from the read stack back on to the 
 	* notReadStack.
 */
	@Override
	public void pushback() {
		notReadStack.push(readStack.pop());
	}

}
