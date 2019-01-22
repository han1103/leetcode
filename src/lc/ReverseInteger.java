package lc;

public class ReverseInteger {

	public int reverseFast(int x) {
		long rev = 0;
		while(x!=0) {
			int lastDig = x%10;
			x/=10;
			rev = rev*10+lastDig;
			if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
				return 0;
		}
		
		return (int)rev;
	}
	
	public int reverse(int x) {
		if(x==0)
			return 0;
		boolean positive = true;
		if(x<0)
			positive = false;
		String str = Integer.toString(Math.abs(x));
		
		char[] seq = null;
		int seqIndex = -1;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(str.length()-1-i);			
			if(seq==null) { 
				if(c!='0') {
					seq = new char[str.length()-i];
					seq[++seqIndex] = c;
				}
			}
			else {
				seq[++seqIndex] = c;
			}							
		}
		String revStr = new String(seq);
		
		int revNum;
		
		try {
		 revNum = Integer.parseInt(revStr);
		}
		catch(NumberFormatException e) {
			return 0;			
		}
		
		if(!positive)
			revNum *= -1;
		
		return revNum;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseInteger().reverseFast(123));
	}

}
