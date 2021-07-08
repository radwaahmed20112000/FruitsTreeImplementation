import java.util.LinkedList;

public class Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] graph = new Node[numCourses];
        for(int i = 0 ; i < numCourses;i++){
            graph[i] = new Node(i);
        }
        for(int i = 0 ;i < prerequisites.length ;i++){
            graph[prerequisites[i][0]].addEdge(graph[prerequisites[i][1]]);
        }
        for(Node node : graph){
            if(!node.isVisited()) {
                boolean detect = false;
                if(cycleDetection(node,detect)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean cycleDetection(Node node,boolean detection){
        if(node == null)
            return false;
        node.setVisited(true);
        for(Node n : node.getEdges()){
            if(n.isVisited())
                return true;
            detection = cycleDetection(n,detection);
        }
        node.setVisited(false);
        return detection;
    }
    public static class Node{
        private int id;
        private boolean visited;
        private LinkedList<Node> edges;
        public Node(int id){
            this.id = id;
            edges = new LinkedList<>();
        }
        public void addEdge(Node edge){
            edges.add(edge);
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public LinkedList<Node> getEdges() {
            return edges;
        }

        public boolean isVisited() {
            return visited;
        }
    }
/*20
[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]*/
    public static void main(String[] args) {
        int[][] p = {{1,4},{2,4},{3,1},{3,2}};
        int n = 5;
        System.out.println(canFinish(n,p));
    }
}
