package programmers.dfs_bfs.네트워크;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, int node) {
        visited[node] = true;

        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[j][node] == 1 && node != j) {
                dfs(computers, j);
            }
        }
    }
}
