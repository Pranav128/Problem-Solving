class Solution {
    public boolean isPalindrome(String s) 
    {
    //    String a = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
    //    String b = new StringBuffer(a).reverse().toString();
    //    return a.equals(b);

    int left = 0, right = s.length() - 1;
		char l_ch, r_ch;

		while (left < right) {
			l_ch = s.charAt(left);
			r_ch = s.charAt(right);

			// System.out.println(String.format("%d : %d, %c : %c", left, right, l_ch, r_ch));

			if (!Character.isLetterOrDigit(l_ch))
				left++;
			else if (!Character.isLetterOrDigit(r_ch))
				right--;
			else if (Character.toLowerCase(l_ch) == Character.toLowerCase(r_ch)) {
				left++;
				right--;
			} else
				return false;
		}

		// isPalindrome
		return true;
    }
    
}