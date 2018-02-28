import java.util.Arrays;
import java.util.Collections;


public class node implements Comparable<node>{
	private int[][] matrix= new int[3][3];
	private node parent;
	private int blank_x, blank_y;
	private int cost;
	private int depth;
	
	public node(node parent, direction d){
		// generating random initial state.
		if(parent==null){
			Integer[] arr = {0,1,2,3,4,5,6,7,8};
			Collections.shuffle(Arrays.asList(arr));
			
			int k=0;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					matrix[i][j]=arr[k];
					if(matrix[i][j]==0){
						blank_x=i;
						blank_y=j;
					}
					k++;
				}
			}
			this.depth=0;
			this.parent=null;
		}
		else{
			this.matrix=utility.swap(parent,d);
			this.parent=parent;
			this.blank_x=utility.getNewX(d,parent.getBlank_x());
			this.blank_y=utility.getNewY(d,parent.getBlank_y());
			this.depth=parent.getDepth()+1;
		}
		
		this.cost=utility.getManhattanDistance(this.matrix)+this.depth;
	}

	public void printNode(){
		System.out.print("\n");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.println("Cost : "+this.cost+" depth: "+this.depth);
		System.out.print("blank tile coordinates: x= "+this.blank_x+" y= "+this.blank_y);
	}

	@Override
	public int compareTo(node n1) {
		// TODO Auto-generated method stub
		if(this.cost<n1.getCost())
			return 1;
		else if(this.cost>n1.getCost())
			return -1;
		else if(this.cost==n1.getCost() && this.depth==n1.getDepth() && this.parent==n1.getParent())
			return 0;
		else
			return -1;
	}
	
	
	
	
	
	// getters and setters
	public int getBlank_x() {
		return blank_x;
	}

	public void setBlank_x(int blank_x) {
		this.blank_x = blank_x;
	}

	public int getBlank_y() {
		return blank_y;
	}

	public void setBlank_y(int blank_y) {
		this.blank_y = blank_y;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public node getParent() {
		return parent;
	}

	public void setParent(node parent) {
		this.parent = parent;
	}
	
	
	
}
