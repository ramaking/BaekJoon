package test;


import java.util.Scanner;
import java.io.FileInputStream;

public class Solution
{
    
    public static int[][] sudoku = new int[9][9];
    public static boolean validCheck(int y, int x){
        for(int i = 0; i < 9; i++){
            if(i == y)
                continue;
           if(sudoku[y][x] == sudoku[i][x]){
           		return false;
           }   
        }
        
         for(int i = 0; i < 9; i++){
            if(i == x)
                continue;
           if(sudoku[y][x] == sudoku[y][i]){
           		return false;
           }   
        }
        int blockX = x/3;
        int blockY = y/3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if((i + blockX*3) == x && (j + blockY*3) == y)
                    continue;
                if(sudoku[j + blockY*3][(i + blockX*3)] == sudoku[y][x])
                    return false;
            }
            /*
            if(i == x)
                continue;
           if(sudoku[y][x] == sudoku[y][i]){
           		return false;
           }   
           */
        }
        
        return true;
    }
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			for(int i = 0; i < 9; i++){
             	for(int j = 0; j < 9; j++){
                    sudoku[i][j] = sc.nextInt();
                }
            }
            boolean pro = true;
            for(int i = 0; i < 9; i++){
             	for(int j = 0; j < 9; j++){
                    if(validCheck(i,j)){
                        
                    } else {
                        pro = false;
                    	break;
                    }
                }
                if(!pro){
                    break;
                }
            }
            if(pro){
                System.out.println("#" + test_case + " 1");
            } else {
             	System.out.println("#" + test_case + " 0");   
            }
		}
	}
}