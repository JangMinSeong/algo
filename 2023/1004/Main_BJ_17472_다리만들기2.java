package algo;

import java.util.*;

class Node implements Comparable<Node> {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(cost, o.cost);
    }
}

class pair {
	int x;
	int y;
	
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_BJ_17472_다리만들기2 {
    static int[][] map;
    static int[][] visited;
    static int[][] adj;
    static int n, m;
    static ArrayList<ArrayList<pair>> landPos;
    static boolean[] isUsed;
    static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static PriorityQueue<Node> pq;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        
        map = new int[n][m];
        visited = new int[n][m];
        
        adj = new int[7][7];
        isUsed = new boolean[7];
        
        landPos = new ArrayList<>();     
        pq = new PriorityQueue<>();
        
        for(int i=0;i<7;i++) {
        	ArrayList<pair> temp = new ArrayList<>();
        	landPos.add(temp);
        }
        
        input(scanner);
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0)
                    bfs(new pair(i,j), cnt++);
            }
        }
        
        makeAdj(cnt);

        int ans = result(cnt);
        if (isDone(cnt))
            System.out.println(ans);
        else
            System.out.println(-1);
    }

    static void input(Scanner scanner) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = scanner.nextInt();
                map[i][j] = temp;
            }
        }
        for (int i = 0; i <= 6; i++)
            for (int j = 0; j <= 6; j++)
                adj[i][j] = 10000000;
    }

    static void bfs(pair pos, int cnt) {
        Queue<pair> queue = new LinkedList<>();
        visited[pos.x][pos.y] = cnt;
        
        queue.add(pos);
        landPos.get(cnt).add(pos);
        while (!queue.isEmpty()) {
            pair t = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int newX = t.x + d[i][0];
                int newY = t.y + d[i][1];
                
                if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
                if(visited[newX][newY] != 0) continue;  
                if(map[newX][newY] == 0) continue;
                
                visited[newX][newY] = cnt;
                queue.add(new pair(newX, newY));
                landPos.get(cnt).add(new pair(newX, newY));            
            }
        }
    }

    static void makeAdj(int landCnt) {
        for (int i = 1; i < landCnt; i++) {
            for (int j = 0; j < landPos.get(i).size(); j++) {
                pair cur = landPos.get(i).get(j);
                for (int k = 0; k < 4; k++) {
                    int newX = cur.x + d[k][0];
                    int newY = cur.y + d[k][1];
                    int dist = 0;
                    while (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 0) {
                        newX += d[k][0];
                        newY += d[k][1];
                        dist++;
                    }
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 1 && dist >= 2) {
                        int to = visited[newX][newY];
                        if (adj[i][to] > dist)
                            adj[i][to] = dist;
                    }
                }
            }
        }
    }

    static int result(int landCnt) {
    	int sum = 0;
    	for (int i = 1; i < landCnt; i++) {
    		if (adj[1][i] != 10000000) {
    			Node temp = new Node( 1,i,adj[1][i] );
    			pq.add(temp);
    		}
    	}
    	isUsed[1] = true;
    	while (!pq.isEmpty()) {
    		Node temp = pq.poll();

    		if (isUsed[temp.to] != true) {
    			isUsed[temp.to] = true;
    			sum += temp.cost;
    			for (int i = 1; i < landCnt; i++) {
    				if (adj[temp.to][i] == 10000000) continue;
    				if (isUsed[i] == true) continue;
    				Node t = new Node(temp.to, i, adj[temp.to][i]);
    				pq.add(t);
    			}
    		}
    	}
    	return sum;
    }

    static boolean isDone(int landCnt) {
        for (int i = 1; i < landCnt; i++) {
            if (!isUsed[i])
                return false;
        }
        return true;
    }
}
