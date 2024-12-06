//Adriana Mavila

public class countSubstring{
	public static int countSub (String Str1, String Str2) {
		int count;
		if (Str1.length() < Str2.length()) { //base case, Str1 can't be less than Str2
			count = 0;
		}
		else if (Str1.substring(0, Str2.length()).equals(Str2)) { 
			count = 1 + countSub(Str1.substring(1), Str2); //move forward or index by 1 for each iteration (n + 1)
		}
		else {
			count = countSub(Str1.substring(1), Str2);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countSub("aabaa", "aa"));
		System.out.println(countSub("abcdef", "xyz"));
		System.out.println(countSub("abababab", "ab"));
		System.out.println(countSub("abcabcabc", "abc"));
		System.out.println(countSub("banana", "na"));
		System.out.println(countSub("thisisjustatest", "test"));
		System.out.println(countSub("ababa", "ab"));
		System.out.println(countSub("aaa", "a"));
		System.out.println(countSub("aaaaa", "aaa"));
	}
}
	
