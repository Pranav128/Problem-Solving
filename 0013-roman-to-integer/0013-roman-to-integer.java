class Solution {
    public int romanToInt(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans =0 ;
        for(int i=0;i<s.length();i++)
        {
            if(i<s.length()-1 && (map.get(s.charAt(i)) < map.get(s.charAt(i+1)) ))
            {
                ans -= map.get(s.charAt(i));
            }
            else
            {
                ans+= map.get(s.charAt(i));
            }
        }
        return ans ;
        //return roman2Decimal(s);
        
    }

  static String decimal2Roman(int number) {
	   StringBuilder sb = new StringBuilder();
	   int num[] = {1,4,5,9,10,40,50,90,100};
	   String[] Alpha = {"I","IV","V","IX","X","XL","L","XC","C"};
	   
	   for(int i=Alpha.length-1;i>=0 ;i--)
	   {
	       while(number >= num[i])
	       {
	           sb.append(Alpha[i]);
	           number -= num[i];
	       }
	   }
	   return String.valueOf(sb);
	}

	 static int roman2Decimal(String s) {
	 int ans = 0;
	 for(int i=0 ; i<s.length();i++)
        {
            int current = getVal(s.charAt(i));
            
            if(i+1 < s.length())
            {
                int next = getVal(s.charAt(i+1));
                
                if(current < next)
                {
                    ans -= current ;
                }
                else{
                    ans += current ;
                }
            }
            else{
                ans += current  ;
            }
        }
        return ans ;
	}
	 static int getVal(char c)
	{
	    int num = 0 ;
	    switch (c) 
            {
                case 'I': num =1 ;
                    break;
                case 'V': num =5 ;
                    break;
                case 'X': num =10 ;
                    break;
                case 'L': num =50 ;
                    break;
                case 'C': num =100 ;
                    break;
                case 'D': num =500 ;
                    break;
                case 'M': num =1000 ;
                    break;
                default : num = -1 ;
            }
            return num ;
    }

	 static boolean isRomanNumberValid(String romanNumber) {
	    return romanNumber.matches("^(?i)M{0,3}(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
	}
	
	 static boolean isDecimalNumberValid(int decimalNumber) {
		return ( decimalNumber <=100 && decimalNumber>0 ) ;
	}
}