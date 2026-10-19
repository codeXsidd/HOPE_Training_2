package Graph;

import java.util.ArrayList;

public class practice {
    static void add(ArrayList<Integer>[] g, int i, int j){
        g[i].add(j);
        g[j].add(i);
    }
    
    public static void main(String[] args) {
        int n=5;
        
        ArrayList<Integer>[] g= new ArrayList[n];
        for(int i=0; i<n ; i++){
            g[i]= new ArrayList<>();
        }
        
        add(g,0,2);
        add(g,1,3);
        add(g,3,4);
        
        for(int i=0; i<n ; i++){
            System.out.println(i+" -- "+g[i]);
        }
    }
}
