package graphs;

import java.util.*;

public class shortest_path {

    static class Pair{
        int node,dist;
        public Pair(int node, int dist){
            this.dist = dist;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); 
        
        ArrayList<ArrayList<Integer>> webPages = new ArrayList<>();
        webPages.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> links = new ArrayList<>();
            int linkpages = sc.nextInt();
            while(linkpages-->0){
                links.add(sc.nextInt());
            }
            webPages.add(links);
        }
        int st = sc.nextInt();
        int en = sc.nextInt();

        for(int i=0; i<webPages.size(); i++){
            System.out.println(webPages.get(i));
        }

        int ans = solve(n, st, en, webPages);
        System.out.println("Anseer is: " + ans);
    }

    private static int solve(int n, int st, int en, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> pq = new LinkedList<Pair>();
        int distance[] = new int[n+1];
        Arrays.fill(distance,-1);
        distance[st] = 0;
        pq.add(new Pair(st, 0));
        while(!pq.isEmpty()){
            int dist = pq.peek().dist;
            int node = pq.peek().node;
            pq.poll();
            for(int adjNode: adj.get(node)){
                if(distance[adjNode]==-1){
                    int k = dist + 1;
                    distance[adjNode] = k;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }

        for(int e: distance){
            System.out.print(e+" ");
        }

        return distance[en];
    }    

}
