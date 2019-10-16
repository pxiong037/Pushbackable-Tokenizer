package Assignment3;
/**
	* @author Prechar Xiong
	* Date: 06/05/19
	* ICS-372-01 Object Oriented Design and Implementation
	* This is an interface that will be implemented by the 
	* PushbackTokenizer class
*/
public interface PushbackableTokenizer {
/**
	* Returns the next token
	* @return the next token
 */
	public String nextToken();
/**
	* Returns true if and only if there are more tokens
	* @return true if there is at least one more token; else false
 */
	public boolean hasMoreTokens();
/**
	* The last token read and is not pushed back
	* is pushed back, so it can be read again using nextToken.
 */
	public void pushback();
}
