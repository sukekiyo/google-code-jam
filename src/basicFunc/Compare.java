package basicFunc;

public class Compare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int result = CompareByBit(a, b);
		String[] set = new String[]{"A < B","A > B","A = B"};
		result +=2 ;
		System.out.println(set[result]);
	}
	
	public static int CompareByBit(int a, int b){
		int tmp1 = a - b;
		int tmp2 = b - a;
		int sign1 =  tmp1 >> (4*8 -1);
		int sign2 =  tmp2 >> (4*8 -1);
		
		return sign2+2*sign1;
		
	}

}
