class Edges{
    int dest,weight;
    Edges(int d,int w)
    {
        dest=d;
        weight=w;
    }
}
class Pair{
    int node,weight;
    Pair(int d,int w)
    {
        node=d;
        weight=w;
    }
}
class Solution {
    public int graphCost(ArrayList<ArrayList<Edges>> graph,int v)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        boolean visited[]=new boolean[v];
        pq.add(new Pair(0,0));
        int cost=0;

        while(!pq.isEmpty())
        {
            Pair cur=pq.poll();
            int curNode=cur.node;

            if(visited[curNode])
            {
                continue;
            }

            visited[curNode]=true;
            cost+=cur.weight;
            
            for(Edges e:graph.get(curNode))
            {
                pq.add(new Pair(e.dest,e.weight));
            }
        }
        return cost;

    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Edges>> graph=new ArrayList<>();
        for(int i=0;i<points.length;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<points.length;i++)
        {
           for(int j=i+1;j<points.length;j++)
           {
             int w=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);

             graph.get(i).add(new Edges(j,w));
             graph.get(j).add(new Edges(i,w));
           }
        }
        return graphCost(graph,points.length);

    }
}