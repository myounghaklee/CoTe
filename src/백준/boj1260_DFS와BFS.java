package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1260_DFS와BFS {

    static class Node {
        int id;
        List<Node> neighbors;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        // 이웃 추가 메서드
        public void addNeighbor(Node neighbor) {
            this.neighbors.add(neighbor);
            neighbor.neighbors.add(this);  // 무방향 그래프이므로 양방향 추가
        }

        // 이웃 정렬 메서드
        public void sortNeighbors() {
            this.neighbors.sort(Comparator.comparingInt(n -> n.id));
        }
    }

    static Map<Integer, Node> graph = new HashMap<>();
    static boolean[] isVisited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N + 1]; // 1부터 N까지의 노드를 위해 N+1 크기로 생성

        for (int i = 1; i <= N; i++) {
            graph.put(i, new Node(i));  // 모든 노드 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).addNeighbor(graph.get(v));
        }

        for (int i = 1; i <= N; i++) {
            graph.get(i).sortNeighbors(); // 각 노드의 이웃 정렬
        }

        dfs(graph.get(V));
        Arrays.fill(isVisited, false);
        bfs(graph.get(V));

        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());
    }

    static void dfs(Node node) {
        isVisited[node.id] = true;
        dfsResult.append(node.id).append(" ");

        for (Node neighbor : node.neighbors) {
            if (!isVisited[neighbor.id]) {
                dfs(neighbor);
            }
        }
    }

    static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start.id] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            bfsResult.append(node.id).append(" ");

            for (Node neighbor : node.neighbors) {
                if (!isVisited[neighbor.id]) {
                    isVisited[neighbor.id] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}

