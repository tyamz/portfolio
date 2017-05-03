package CodingChallenges;

public class URL {
	/**
	 * URLify v2.0
	 * @description Replace spaces with '%20' and remove leading and trailing spaces altogether.
	 * @param text
	 * @return String
	 */
	public static String URLify(String text) {
		int startIndex = 0;
		int endIndex = text.length() - 1;
		
		if(!text.contains(" ")) {
			return text;
		}
		
		// Find starting index (after all leading spaces, if any)
		while(text.charAt(startIndex) == ' ' && startIndex < endIndex) {
			startIndex++;
		}
		
		// Find ending index (before all trailing spaces, if any)
		while(text.charAt(endIndex) == ' ' && endIndex >= startIndex) {
			endIndex--;
		}
		
		StringBuilder urlified = new StringBuilder();
		
		for (int i = startIndex; i < endIndex + 1; i++) {
			if(text.charAt(i) != ' ') {
				urlified.append(text.charAt(i));
			} else {
				urlified.append("%20");
			}
		}
		
		return urlified.toString();
	}
	public static void main(String[] args) {
		String str = "    https://tyamz.com/ thomas_yamakaitis  .pdf    ";
		System.out.print(URLify(str));
	}
}
