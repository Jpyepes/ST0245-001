
import java.util.ArrayList;

public class Algorithm {
    public static boolean DFSColorFC(Graph tree) {
        int[] check = new int[tree.size()];
        check[0] = 2;
        return DFSColorFCAux(tree.getSuccessors(0),2,check,tree);
    }

    private static boolean DFSColorFCAux(ArrayList<Integer> siguiente,int color,int[]check,Graph tree ) {
        boolean retorno = true;
        for(int k: siguiente){
            if(retorno == false)
                break;
            if(check[k] == 0   && color == 2){
                check[k] = 1;
                retorno = retorno && DFSColorFCAux(tree.getSuccessors(k),1,check,tree);
            }
            else if(check[k] == 0   && color == 1){
                check[k] = 2;
                retorno = retorno && DFSColorFCAux(tree.getSuccessors(k),2,check,tree);
            }
            else if(check[k] == color)
                return false;

        }    
        return retorno; 
        
    }
    public static void main(String[] args) {
       DigraphAM tree = new DigraphAM(9);
       for(int i = 1; i<8;++i){
        tree.addArc(0,i,1);
       } 
       DigraphAM graph = new DigraphAM(9);
        graph.addArc(1,2,0);
        graph.addArc(2,4,0);
        graph.addArc(4,8,0);
        graph.addArc(1,5,0);
       System.out.println("Arbol 1: "+DFSColorFC(tree));
       System.out.println("Arbol 2: "+DFSColorFC(graph));
       }
}
