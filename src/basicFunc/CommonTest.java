package basicFunc;

import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLDocument.Iterator;

public class CommonTest extends Iterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer i = new Integer(5);
		Integer j = null;
		
		System.out.println("Max: "+i.MAX_VALUE);
		System.out.println("Min: "+j.MIN_VALUE);
		
		String str = "HelloWorld";
		
		if (str instanceof Object){
			Object temp = (Object) str;
			System.out.println(temp);
		}
		
		String question = "Really Quit?", response;
		System.out.println(question);
	}

	@Override
	public AttributeSet getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getEndOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStartOffset() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tag getTag() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		
	}

}
