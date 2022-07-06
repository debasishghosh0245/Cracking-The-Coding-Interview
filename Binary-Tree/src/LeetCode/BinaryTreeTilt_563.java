public class BinaryTreeTilt_563 {

    static int tilt=0;
    static int tiltsf=0;
    
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair {
        Node node;
        int state;
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
       }
    }
    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
                top.node.left = new Node(arr[idx], null, null);
                Pair lp = new Pair(top.node.left, 1);
            st.push(lp);
            } else {
                top.node.left = null;
            }
            top.state++;
        } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
                top.node.right = new Node(arr[idx], null, null);
                Pair rp = new Pair(top.node.right, 1);
                st.push(rp);
            } else {
                top.node.right = null;
            }
            top.state++;
        } else {
            st.pop();
        }
    }
        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) throws Exception {
        Integer[]arr ={29,16,5,3,null,null,2,null,null,7,null,null,20,8,null,null,12,null,null};
        Node root = construct(arr);
        display(root);
        calculatetilt(root);
        System.out.println("Till So far >> "+tiltsf);
    }
    
    
    public static int calculatetilt(Node root) {
        if(root==null) return 0;
        int sum=0;
        int leftnodesum=calculatetilt(root.left);
        int rightnodesum=calculatetilt(root.right);   
        sum=leftnodesum+rightnodesum+root.data;
        tilt=Math.abs(leftnodesum-rightnodesum);
        tiltsf=tiltsf+tilt;
        return sum; 
    }

}