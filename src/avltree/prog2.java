//Name: Jisub Chung
//COMP 282 - T/TH
//Assignment #2
// DATE THIS WAS TURNED IN
//Description: Finished contents of Sudoku Solver

package avltree;

class StringAVLNode {

	private String val;
	private int balance;
	private StringAVLNode left, right;

	// PROF: I believe we have all agreed that one constructor should suffice
	public StringAVLNode(String str) {
		this.balance = 0;
		this.val = str;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int bal) {
		this.balance = bal;
	}

	public String getVal() {
		return val;
	}

	public StringAVLNode getLeft() {
		return left;
	}

	public void setLeft(StringAVLNode pt) {
		this.left = pt;
	}

	public StringAVLNode getRight() {
		return right;
	}

	public void setRight(StringAVLNode pt) {
		this.right = pt;
	}
} // PROF: StringAVLNode

class StringAVLTree {

	private StringAVLNode root;

	// PROF: the one and only constructor
	public StringAVLTree() {

	}

	// PROF: this is here to make it easier for me to write a test
	// PROF: program – you would never do this in real life!
	public StringAVLNode getRoot() {

	}

	// PROF: Rotate the node to the right
	private static StringAVLNode rotateRight(StringAVLNode t) {

	}

	// PROF: Rotate the node to the left
	private static StringAVLNode rotateLeft(StringAVLNode t) {

	}

	// PROF: For these next four, be sure not to use any global variables

	// PROF: Return the height of the tree – not to be used anywhere in insert
	// or delete
	public int height() {

	}

	// PROF: Return the number of leaves in the tree
	public int leafCt() {

	}

	// Return the number of nodes with exactly one non-null child
	public int stickCt() {

	}

	// PROF: Return the inorder successor or null if there is none or num is not
	// PROF: in the tree
	public StringAVLNode successor(String str) {

	}

	// Driver Method for insert
	public void insert(String str) {
		root = insert(str, root);
	}

	private static StringAVLNode insert(String str, StringAVLNode t) {
		if (t == null) { // PROF: easiest case – inserted node goes here
			t = new StringAVLNode(str);
		}
		else if (t.getVal().equals(str)) {} // PROF: already in the tree – do nothing
		else if (str.compareToIgnoreCase(t.getVal()) < 0) { // PROF: str is smaller than this node – go left
			int oldBalance, newBalance;
			// PROF: get the old balance of the left child (where the insertion
			// PROF: is taking place)
			if (t.getLeft() == null) { //THIS IS A SPECIAL CASE
				oldBalance = 0; //??????????????????????? why can we not set this to 0?
								//??????????????????????? afaik this won't cause problems?
				//There are 2 cases where t's left node is null
				//Case 1: t already has a right child
				if (t.getBalance() == 1) {
					//so after the insertion the balance of t will be 0
					t.setBalance(0);
				}
				//Case 2: t is a leaf
				else {
					//so after the insertion the balance of t will be -1
					t.setBalance(-1);
				}
			}
			else {
				oldBalance = t.getLeft().getBalance();
			}
			t.setLeft(insert(str, t.getLeft()));
			newBalance = t.getLeft().getBalance();
			if (oldBalance == 0 && newBalance != 0) { // PROF: did the height increase?
				// PROF: fix the balance value
				t.setBalance(t.getBalance()-1);
				if (t.getBalance() == -2) {// PROF: out of balance – must rotate
					if (t.getLeft().getBalance() == -1){ // PROF: single rotation
						rotateRight(t);
						// PROF: and balance update
						t.setBalance(0);
						t.getLeft().setBalance(0);
					}
					else { 				// PROF: double rotation
						// PROF: and balance update
						boolean leftRightLeftInsertion;
						if (t.getLeft().getRight().getBalance() == -1) {
							leftRightLeftInsertion = true;
						}
						if (leftRightLeftInsertion) {
							t.setBalance(1);
							t.getLeft().setBalance(0);
						}
						else {
							t.setBalance(0);
							t.getLeft().setBalance(-1);	
						}
						t.getLeft().getRight().setBalance(0);
						rotateLeft(t);
						rotateRight(t);
						
						// PROF: once you get it right here, basically the
						// PROF: same code can be used in other places,
						// PROF: including delete
					}					
				}
			}
		}
		
		else { // PROF: str is bigger than this node
		
		}
	
	return t;
	}

	public void delete(String str) {

	}

	private StringAVLNode delete(StringAVLNode t, String str) {

		if (t == null) {
			//PROF: Do nothing if it is not in the tree
		}
		else if (str.compareTo(t.getItem()) == -1) {
			//PROF: get the old balance.
			if (t.getLeft() == null) {
				//PROF: still must deal with this special case in case
				//PROF: the element to be deleted is not in the tree
			}
			else {
				
			}
			
			t.setLeft(delete(t.getLeft(), str));
			
			//PROF: get the new balance
			if (t.getLeft() == null) {
				
			}
			else {
				
			}
			
			if ... { //PROF: did the height decrease?
				 
				//PROF: correct the balance
				if { //PROF: need to rotate?

					//PROF: there are now actually 3 cases because t.getRight.getBalance()
					//PROF: could be -1, 0, or 1.
					if (t.getRight().getBalance() == 1) {
					
					}
					else if ... {
						
					}
					else { //PROF: double rotation case
						
					}	
				}
			}
		}
		
		else if (d.compareTo(t.getItem()) == 1) {
			
		}
		else { //PROF: t is the node to be deleted
			
			if { //PROF: one of the easy cases
				
			}
		
			else if ... { //PROF: the other easy case
				
			}
			
			else {
				
			}
			
			OldBalance = //PROF: get the old balance
					
			t = replace(t, null, t.getLeft()); 	//PROF: find the replacement node and
												//PROF: move it up
			//PROF: get the new balance
			
			//PROF: just like before, see if height decrease and if so
			//PROF: check to see if only need to change balance values or rotate
		}
	}

	// PROF: The code to find and replace the node being deleted must be
	// recursive
	// PROF: so that we have easy access to the nodes that might have balance
	// changes
	private StringAVLNode replace(StringAVLNode t, StringAVLNode prev,
			StringAVLNode replacement) {
		if (replacement.getRight() == null) { // PROF: at the node that will
												// replace
												// PROF: the deleted node
			if (prev != null) { // PROF: if replacement node is NOT the child
								// PROF: ... a special case
			}
			// PROF: move the replacement node – Recall there is no setVal
		} else {

			// PROF: find the old balance

			t = replace(t, replacement, replacement.getLeft());

			// PROF: find the new balance

			// PROF: update balance and rotate if needed
		}
	}

	// PROF: who are you? Put your name here!
	public static String myName() {
		return "Ji-Sub Chung";
	}

} // PROF: end of StringAVLTree class