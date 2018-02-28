
public class IDS {
	
	private node root;
	private node found;
	private static int expanded_nodes=1;
	public IDS(){
		root=new node(null,null);
		System.out.println("The initial state was: ");
		root.printNode();
		expanded_nodes++;
	}
	
	public void run_IDS(){
		//if(utility.isSolvable(root.getMatrix())){
			for(int depth=0;depth<100000;depth++){
				found=DLS(root,depth);
				if(found!=null){
					foundGoal(found);
					break;
				}
			}
		//}
		//else 
			//System.out.println("Initial state is not solvable");
		
	}
	
	public node DLS(node n, int depth){
		if(n.getDepth()<=2)
			n.printNode();
		expanded_nodes++;
		if(depth==0){
			if(utility.isGoal(n.getMatrix())){    // if node is a goal state
				return n;
			}
			else 
				return null;
		}
		else if(depth>0){
			if(utility.isSafe(direction.UP, n)){
				node child1=new node(n,direction.UP);
				found=DLS(child1,depth-1);
				if(found!=null)
					return found;
			}
			
			if(utility.isSafe(direction.DOWN, n)){
				node child2=new node(n,direction.DOWN);
				found=DLS(child2,depth-1);
				if(found!=null)
					return found;
			}
			
			if(utility.isSafe(direction.LEFT, n)){
				node child3=new node(n,direction.LEFT);
				found=DLS(child3,depth-1);
				if(found!=null)
					return found;
			}
			
			if(utility.isSafe(direction.RIGHT, n)){
				node child4=new node(n,direction.RIGHT);
				found=DLS(child4,depth-1);
				if(found!=null)
					return found;	
			}
			
		}
		return null;
	}
	
	public void foundGoal(node n){
		System.out.println("\nFound goal node at depth "+n.getDepth());
		System.out.println("Goal node is: ");
		n.printNode();
		System.out.println("\n Total number of expanded nodes: "+expanded_nodes);
	}
}


