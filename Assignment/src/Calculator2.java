public class Calculator2{
	

	public static void main(String[] args) {
		String text = "1234455352";
		String k = "";
		
		char[] c = text.toCharArray();

		for(int i = 0; i < c.length; i++) {
			if(c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
				switch (c[i]) {
				case '+':
					
					break;
				case '-':
					
					break;
				case '*':
					
					break;
				case '/':
					
					break;
				}
				
			}
			else {
				k += c[i] + "";
			}
		}
		
		
		
//		for(char s : c) {
//			if (s == '+' || s == '-' || s == '*' || s == '/') {
//				// 여기에 나눠지는거 구현
//			}
//			else {
//				k += (s + "");
//				
//				
//				// 여기에 숫자 구현
//			}
//		}
		
	}
}