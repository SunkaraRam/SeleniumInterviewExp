package Practice;

import java.util.List;
import java.util.Set;

public class StringIndia {

	public static void main(String[] args) {
		
		String name = "I Love India";
		
		String[] words = name.split(" ");
		
		String res = "";
		
		int num = words.length;
		
		System.out.println(num);
		
		System.out.println(words[2]);
		
		for (int i = num-1; i >=0 ; i--) {
			
			res = res+(words[i]+" ");
			
			//System.out.println(words[i]);
			
		}
		
		System.out.println(res);
	}

}
