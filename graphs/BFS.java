package graphs;
import data_structures.queues.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS<T> {
    public void search(T start, Map<T, List<T>> graph) {
        Deque<T> Q = new Deque<>();
        Set<T> visited = new HashSet<>();

        Q.addLast(start);
        visited.add(start);

        while (!Q.isEmpty()) {
            T v = Q.popRight();
            System.out.println(v);

            for (T w : graph.get(v)) {
                if (!visited.contains(w)) {
                    visited.add(w);
                    Q.addLast(w);
                }
            }
        }
    }
}


// BFS(START)
//     Queue Q
//     Mark all nodes as unchecked
//     Q.add(START)
//     Mark START as checked

//     while Q is not empty do
//         v ← Q.delete()
//         Print v

//         for each neighbor w of v do
//             if w is unchecked then
//                 Q.add(w)
//                 Mark w as checked