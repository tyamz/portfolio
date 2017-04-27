package CodingChallenges;

/**
 * @author Thomas Yamakaitis
 * @description Just a small coding challenge.
 * @version URL v1.0
 */

public class URL {
	
	/**
	 * @description URLify ~ A small method that makes a string with spaces URL Friendly!
	 * @param str
	 * @param length
	 * @return String
	 */
	
	public static String URLify(String str) {
		int length = str.length();
		str = str.trim();
		int trueL = 0;
		if(str.contains(" ")) {
			char[] oldArr = str.toCharArray();
			char[] newArr = new char[length];
			for(int i = 0; trueL < length; i++) {
				if(i >= oldArr.length) {
					break;
				} else if(oldArr[i] == ' ') {
					newArr[trueL] = '%';
					newArr[trueL+1] = '2';
					newArr[trueL+2] = '0';
					trueL = trueL + 3;
				} else {
					newArr[trueL] = oldArr[i];
					trueL++;
				}
			}
			str = new String(newArr, 0, trueL);
		}
		return str;
	}
	public static void main(String[] args) {
		String str = "   https://tyamz.com/  Mr John Smith    ";
		str = URLify(str);
		System.out.print(str);
	}
}
