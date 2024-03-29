package programmers.greedy.단속카메라;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int lastCamera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (lastCamera >= route[0] && lastCamera <= route[1]) {
                continue;
            }
            answer++;
            lastCamera = route[1];
        }

        return answer;
    }
}
