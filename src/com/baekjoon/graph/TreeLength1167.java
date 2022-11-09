package com.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 틀린이유
 * 1.더 길이가 짧은 놈이 가버려서는 안됨
 * 2.더 길이가 긴놈으로 갈아꼈다고 해서 다른 리프노드의 길로 가버려서는 안됨
 */
public class TreeLength1167 {
    public static void main(String[] args) {
        try {
            new TreeLength1167().solution();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     */
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 입력이 10만이라는 것은 N^2이 금지라는 것
        // 어떻게 해야 최대거리를 구할 수 있을까?

        // 완전 탐색을 한다면 N개의 노드가 가진 거리 다 구함 -> 최대값 비교
        // 나하고 연결된 간선 거리 다 구하기 -> 각각의 도착지에서 다시 가는 거리를 또 구하고...
        // 한번 거리를 구해놓으면 다시 구할 필요없음

        // 최대거리는 리프노드와 리프노드의 연결일 것이다
        // 그러니까 어떤 노드에서 리프노드들까지의 거리만 다 구해 놓는다면?

        // queue에 리프노드 다 넣어서 구해보기
        // 근데 이전 칸으로 돌아가면 안돼니 visit
        
        // 갈림길이 여러개라면 다른 길에서 오는 리프노드 기다리기

        Queue<Leaf> q = new ArrayDeque<>();

        // 인접리스트
        Node[] adjNodes = new Node[N + 1];
        // 가장 먼 리프노드까지의 거리를 저장한 배열
        int[] dist = new int[N + 1];
        // 이 노드에는 갈림길이 몇 개인가
        int[] roads = new int[N + 1];
        // 방문배열 체크
        boolean[] vis = new boolean[N+1];
        // vis = false인 칸이 몇 칸 남았는지?
        int num = N;

        int now;
        int end;
        int length;
        int cnt;
        // 인접리스트 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            now = Integer.parseInt(st.nextToken());
            //길 몇개랑 연결되어 있는가?
            cnt = 0;

            while (true) {
                end = Integer.parseInt(st.nextToken());

                if (end == -1)
                    break;

                cnt++;
                length = Integer.parseInt(st.nextToken());

                adjNodes[now] = new Node(end, length, adjNodes[now]);
            }

            if (cnt == 1) {
                // 리프노드는 q에 넣기
                q.offer(new Leaf(now, 0));
                vis[now] = true;
                num--;
            }

            roads[now] = cnt - 1;
        }

        int ans = 0;
        Leaf me;
        while (num != 0) {

            me = q.poll();

            for (Node i = adjNodes[me.now]; i != null; i = i.next) {
                // 이전길로 돌아가기 금지
                if (vis[i.end]) {
                    continue;
                } 

                // 여기에 도착했던 리프노드가 있다
                if (dist[i.end] != 0) {
                    // 정답 갱신
                    ans = Math.max(ans, dist[i.end] + me.length + i.length);
                }

                //최장거리 갱신
                dist[i.end] = Math.max(dist[i.end], me.length + i.length);

                //이제 남은 길이 하나뿐이다
                if(roads[i.end] == 1){
                    q.offer(new Leaf(i.end, dist[i.end]));
                    vis[i.end] = true;
                    num--;
                }
                roads[i.end]--;
            }
        }

        //마지막에 노드 두개 남음
        int last = 0;
        Leaf a = q.poll();
        Leaf b = q.poll();
        for (Node i = adjNodes[a.now]; i != null; i = i.next) {
            if(i.end == b.now){
                last = i.length;
                break;
            }
        }

        ans = Math.max(dist[a.now] + dist[b.now] + last, ans);

        System.out.println(ans);
    }

    class Leaf{
        int now, length;

        Leaf(int now, int length) {
            this.now = now;
            this.length = length;
        }
    }

    class Node {
        int end, length;
        Node next;

        public Node(int end, int length, Node next) {
            this.end = end;
            this.length = length;
            this.next = next;
        }
    }
}