import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class pair {
	int x;
	int y;
	
	public pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_BJ_14502_¿¬±¸¼Ò {
	static int n, m; 
	static int [][] map;
	static int [][] d = {{-1,0},{1,0},{0,-1},{0,1}};
	static ArrayList<pair> virus;
	static ArrayList<pair> blank;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		map = new int [n][m];
		virus = new ArrayList<>();
		blank = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String [] temp = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if(map[i][j] == 2) {
					virus.add(new pair(i,j));
				} else if(map[i][j] == 0) {
					blank.add(new pair(i,j));
				}
			}
		}
		
		for(int i=0;i<blank.size();i++) {
			map[blank.get(i).x][blank.get(i).y]=1;  
			for(int j=i+1;j<blank.size();j++) {
				map[blank.get(j).x][blank.get(j).y]= 1; 
				for(int k=j+1;k<blank.size();k++) {
					map[blank.get(k).x][blank.get(k).y]= 1;
					int cnt_virus = bfs();
					if(blank.size() - cnt_virus > max) {
						max = blank.size() - cnt_virus;
					}
					map[blank.get(k).x][blank.get(k).y]= 0; 
				}
				map[blank.get(j).x][blank.get(j).y]= 0;
			}
			map[blank.get(i).x][blank.get(i).y]=0; 
		}
		
		System.out.println(max - 3);
	}
	
	public static int bfs() {
		int count = 0;
		int [][] visited = new int [n][m];
		
		Queue<pair> que = new LinkedList<>();
		for(int i=0;i<virus.size();i++) {
			que.add(virus.get(i));
		}
		
		while(!que.isEmpty()) {
			pair temp = que.poll();
			
			for(int i=0;i<4;i++) {
				int newX = temp.x + d[i][0];
				int newY = temp.y + d[i][1];
				
				if(newX < 0 || newX >= n || newY < 0 || newY >= m) continue;
				if(map[newX][newY] != 0) continue;
				if(visited[newX][newY] != 0) continue;
				
				count++;
				visited[newX][newY] = 1;
				que.add(new pair(newX,newY));
			}
		}
		
		return count;
	}
}
