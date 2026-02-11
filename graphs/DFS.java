package graphs;
import data_structures.stacks.StackLL;


public class DFS {
    public void search(int data, int [][] adj){ //Graph itself as adj matrix to search and the target
        StackLL S = new StackLL();
        int visited[] = new int[adj.length];
        S.push(0);
        visited[0] = 1; // we add the first index into the visited
        while (!S.isEmpty()){
            int v = S.pop();
            System.out.println(v);
            for (int w= 0; w < adj.length; w++){ // We assume that adj will contain all the adjacencies for v
                if (adj[v][w] == 1 && visited[w] == 0){
                    S.push(w);
                    visited[w] = 1; // we mark indices w as 1 to represent visited
                }
            }
        }



    }
    public static void main(String[] args) {
        
    }
}

// DFS(START)
//     Stack S
//     Mark all nodes as unchecked
//     S.push(START)
//     Mark START as checked

//     while S is not empty do
//         v ← S.pop()
//         Print v

//         for each neighbor w of v do
//             if w is unchecked then
//                 S.push(w)
//                 Mark w as checked
