import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScheduleTopologicalSort{
    /*L <- Empty list that will contain the sorted elements
S <- Set of all nodes with no incoming edges (indegree=0)
while S is non-empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S
if graph has edges then
    return error (graph has at least one cycle)
else
    return L (a topologically sorted order)
    */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] graph = new Node[numCourses];
        for(int i = 0 ; i < numCourses;i++){
            graph[i] = new Node();
        }
        for(int i = 0 ;i < prerequisites.length ;i++){
            graph[prerequisites[i][0]].addEdge(graph[prerequisites[i][1]]);
            graph[prerequisites[i][1]].indegreeIncrement();
        }
        List<Node> sorted = new ArrayList<>();
        List<Node> indegreeZero = new ArrayList<>();
        for(int i = 0 ;i < graph.length ;i++){
            if(graph[i].indegree == 0)
                indegreeZero.add(graph[i]);
        }
        if(indegreeZero.size() == 0)
            return false;
        while (!indegreeZero.isEmpty()){
            Node n = indegreeZero.remove(0);
            sorted.add(n);
            for(Node m : n.getEdges()){
                m.indegreeDecrement();
                if(m.indegree == 0 )
                    indegreeZero.add(m);
            }
        }
        if(sorted.size() != graph.length)
            return false;
        return true;
    }

    public static class Node{
        private int indegree = 0;
        private boolean visited;
        private LinkedList<Node> edges;

        public Node(){
            edges = new LinkedList<>();
        }
        public void addEdge(Node edge){
            edges.add(edge);
        }
        public void indegreeIncrement(){
            this.indegree++;
        }
        public void indegreeDecrement(){
            this.indegree--;
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
    public static void main(String[] args) {
        int[][] p = {{1,0},{0,1}};
        int n = 2;
        System.out.println(canFinish(n,p));
    }
}