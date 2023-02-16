import java.util.*;

public class WaterJugs  {
    static int count =0;
    public WaterJugs( ) {
    }

    public static ArrayList<Node> DepthFirstSearch(State S0, State goal) {
        Node n = new Node(S0,null);
        Stack<Node>open = new Stack<Node>();
        open.add(n);
        ArrayList<State>visited = new ArrayList<>();
        while (!open.isEmpty()) {
            State nState= n.getState();
            if ( nState.getX()== goal.getX() && nState.getY()==goal.getY()) {
                System.out.println("this is the number of nodes created in depth first search :"+  count);
                System.out.println("this is the depth first path");
                return goalPathFinder(n);
            }else{
                visited.add(n.getState());
            }
            n=open.pop();
            for (int i = n.expand().size()-1; i >0; i--) {
                Node m = n.expand().get(i);
                if(visited.contains(m.getState())){
                    continue;
                }else{
                    count ++;
                    open.add(m);

                }

            }
        }

        return null;
    }
    public static ArrayList<Node>BreadthFirstSearch(State S0, State  goal) {
        Node n = new Node(S0,null);
        Queue<Node>open = new LinkedList<Node>();
        open.add(n);
        ArrayList<State>visited = new ArrayList<>();
        while (!open.isEmpty()) {
            State nState= n.getState();
            if ( nState.getX()== goal.getX() && nState.getY()==goal.getY()) {
                System.out.println("this is the number of nodes created in breadth first search " + count);
                System.out.println("this is the breadth first path :");
                return goalPathFinder(n);
            }else{
                visited.add(n.getState());
            }
            n=open.remove();
            for (int i = 0; i <n.expand().size(); i++) {
                Node m = n.expand().get(i);
                if(visited.contains(m.getState())){
                    continue;
                }else{
                }
                open.add(m);
                count++;



            }
        }

        return null;

    }
    public static ArrayList<Node> goalPathFinder(Node node){
        ArrayList<Node>nodesFromGoal= new ArrayList<Node>();
        nodesFromGoal.add(node);
        while(node.getParent()!=null){
            nodesFromGoal.add(node.getParent());
            node=node.getParent();
        }
        return reverseArrayList(nodesFromGoal);
    }
    public static ArrayList<Node> reverseArrayList(ArrayList<Node>list){
        ArrayList<Node>reversedList = new ArrayList<Node>();
        for(int i = list.size()-1;i>=0;i--){
            reversedList.add(list.get(i));
        }
        return reversedList;
    }


    public static void main(String args[]){
        // start state
        State start = new State(0,0);
        //goal state
        State goal = new State(2,3);
        State start2 = new State(0,0);
        //goal state 2
        State goal2 = new State(2,0);
        //Depth First
        //the path for breadthfirst and its node count
        System.out.println(BreadthFirstSearch(start,goal));
        //the path for depth first and its node count
        System.out.println(DepthFirstSearch(start2,goal2));


    }
}
