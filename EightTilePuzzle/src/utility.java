//import java.awt.List;
import java.util.ArrayList;
import java.util.*;


public class utility {
		
	public static boolean isSafe(direction d,node n)
	{
		int x=getNewX(d,n.getBlank_x());
		int y=getNewY(d,n.getBlank_y());
	    return (x >= 0 && x < 3 && y >= 0 && y < 3);
	}
	
	public static int getNewX(direction d,int x){
		if(d.equals(direction.LEFT)||d.equals(direction.RIGHT)){
			return x;
		}
		else if(d.equals(direction.UP))
			return x-1;
		else if(d.equals(direction.DOWN))
			return x+1;
		return x;
	}
	
	public static int getNewY(direction d,int y){
		if(d.equals(direction.UP)||d.equals(direction.DOWN)){
			return y;
		}
		else if(d.equals(direction.RIGHT))
			return y+1;
		else if(d.equals(direction.LEFT))
			return y-1;
		return y;
	}
	
	
	public static int[][] swap(node n, direction d){
		int newX=getNewX(d,n.getBlank_x());
		int	newY=getNewY(d,n.getBlank_y());
		
		int[][] mat=n.getMatrix();
		int temp=mat[newX][newY];
		mat[newX][newY]=mat[n.getBlank_x()][n.getBlank_y()];
		mat[n.getBlank_x()][n.getBlank_y()]=temp;
		return mat;
	}
	
	public static boolean isGoal(int[][] mat){
		int[][] goal={{1,2,3},{4,5,6},{7,8,0}};
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(mat[i][j]!=goal[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static int getManhattanDistance(int[][] mat){
		int manhattanDistanceSum = 0;
	    for (int x = 0; x < 3; x++) // x-dimension, traversing rows (i)
	        for (int y = 0; y < 3; y++) { // y-dimension, traversing cols (j)
	            int value = mat[x][y]; // tiles array contains board elements
	            if (value != 0) { // we don't compute MD for element 0
	                int targetX = (value - 1) / 3; // expected x-coordinate (row)
	                int targetY = (value - 1) % 3; // expected y-coordinate (col)
	                int dx = x - targetX; // x-distance to expected coordinate
	                int dy = y - targetY; // y-distance to expected coordinate
	                manhattanDistanceSum += Math.abs(dx) + Math.abs(dy); 
	            } 
	        }
	    return manhattanDistanceSum;
	}
	
	public static boolean isSolvable(int[][] root){
		 List<Integer> list = new ArrayList<Integer>();
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) { 
	            // tiny change 2: actually store the values
	            list.add(root[i][j]); 
	        }
	    }
	    int[] vector = new int[list.size()];
	    for (int i = 0; i < vector.length; i++) {
	        vector[i] = list.get(i);
	    }
	    int countinv=0;
		int i,j;
		for(i=0;i<8;i++)
		{
			for(j=i+1;j<9;j++)
			{
				if((vector[i]!=0) && (vector[j]!=0) && (vector[i]>vector[j]))
				{
					countinv=countinv+1;
				}
			}
		}
		if(countinv%2==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	    
	}
}
