package templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author itsme
 * @date 2020. 8. 4
 * @see https://www.acmicpc.net/problem/1260
 * @mem
 * @time
 * @caution
 * #BFS, #DFS
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class 좋은저녁 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();

    static int N, M, V;

    static List<Integer>[] graph;// 각 정점별로 갈 수 있는 인접 정점의 정보를 담을 배열
    static boolean[] visited;// 방문 체크

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());
        V = Integer.parseInt(tokens.nextToken());
        // graph 크기는???
        graph = new List[N + 1];
        // graph 초기화
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 값을 읽어서 그래프 구성하기.
        for (int m = 0; m < M; m++) {
            tokens = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(tokens.nextToken());
            int to = Integer.parseInt(tokens.nextToken());
            // 양방향 그래프..
            graph[from].add(to);
            graph[to].add(from);
        }
        // 입력 완료!!
        /* for (List<Integer> list : graph) {
            System.out.println(list);
        }*/

        // 작은 녀석 부터 방문하자..
        for (int n = 1; n < graph.length; n++) {
            Collections.sort(graph[n]);
        }
        // 탐색하러 가기.
        visited = new boolean[N + 1];
        dfs(V);
        output.append("\n");
        bfs(V);
        System.out.println(output);
    }

    static void bfs(int start) {
        // visited 초기화
        Arrays.fill(visited, false);

        // queue 생성 및 시작 노드 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            // 맨 앞에 녀석 데려오기...
            Integer front = queue.poll();
            // 사용하기
            output.append(front).append(" ");
            // 자식 탐색
            List<Integer> childs = graph[front];
            for (int i = 0; i < childs.size(); i++) {
                Integer child = childs.get(i);
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }

    static void dfs(int node) {
        // 방문 처리 및 사용
        visited[node] = true;
        output.append(node).append(" ");

        // 자식 탐색 - 연결된 녀석들만 나와라!!
        List<Integer> childs = graph[node];
        for (int i = 0; i < childs.size(); i++) {
            int child = childs.get(i);
            // 아직 해당 노드가 미방문이라면.. 방문..
            if (!visited[child]) {
                dfs(child);
            }
        }
    }

    static String src = "5 5 3\r\n" +
                        "5 4\r\n" +
                        "5 2\r\n" +
                        "1 2\r\n" +
                        "3 4\r\n" +
                        "3 1";
}
