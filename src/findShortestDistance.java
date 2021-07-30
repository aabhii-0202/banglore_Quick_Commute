public class findShortestDistance {
    private final float[][] cost = banglore_quick_commute.costMatrix;
    private int nodes,dest;
    private float[] distance;
    private final String[] names=banglore_quick_commute.names;

    public void find(int src, int dest){
        this.nodes= names.length;
        this.dest=dest;
        this.distance=new float[nodes+1];
        compute(nodes,src);
    }

    private void compute(int n,int src){
        int i,c,u,minpos=1;
        float minimum;
        int[] flag =new int[n+1];
        for(i=0;i<n;i++) {
            flag[i] = 0;
            this.distance[i] = this.cost[src][i];
        }
        c=2;
        while(c<=n){
            minimum=99;
            for(u=1;u<n;u++){
                if (this.distance[u]<minimum&&flag[u]!=1){
                    minimum=this.distance[i];
                    minpos=u;
                }
            }
            flag[minpos]=1;
            c++;
            for(u=1;u<n;u++){
                if(this.distance[minpos]+this.cost[minpos][u]<this.distance[u]&&flag[u]!=1)
                    this.distance[u]=this.distance[minpos]+this.cost[minpos][u];
            }
        }
        for(i=1;i<nodes;i++)
            if(i== dest) System.out.println("Distance calculated by Djikstras algo "+names[src]+" --> : "+names[i]+". Distance = : "+distance[i]+"km");

    }


}
