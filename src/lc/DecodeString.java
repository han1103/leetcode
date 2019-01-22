package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
	class Code {
		int num;
		String str;
		Code nestedCode;
	}

	String decode(Code code) {
		if (code == null || code.num == 0)
			return "";
		StringBuffer result = new StringBuffer();
		if (code.nestedCode == null) {
			for (int i = 0; i < code.num; i++)
				result.append(code.str);
		} else {
			String decodeNested = decode(code.nestedCode);
			for (int i = 0; i < code.num; i++) {
				result.append(code.str);
				result.append(decodeNested);
			}
		}

		return result.toString();
	}

	public String decodeStringComplex(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;

		List<Code> list = new ArrayList<>();
		int i = 0;
		Code code = new Code();
		list.add(code);
		int indent = 0;
		while (i < s.length()) {
			int startIndex = i;
			char cc = s.charAt(i);
			if (cc >= '0' && cc <= '9') {
				while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					i++;
				}
				code.num = Integer.parseInt(s.substring(startIndex, i));
				i++; // i pointing to [ now
				indent++;
				startIndex = i;
				while ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
					i++;
				}
				code.str = s.substring(startIndex, i);
			} else if ((cc >= 'a' && cc <= 'z') || (cc >= 'A' && cc <= 'Z')) {
				while (i < s.length()
						&& ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))) {
					i++;
				}
				code.str = s.substring(startIndex, i);
				code.num = 1;
			}

			if (i < s.length()) {
				char c = s.charAt(i); // i could be point to a number/]/char

				if (c == ']') {
					do {
						indent--;
						i++;
					} while (i < s.length() && s.charAt(i) == ']');
					if (indent == 0) {
						code = new Code();
						list.add(code);
					} else {
						code.nestedCode = new Code();
						code = code.nestedCode;
					}
				} else if (c >= '0' && c <= '9') {
					code.nestedCode = new Code();
					code = code.nestedCode;
				} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
					code.nestedCode = new Code();
					code = code.nestedCode;
				}
			}
		}

		StringBuffer result = new StringBuffer();

		for (Code codeItem : list) {
			result.append(decode(codeItem));
		}

		return result.toString();
	}

	class StackItem {
		public StackItem(int num, String str) {
			super();
			this.num = num;
			this.str = str;
		}
		int num;
		String str;
	}

	public String decodeStringStack(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;

		StringBuffer result = new StringBuffer();		

		Stack<StackItem> stack = new Stack<>();
		int i=0;
		while(i<s.length()) {
			char c = s.charAt(i);
			if(Character.isLetter(c)) {
				int charStartIndex = i;
				while(i<s.length() && Character.isLetter(s.charAt(i))) {
					i++;
				}
				String str = s.substring(charStartIndex, i);
				if(stack.isEmpty())
					result.append(str);
				else {
					StackItem topItem = stack.peek();
					topItem.str += str;
				}
			}			
			else if(Character.isDigit(c)) {
				int digitStartIndex = i;
				while(Character.isDigit(s.charAt(i))) {
					i++;
				}
				int num = Integer.parseInt(s.substring(digitStartIndex, i));
				StackItem item = new StackItem(num, "");
				stack.push(item);
			}
			else if(c=='[') {
				i++;
			}
			else if(c==']') {
				StackItem item = stack.pop();
				StringBuffer strBuffer = new StringBuffer(item.str);
				for(int j=1; j<item.num; j++) {
					strBuffer.append(item.str);
				}
				if(stack.isEmpty())
					result.append(strBuffer);
				else {
					item = stack.peek();
					item.str += strBuffer;
				}
				i++;
			}			
		}
		
		return result.toString();
	}

	public String decodeStringFast(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;

		StringBuffer result = new StringBuffer();		
		
		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
		int i=0;
		while(i<s.length()) {
			char c = s.charAt(i);
			if(Character.isLetter(c)) {
				int charStartIndex = i;
				while(i<s.length() && Character.isLetter(s.charAt(i))) {
					i++;
				}
				String str = s.substring(charStartIndex, i);
				if(numStack.isEmpty())
					result.append(str);
				else {
					String strTemp = strStack.pop();
					strStack.push(strTemp+str);
				}
			}			
			else if(Character.isDigit(c)) {
				int digitStartIndex = i;
				while(Character.isDigit(s.charAt(i))) {
					i++;
				}
				int num = Integer.parseInt(s.substring(digitStartIndex, i));
				numStack.push(num);
				strStack.push("");
			}
			else if(c=='[') {
				i++;
			}
			else if(c==']') {
				String str = strStack.pop();
				int num = numStack.pop();
				StringBuffer strBuffer = new StringBuffer(str);
				for(int j=1; j<num; j++) {
					strBuffer.append(str);
				}
				if(numStack.isEmpty())
					result.append(strBuffer);
				else {
					str = strStack.pop();
					str += strBuffer;
					strStack.push(str);
				}
				i++;
			}			
		}
		
		return result.toString();
	}
	
	public String decodeString(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;

		boolean hasRepeat = false;
		String result = s;
		do {
			int startRepeatIndex = -1;
			int endRepeatIndex = -1;
			int i=0;
			int numStartIndex=-1;
			int numRepeat=-1;
			hasRepeat = false;
			do {				
				if (result.charAt(i) >= '0' && result.charAt(i) <= '9') {
					numStartIndex = i;
					while (i < result.length() && result.charAt(i) >= '0' && result.charAt(i) <= '9') {
						i++;
					}
					numRepeat = Integer.parseInt(result.substring(numStartIndex, i));	
				}
				char c = result.charAt(i);
				if (c == '[')
					startRepeatIndex = i;
				else if (c == ']') {
					endRepeatIndex = i;
					break;
				}
				i++;
			} while(i<result.length());
			
			if (endRepeatIndex != -1) {				
				hasRepeat = true;
				String newResult = result.substring(0, numStartIndex);
				String repeatString = result.substring(startRepeatIndex+1, endRepeatIndex);
				for(int l=0; l<numRepeat; l++)
					newResult += repeatString;
				if(endRepeatIndex+1<result.length())
					newResult += result.substring(endRepeatIndex+1);
				result = newResult;
			}
		} while (hasRepeat);
		
		return result;
	}

    public String decodeStringWrong(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return s;

		StringBuffer result = new StringBuffer();		
		
		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();
		int i=0;
		while(i<s.length()) {
			char c = s.charAt(i);
			if(Character.isLetter(c)) {
				int charStartIndex = i;
				while(i<s.length() && Character.isLetter(s.charAt(i))) {
					i++;
				}
				String str = s.substring(charStartIndex, i);
				if(numStack.isEmpty())
					result.append(str);
				else
					strStack.push(str);
			}			
			else if(Character.isDigit(c)) {
				int digitStartIndex = i;
				while(Character.isDigit(s.charAt(i))) {
					i++;
				}
				int num = Integer.parseInt(s.substring(digitStartIndex, i));
				numStack.push(num);
			}
			else if(c=='[') {
				i++;
			}
			else if(c==']') {
				String str = strStack.pop();
				int num = numStack.pop();
				StringBuffer strBuffer = new StringBuffer(str);
				for(int j=1; j<num; j++) {
					strBuffer.append(str);
				}
				if(numStack.isEmpty())
					result.append(strBuffer);
				else {
					str = strStack.pop();
					str += strBuffer;
					strStack.push(str);
				}
				i++;
			}			
		}
		
		return result.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print(new DecodeString().decodeStringFast("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
		System.out.print(new DecodeString().decodeStringStack("3[ab2[cd]ef]"));
		//System.out.print(new DecodeString().decodeStringFast("4[2[jk]]"));
		//System.out.print(new DecodeString().decodeStringFast("2[abc]"));
	}

}
