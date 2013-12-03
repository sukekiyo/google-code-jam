package basicFunc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lawnmower {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */

	public static void main(String[] args) throws FileNotFoundException {
		//long start = System.currentTimeMillis();
		
		int lineNum = 1;
		int caseNum = 0;
		int row = 0;
		int lineCount = 2;
		int[] size = {0,0};
		String[] temp  = null;
		int[][] inputMatrix = null;

		File f = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		try {
			while ((line = br.readLine()) != null) {

				if(lineNum == 1){
					//caseNum = Integer.parseInt(line);
					lineNum++;
				}else if(lineNum == lineCount){
					row = 0;
					temp = line.split(" ");

					for(int i = 0; i < temp.length; i++) {
						size[i] = Integer.parseInt(temp[i]);
					}						
					inputMatrix = new int[size[0]][size[1]];

					caseNum++;
					lineNum++;
					lineCount = lineCount+size[0]+1;

				}else if(lineNum != 1 ){
					temp = line.split(" ");

					for(int i = 0; i < temp.length; i++) {
						inputMatrix[row][i] = Integer.parseInt(temp[i]);
					}
					row++;
					lineNum++;


					if(lineNum == lineCount){

//						//print testing block
//						if(size[0] != 0){
//							System.out.print("==="+size[0]+" * "+size[1]+"===\n");
//							for(int i=0;i<size[0];i++){
//								for(int j=0;j<size[1];j++){
//									System.out.print(inputMatrix[i][j]);
//									System.out.print("*");
//								}
//								System.out.print("\n");
//							}
//							System.out.print("==========================\n");
//						}
//						//print testing block

						String result = null;
						if (isPossible(inputMatrix) == true){
							result = "YES";
						}else{	
							result = "NO";
						}
						System.out.println("Case #"+ caseNum +": " + result);
					}

				}


			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//long end = System.currentTimeMillis();
		//System.out.println(end - start);

	}

	private static boolean isPossible(int[][] inputM) {
		// TODO Auto-generated method stub
		Map<Integer, Boolean> valueSet = new HashMap<Integer, Boolean>();
		
		for(int i=0 ; i < inputM.length; i++){
			 for(int j=0; j<inputM[i].length;j++){
				 if( valueSet.isEmpty() || !valueSet.containsKey(inputM[i][j])){
					 valueSet.put(inputM[i][j], true);
				 }
			 }
		}
		
		if(valueSet.size() == 1){
			return true;
		}
		
		Object[] temp = valueSet.keySet().toArray();		
		Integer[] valueArray = new Integer[temp.length]; 
		for(int i=0 ; i < temp.length; i++){
			valueArray[i] =  (Integer)temp[i];
		}
		Arrays.sort(valueArray);
		
		for(int n=0 ; n < valueArray.length; n++){
			
			boolean allSame = true;
			
//			System.out.println("min height:"+valueArray[n]);
			
			//flip by row
			for(int i=0 ; i < inputM.length; i++){
				allSame = true;
				 for(int j=0; j<inputM[i].length;j++){
					 if(inputM[i][j] != valueArray[n] && inputM[i][j] != -1){
						 allSame = false;
					 }
					 if(j == inputM[i].length-1 && allSame == true){
						 for(int k=0; k<inputM[i].length;k++){
							 inputM[i][k] = -1;
						 }
					 }
				 }
			}
			
//			//print testing block
//					for(int i=0;i<inputM.length;i++){
//						for(int j=0;j<inputM[i].length;j++){
//							System.out.print(inputM[i][j]);
//							System.out.print("*");
//						}
//						System.out.print("\n");
//					}
//					System.out.print("==========================\n");
//			//print testing block	
			
			//flip by column
			for(int i=0 ; i < inputM[0].length; i++){
				allSame = true;
				 for(int j=0; j<inputM.length;j++){
					 if(inputM[j][i] != valueArray[n] && inputM[j][i] != -1 ){
						 allSame = false;
					 }
					 if(j == inputM.length-1 && allSame == true){
						 for(int k=0; k<inputM.length;k++){
							 inputM[k][i] = -1;
						 }
					 }
				 }
			}
			
//			//print testing block
//			for(int i=0;i<inputM.length;i++){
//				for(int j=0;j<inputM[i].length;j++){
//					System.out.print(inputM[i][j]);
//					System.out.print("*");
//				}
//				System.out.print("\n");
//			}
//			System.out.print("==========================\n");
//			//print testing block		
//			
			valueSet.clear();
			for(int i=0 ; i < inputM.length; i++){
				 for(int j=0; j<inputM[i].length;j++){
					 if( valueSet.isEmpty() || !valueSet.containsKey(inputM[i][j])){
						 valueSet.put(inputM[i][j], true);
					 }
				 }
			}
			
			
			if(valueSet.containsKey(valueArray[n])){
				return false;
			}
		}
		
		return true;
	}

}
