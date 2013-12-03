package basicFunc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FairSquare {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File(args[0]);
		Scanner sc = new Scanner(new BufferedReader(new FileReader(f)));
		int caseNum = sc.nextInt();
		
		for(int caseCount = 1;caseCount <= caseNum;caseCount++){
			long left = sc.nextLong();
			long right = sc.nextLong();	
			
//			System.out.println("Left: "+left+" Right:"+right);
//			System.out.println("caseNum: "+caseNum+" caseCount:"+caseCount);
//			System.out.println("------------");
			
			int FairSquare = 0;
			for(long i=left;i<=right;i++){
				if(isFullSqure(i) && isFair(i) && isFair((long) Math.sqrt(i))  ){
					FairSquare++;
				}
			}
			System.out.println("Case #"+caseCount+": "+FairSquare);
		}
		sc.close();
	}

	static boolean isFullSqure(long n){ 
		for(int i=1;n>0;i+=2){
			n-=i; 
		}
		return (0 == n);
	}

	static boolean isFair(long n){
		int div = 1;  
		while (n / div >= 10) {  
			div *= 10;  
		}  
		while (n != 0) {  
			long l = n / div; 
			long r = n % 10; 
			if (l != r){
				return false;  
			}
			n = (n % div) / 10;  
			div /= 100;  
		}  
		return true;
	}

}
