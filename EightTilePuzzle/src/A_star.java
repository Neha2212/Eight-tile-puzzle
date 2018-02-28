import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;


public class A_star {

	private node root;
	private node found;
	PriorityQueue<node> fringeList = new PriorityQueue<node>(new Comparator<node>() {  
	    
        public int compare(node w1, node w2) {                         
            if ((w1.getCost())<((w2.getCost())))
            	return -1;
            else if((w1.getCost())>((w2.getCost())))
            	return 1;
            else
            	return 0;
        }      
    });
	//HashMap<int[][],node> extendedList = new HashMap<int[][],node>();
	
	public A_star(){
		root=new node(null,null);
		System.out.println("The initial state was: ");
		root.printNode();
		fringeList.add(root);
	}
	
	public void run_A_star(){	
		if(utility.isSolvable(root.getMatrix())){
			found=A_star_util();
			if(found!=null){
				foundGoal(found);
			}
		}
		else
			System.out.println("Initial state is not solvable");
	}
	
	public node A_star_util(){
		//n.printNode();
		while(!fringeList.isEmpty()){
			
		node n=fringeList.poll();
		if(n==null)
			return n;
		//node temp;
		if(utility.isGoal(n.getMatrix())){    // if node is a goal state
			return n;
		}
		//n.printNode();
		
		if(utility.isSafe(direction.UP, n)){
			node child1=new node(n,direction.UP);
			fringeList.add(child1);
//			if(this.extendedList.containsKey(child1.getMatrix())){
//				temp=extendedList.get(child1.getMatrix());
//				if(temp.getCost()>child1.getCost() && fringeList.contains(temp)){
//					fringeList.remove(temp);
//					fringeList.add(child1);
//				}
//			}
//			else{
//				extendedList.put(child1.getMatrix(), child1);
//				fringeList.add(child1);
//			}
		}
		
		if(utility.isSafe(direction.DOWN, n)){
			node child2=new node(n,direction.DOWN);
			fringeList.add(child2);
//			if(this.extendedList.containsKey(child2.getMatrix())){
//				temp=extendedList.get(child2.getMatrix());
//				if(temp.getCost()>child2.getCost() && fringeList.contains(temp)){
//					fringeList.remove(temp);
//					fringeList.add(child2);
//				}
//			}
//			else{
//				extendedList.put(child2.getMatrix(), child2);
//				fringeList.add(child2);
//			}
		}
		
		if(utility.isSafe(direction.LEFT, n)){
			node child3=new node(n,direction.LEFT);
			fringeList.add(child3);
//			if(this.extendedList.containsKey(child3.getMatrix())){
//				temp=extendedList.get(child3.getMatrix());
//				if(temp.getCost()>child3.getCost() && fringeList.contains(temp)){
//					fringeList.remove(temp);
//					fringeList.add(child3);
//				}
//			}
//			else{
//				extendedList.put(child3.getMatrix(), child3);
//				fringeList.add(child3);
//			}
		}
		
		if(utility.isSafe(direction.RIGHT, n)){
			node child4=new node(n,direction.RIGHT);
			fringeList.add(child4);
//			if(this.extendedList.containsKey(child4.getMatrix())){
//				temp=extendedList.get(child4.getMatrix());
//				if(temp.getCost()>child4.getCost() && fringeList.contains(temp)){
//					fringeList.remove(temp);
//					fringeList.add(child4);
//				}
//			}
//			else{
//				extendedList.put(child4.getMatrix(), child4);
//				fringeList.add(child4);
//			}	
		}
		}
		return null;
		//return A_star_util(fringeList.pollLast());
	}
	
	public void foundGoal(node n){
		System.out.println("\nFound goal node at depth "+n.getDepth());
		System.out.println("Goal node is: ");
		n.printNode();
		
	}


}
