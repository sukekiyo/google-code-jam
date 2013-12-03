package basicFunc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TicTacToe {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		char[][] game = new char[5][4];
		int caseNum = 0;
		String result = null;
		boolean full = true;
		boolean win = false;
		int TX = -1;
		int TY = -1;
		int lineNum = 1;
		char c = ' ';
		
		//System.out.println(System.getProperty("user.dir"));
		File f = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line;
		try {
			while ((line = br.readLine()) != null) {
			   if(lineNum == 1){
				   caseNum = Integer.parseInt(line);
				   lineNum++;
			   }else{
				   game[(lineNum-2)%5] = line.trim().toCharArray();
				   lineNum++;
				   
				   if ( (lineNum-1)%5 == 0 && (lineNum-1)/5 <= caseNum) {
						
						full = true;
						win = false;
						TX = -1;
						TY = -1;
						result = null;
						c = ' ';
						
/*						
						for(int i=0;i<4;i++){
							for(int j=0;j<4;j++){
								System.out.print(game[i][j]);
							}
							System.out.print("\n");
						}
						System.out.print("=================================\n");*/
						
						outerloop:	
						while(true){
							for(int i=0;i<4;i++){
								for(int j=0;j<4;j++){
									if(game[i][j] == '.'){
										full = false;
									}
									if(game[i][j] == 'T'){
										TX = i;
										TY = j;
									}
								}
							}
							
							for(int i = 0;i<2;i++){
								if(i==0){
									if(TX!=-1 && TY!=-1){
										game[TX][TY] = 'X';
									}
								}else{
									if(TX!=-1 && TY!=-1){
										game[TX][TY] = 'O';
									}
								}
								if(game[0][0]==game[0][1] && game[0][1]==game[0][2] &&game[0][2]==game[0][3] && game[0][3]!='.'){
									win = true;
									c = game[0][3];
								}
								if(game[0][0]==game[1][0] && game[1][0]==game[2][0] &&game[2][0]==game[3][0] && game[3][0]!='.'){
									win = true;
									c = game[3][0];
								}
								if(game[0][0]==game[1][1] && game[1][1]==game[2][2] &&game[2][2]==game[3][3] && game[3][3]!='.'){
									win = true;
									c = game[3][3];
								}
								if(game[0][1]==game[1][1] && game[1][1]==game[2][1] &&game[2][1]==game[3][1] && game[3][1]!='.'){
									win = true;
									c = game[3][1];
								}
								if(game[0][2]==game[1][2] && game[1][2]==game[2][2] &&game[2][2]==game[3][2] && game[3][2]!='.'){
									win = true;
									c = game[3][2];
								}
								if(game[0][3]==game[1][3] && game[1][3]==game[2][3] &&game[2][3]==game[3][3] && game[3][3]!='.'){
									win = true;
									c = game[3][3];
								}
								if(game[0][3]==game[1][2] && game[1][2]==game[2][1] &&game[2][1]==game[3][0] && game[3][0]!='.'){
									win = true;
									c = game[3][0];
								}
								if(game[1][0]==game[1][1] && game[1][1]==game[1][2] &&game[1][2]==game[1][3] && game[1][3]!='.'){
									win = true;
									c = game[1][3];
								}
								if(game[2][0]==game[2][1] && game[2][1]==game[2][2] &&game[2][2]==game[2][3] && game[2][3]!='.'){
									win = true;
									c = game[2][3];
								}
								if(game[3][0]==game[3][1] && game[3][1]==game[3][2] &&game[3][2]==game[3][3] && game[3][3]!='.'){
									win = true;
									c = game[3][3];
								}
									
									
								if (win == true){
									result  = c +" won";
									System.out.println("Case #"+(lineNum-1)/5+": "+result);
									break outerloop;
								}
								
							}
							
							if (full == true){
								result = "Draw";
								System.out.println("Case #"+(lineNum-1)/5+": "+result);
								break outerloop;
							}
							
							result  = "Game has not completed";
							System.out.println("Case #"+(lineNum-1)/5+": "+result);
							break outerloop;
							
						}
				   }
				}

			   }
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
		
}
