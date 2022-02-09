package PepCoding.backtracking;

import java.io.*;
import java.util.*;
public class FloodFill {

    public static void main(String[] args) {
		int[][] arr={{0,0,0},{1,0,1},{0,0,0}};
		boolean [][] visited=new boolean[3][3];
	    printFloodFill(arr,0,0,"",visited);
	}
	
	
	public static void printFloodFill(int[][] maze,int sr, int sc, String ans, boolean[][] visited) { 
		if(sr < 0 || sc < 0 || sr > maze.length-1 || sc > maze[0].length-1
      		|| maze[sr][sc]==1 || visited[sr][sc]==true){
			return;
		}
		if(sc==(maze[0].length-1) && sr==(maze.length-1)) {
			System.out.println(ans);
			return;
		} 
		visited[sr][sc]=true;
		//for top
		printFloodFill(maze,sr-1,sc,ans+'t',visited);
		//for left
		printFloodFill(maze,sr,sc-1,ans+'l',visited);
		//for down
		printFloodFill(maze,sr+1,sc,ans+'d',visited);
		//for right
		printFloodFill(maze,sr,sc+1,ans+'r',visited);
		//when all recursion call finised , 
		//after compliting all calls next line will be executed 
		visited[sr][sc]=false;
	}

}

