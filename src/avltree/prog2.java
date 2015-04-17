//Name: Jisub Chung
//COMP 282 - T/TH
//Assignment #2
// 3/11/2015
//Description: String AVL Tree



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

	public StringAVLNode root;

	// PROF: the one and only constructor
	public StringAVLTree() {
		
	}

	// PROF: this is here to make it easier for me to write a test
	// PROF: program – you would never do this in real life!
	public StringAVLNode getRoot() {
		return root;
	}

	// PROF: Rotate the node to the right
	private static StringAVLNode rotateRight(StringAVLNode t) {
		StringAVLNode replacementNode;
		replacementNode = t.getLeft();
		t.setLeft(replacementNode.getRight());
		replacementNode.setRight(t);
		return replacementNode;
	}

	// PROF: Rotate the node to the left
	private static StringAVLNode rotateLeft(StringAVLNode t) {
		StringAVLNode replacementNode;
		replacementNode = t.getRight();
		t.setRight(replacementNode.getLeft());
		replacementNode.setLeft(t);
		return replacementNode;
	}

	// PROF: For these next four, be sure not to use any global variables

	// PROF: Return the height of the tree – not to be used anywhere in insert
	// or delete
	public int height() {
		return height(root);
	}
	
	private static int height(StringAVLNode t) {
		int height = 0;
		int left = 0;
		int right = 0;
		int greater = 0;
		if (t==null) {
			height = 0; 
		}
		else {
			if (t.getLeft() != null) {
				left = height(t.getLeft());
			}
			if (t.getRight() != null) {
				right = height(t.getRight());
			}
			if (right > left) {
				greater = right;
			}
			else {
				greater = left;
			}
			height = 1 + greater;
		}
		return height;
	}

	// PROF: Return the number of leaves in the tree
	public int leafCt() {
		return leafCt(root);
	}
	
	private static int leafCt(StringAVLNode t) {
		int count = 0;
		if (t == null) {
			count = 0;
		}
		else if (t.getLeft() == null && t.getRight() == null) { //if t is a leaf
			count++;
		}
		else if (t.getLeft() == null) { //if t has only a right child
			count+=leafCt(t.getRight());
		}
		else if (t.getRight() == null) { //if t has only a left child
			count+=leafCt(t.getLeft());
		}
		else { //if t has both a left and right child
			count+=leafCt(t.getRight());
			count+=leafCt(t.getLeft());
		}
		return (count);
	}

	// PROF: Return the number of perfectly balanced AVL nodes
	public int balanced() {
		return balanced(root);
	}
	
	private static int balanced(StringAVLNode t) {
		int count = 0;
		if (t == null) {
			count = 0;
		}
		else {
			if(t.getLeft() == null) {
			}
			else {
				count+=balanced(t.getLeft());
			}
			
			if(t.getRight() == null) {
			}
			else {
				count+=balanced(t.getRight());
			}
			if(t.getBalance() == 0) {
				count++;
			}	
		}
		return (count);
	}

	// PROF: Return the inorder successor or null if there is none or str is not in the tree
	public String successor(String str) {
		boolean keepGoing = true;
		StringAVLNode holder;
		holder = root;
		String successor = null;
		while(keepGoing) {
			if (str.compareToIgnoreCase(holder.getVal()) < 0) { //if str is smaller than t's string, go left
				holder = holder.getLeft();
			}
			else if (str.compareToIgnoreCase(holder.getVal()) > 0) { //if str is larger than t's string, go right
				holder = holder.getRight();
			}
			if (str.compareToIgnoreCase(holder.getVal()) == 0) {
				keepGoing = false;
			}
		}
		if (holder.getRight() == null) {
		}
		else {
			while (holder.getLeft() != null) {
				holder = holder.getLeft();
			}
			successor = holder.getVal();
		}
		return successor;
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
				oldBalance = 99;
			}
			else {
				oldBalance = t.getLeft().getBalance();
			}
			t.setLeft(insert(str, t.getLeft()));
			newBalance = t.getLeft().getBalance();
			if ((oldBalance == 0 && newBalance != 0) || oldBalance == 99) { // PROF: did the height increase?
				// PROF: fix the balance value
				t.setBalance(t.getBalance()-1);
				if (t.getBalance() == -2) {// PROF: out of balance – must rotate
					if (t.getLeft().getBalance() == -1){ // PROF: single rotation
						t=rotateRight(t);
						// PROF: and balance update
						t.setBalance(0);
						t.getRight().setBalance(0);
					}
					else {// PROF: double rotation
						// PROF: and balance update
						if (t.getLeft().getRight().getBalance() == -1) {
							t.setBalance(1);
							t.getLeft().setBalance(0); //must
						}
						else if (t.getLeft().getRight().getBalance() == 1) {
							t.setBalance(0);
							t.getLeft().setBalance(-1); //must, maybe 0 000000000000000000000000000000000000000000
						}
						else {
							t.setBalance(0);
							t.getLeft().setBalance(0);
						}
						t.getLeft().getRight().setBalance(0);
						t.setLeft(rotateLeft(t.getLeft()));
						t=rotateRight(t);
						
						// PROF: once you get it right here, basically the
						// PROF: same code can be used in other places,
						// PROF: including delete
					}					
				}
			}
		}
		else { // PROF: str is bigger than this node
			   // go Right
			int oldBalance, newBalance;
			// PROF: get the old balance of the right child (where the insertion
			// PROF: is taking place)
			if (t.getRight() == null) { //THIS IS A SPECIAL CASE
				oldBalance = 99; 
			}
			else {
				oldBalance = t.getRight().getBalance();
			}
			t.setRight(insert(str, t.getRight()));
			newBalance = t.getRight().getBalance();
			if ((oldBalance == 0 && newBalance != 0) || oldBalance == 99) { // PROF: did the height increase?
				// PROF: fix the balance value
				t.setBalance(t.getBalance()+1);
				if (t.getBalance() == 2) {// PROF: out of balance – must rotate
					if (t.getRight().getBalance() == 1){ // PROF: single rotation
						t=rotateLeft(t);
						// PROF: and balance update
						t.setBalance(0);
						t.getLeft().setBalance(0);
					}
					else { 	// PROF: double rotation
							// PROF: and balance update
						if (t.getRight().getLeft().getBalance() == 1) {
							t.setBalance(-1);
							t.getRight().setBalance(0);
						}
						else if (t.getRight().getLeft().getBalance() == -1) {
							t.setBalance(0);
							t.getRight().setBalance(1);	
						}
						else {
							t.setBalance(0);
							t.getRight().setBalance(0);
						}
						t.getRight().getLeft().setBalance(0);
						t.setRight(rotateRight(t.getRight()));
						t=rotateLeft(t);
						// PROF: once you get it right here, basically the
						// PROF: same code can be used in other places,
						// PROF: including delete
					}					
				}
			}
		}
	return t;
	}

	public void delete(String str) {
		root = delete(root, str);
	}

	private StringAVLNode delete(StringAVLNode t, String str) {
		if (t == null) {
			//PROF: Do nothing if it is not in the tree
		}
		else if (str.compareToIgnoreCase(t.getVal()) < 0) { //go to the left
			int oldBalance, newBalance;
			//PROF: get the old balance.
			if (t.getLeft() == null) {
				//PROF: still must deal with this special case in case
				//PROF: the element to be deleted is not in the tree
				oldBalance = 999; 
			}
			else {
				oldBalance = t.getLeft().getBalance();
				t.setLeft(delete(t.getLeft(), str));				
			}
			//PROF: get the new balance
			if (t.getLeft() == null) {
				oldBalance = -1;
				newBalance = 0;
			}
			else {
				newBalance = t.getLeft().getBalance();
			}
			
			if ((oldBalance !=  0 && newBalance == 0) || oldBalance == 999) { //PROF: did the height decrease?
				//PROF: correct the balance
				t.setBalance(t.getBalance()+1);
				if (t.getBalance() == 2){ //PROF: need to rotate?
					//PROF: there are now actually 3 cases because t.getRight.getBalance()
					//PROF: could be -1, 0, or 1.
					if (t.getRight().getBalance() == 1) {
						t=rotateLeft(t);
						t.setBalance(0);
						t.getLeft().setBalance(0);
					}
					else if (t.getRight().getBalance() == 0) {
						t=rotateLeft(t);
						t.getLeft().setBalance(1);
					}
					else { //PROF: double rotation case
						t.setRight(rotateRight(t.getRight()));
						t=rotateLeft(t);
						t.getLeft().setBalance(0);
						t.getRight().setBalance(0);
					}	
				}
			}
		}
		
		else if (str.compareTo(t.getVal()) > 0)  { //go to the right
			int oldBalance, newBalance;
			//PROF: get the old balance.
			if (t.getRight() == null) {
				//PROF: still must deal with this special case in case
				//PROF: the element to be deleted is not in the tree
				oldBalance = 999;
			}
			else {
				oldBalance = t.getRight().getBalance();
				t.setRight(delete(t.getRight(), str));				
			}
			//PROF: get the new balance
			if (t.getRight() == null) {
				oldBalance = 1;
				newBalance = 0;
			}
			else {
				newBalance = t.getRight().getBalance();
			}
			
			if ((oldBalance !=  0 && newBalance == 0) || oldBalance == 999) { //PROF: did the height decrease?
				//PROF: correct the balance
				t.setBalance(t.getBalance()-1);
				if (t.getBalance() == -2){ //PROF: need to rotate?
					//PROF: there are now actually 3 cases because t.getRight.getBalance()
					//PROF: could be -1, 0, or 1.
					if (t.getLeft().getBalance() == -1) {
						t=rotateRight(t);
						t.setBalance(0);
						t.getRight().setBalance(0);
					}
					else if (t.getLeft().getBalance() == 0) {
						t=rotateRight(t);
						t.getRight().setBalance(1);
					}
					else { //PROF: double rotation case
						t.setLeft(rotateLeft(t.getLeft()));
						t=rotateRight(t);
						t.getRight().setBalance(0);
						t.getLeft().setBalance(0);
					}	
				}
			}
		}
		else { //PROF: t is the node to be deleted
			//deleting a leaf
			if (t.getLeft() == null && t.getRight() == null) { //PROF: one of the easy cases
				t=null;
			}
			//deleting a stick
			else if ((t.getLeft() == null && t.getRight() != null) || 
					t.getRight() == null && t.getLeft() != null) { //PROF: the other easy case
				if (t.getLeft() == null) {
					t = t.getRight();
				}
				else {
					t = t.getLeft();
				}
			}
			else {
				int oldBalance, newBalance;
				//PROF: get the old balance
				oldBalance = t.getRight().getBalance();
				t = replace(t, null, t.getRight()); 	//PROF: find the replacement node and
														//PROF: move it up
				//PROF: get the new balance 
				if (t.getRight() == null) {
					oldBalance = 1;
					newBalance = 0;
				}
				else {
					newBalance = t.getRight().getBalance();
				}
				if (oldBalance != 0 && newBalance == 0) {
					t.setBalance(t.getBalance()-1);
					if (t.getBalance() == -2) {// PROF: out of balance – must rotate
						if (t.getLeft().getBalance() == -1){ // PROF: single rotation
							t=rotateRight(t);
							// PROF: and balance update
							t.setBalance(0);
							t.getRight().setBalance(0);
						}
						else { 				// PROF: double rotation
							// PROF: and balance update
							if (t.getLeft().getRight().getBalance() == -1) {
								t.setBalance(1);
								t.getLeft().setBalance(0);
							}
							else {
								t.setBalance(0);
								t.getLeft().setBalance(-1);	
							}
							t.getLeft().getRight().setBalance(0);
							t.setRight(rotateRight(t.getRight()));
							t=rotateLeft(t);
							
							// PROF: once you get it right here, basically the
							// PROF: same code can be used in other places,
							// PROF: including delete
						}					
					}
				}
			//PROF: just like before, see if height decrease and if so
			//PROF: check to see if only need to change balance values or rotate
			}
		}
		return t;
	}

	// PROF: The code to find and replace the node being deleted must be recursive
	// PROF: so that we have easy access to the nodes that might have balance changes
	private static StringAVLNode replace(StringAVLNode t, StringAVLNode prev, StringAVLNode replacement) {
		if (replacement.getLeft() == null) { // PROF: at the node that will replace the deleted node
			if (prev != null) { // PROF: if replacement node is NOT the child
								// PROF: ... a special case
				// PROF: move the replacement node – Recall there is no setVal
				prev.setLeft(replacement.getRight());
				replacement.setLeft(t.getLeft());
				replacement.setRight(t.getRight());
				replacement.setBalance(t.getBalance());
				t = replacement;
				//prev.setBalance(prev.getBalance()+1);
			}
			else {
				replacement.setLeft(t.getLeft());
				t=replacement;
			}
		} 
		else {
			int oldBalance, newBalance;
			// PROF: find the old balance
			oldBalance = replacement.getLeft().getBalance();
			t = replace(t, replacement, replacement.getLeft());
			// PROF: find the new balance
			if( replacement.getLeft() != null) {
				newBalance = replacement.getLeft().getBalance(); //check for case of rep.left being moved
			}
			else {
				oldBalance = 1; //for the case when the next one to the left is replaced
				newBalance = 0;
			}
			// PROF: update balance and rotate if needed
			if (oldBalance != 0 && newBalance == 0) { //height change detected
				replacement.setBalance(replacement.getBalance()+1);
				if (replacement.getBalance() == 2) { //need to rotate
					if (replacement.getRight().getBalance() == 1) { //single case 1
						replacement=rotateLeft(replacement);
						replacement.setBalance(0);
						replacement.getLeft().setBalance(0);
					}
					else if (replacement.getRight().getBalance() == 0) {//single case 2
						replacement=rotateLeft(replacement);
						replacement.setBalance(replacement.getBalance()-1);
						replacement.getLeft().setBalance(1);
					}
					else {//double rotate
						if (replacement.getLeft() != null) {
							replacement.setBalance(-1);
						}
						else {
							replacement.setBalance(0);
						}
						replacement.setRight(rotateRight(replacement.getRight()));
						replacement=rotateLeft(replacement);
						replacement.setBalance(0);
						replacement.getRight().setBalance(0);
					}
				}
			}
		}
		return t;
	}

	// PROF: who are you? Put your name here!
	public static String myName() {
		return "Ji-Sub Chung";
	}

} // PROF: end of StringAVLTree class