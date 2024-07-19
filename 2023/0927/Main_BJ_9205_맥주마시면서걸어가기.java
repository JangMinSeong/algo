package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BJ_9205_맥주마시면서걸어가기 {
	static int n;
	static ArrayList<ArrayList<Integer>> adj;
	static int [][] con;
	static boolean [] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for(int t=0;t<test_case;t++) {
			n = Integer.parseInt(br.readLine());
			
			adj = new ArrayList<>();
			for(int i=0;i<n+2;i++) {
				ArrayList<Integer> temp = new ArrayList<>();
				adj.add(temp);
			}
			
			con = new int [n+2][2];
			visited = new boolean [n+2];
			
			for(int i=0;i<n+2;i++) {
				String [] str = br.readLine().split(" ");
				con[i][0] = Integer.parseInt(str[0]);
				con[i][1] = Integer.parseInt(str[1]);
			}
			
			for(int i=0;i<n+2;i++) {
				for(int j=i+1;j<n+2;j++) {
					if(calDis(con[i][0], con[i][1], con[j][0], con[j][1]) <= 1000) {
						adj.get(i).add(j);
						adj.get(j).add(i);
					}
				}
			}
			
			if(bfs()) System.out.println("happy");
			else System.out.println("sad");
		}
		
	}
	
	public static boolean bfs() {
		visited[0] = true;
		Queue<Integer> que = new LinkedList<>();
		que.add(0);
		while(!que.isEmpty()) {
			int temp = que.poll();
			
			for(int i=0;i<adj.get(temp).size();i++) {
				if(visited[adj.get(temp).get(i)] == true) continue;
				if(adj.get(temp).get(i) == n+1) return true;
				
				visited[adj.get(temp).get(i)] = true;
				que.add(adj.get(temp).get(i));
			}
		}
		return false;
	}
	
	public static int calDis(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
