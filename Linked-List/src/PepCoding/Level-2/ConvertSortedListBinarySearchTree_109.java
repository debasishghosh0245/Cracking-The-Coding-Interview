public class ConvertSortedListBinarySearchTree_109 {
    
    public static class LinkedList {
		
        private ListNode head;
        private ListNode tail;
        private int size;

        public void addLast(int data) {
            tail=new ListNode(data);
            if(head==null){
               head=tail;
            }else{
               ListNode current=head;
               while(current.next!=null){
                       current=current.next;
               }
               current.next=tail;
              }
             size++;
        }
		
	
    }
		private static class ListNode {
		   public ListNode next;
		   public int data;
			
		   ListNode(){}
		   
		   ListNode(int data){
			 this.data=data;
		   }
		   
		   ListNode(ListNode next,int data){
			 this.data=data;
			 this.next=next;
		   }  
		}
		
	private static class TreeNode {
		
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		TreeNode(int data,TreeNode left,TreeNode right){
			this.left=left;
			this.right=right;
			this.data=data;
		}

	}
		
        public static void main(String[] args) {
			
            LinkedList list=new LinkedList();
            list.addLast(1);
            list.addLast(3);
			/* list.addLast(0);
			list.addLast(5);
			list.addLast(9); */ 
			display(list.head);
			ListNode head=list.head;
			ListNode tail=head;
			while(tail!=null){
				tail=tail.next;
			}
			TreeNode treeNode=construct(head,tail);
			print(treeNode);
        }  	
	
		public static void display(ListNode head) {
            ListNode curr=head;
            while(curr!=null){
                   System.out.print(curr.data+" ");
                   curr=curr.next;
            }
            System.out.println(" ");
        } 
		
		public static void print(TreeNode root) {
			if (root == null) {
            return;
			}
			String str = "";
			str += root.left == null ? "." : root.left.data + "";
			str += " " + root.data + " ";
			str += root.right == null ? "." : root.right.data + "";
			System.out.println(str);
			print(root.left);
			print(root.right);
		}
		
		public static TreeNode construct(ListNode head,
			ListNode tail){
			if(head==tail) return null; 
			ListNode mid=mid(head,tail);
			TreeNode treeNode=new TreeNode(mid.data,null,null);
			treeNode.left=construct(head,mid);
			treeNode.right=construct(mid.next,tail);
			return treeNode;
		}
		
		public static ListNode mid(ListNode head,ListNode tail) {
			ListNode slow=head;
			ListNode fast=head;
			while(fast!=tail && slow!=tail 
				&& fast.next!=tail){
				slow=slow.next;
				fast=fast.next.next;
			}
			return slow;
		}
} 