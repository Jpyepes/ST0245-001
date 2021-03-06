import java.util.LinkedList;

public class Algorithm1 {
    final static int Vertices = 4;

    public static boolean DFSColorFC(DigraphAM A) {
        return DFSColorFCAux(A, 1);
    }

    private static boolean DFSColorFCAux(DigraphAM A , int color) {
        int matriz[][] = A.getMatriz();
        int colores[] = new int[Vertices]; 
        for (int i = 0; i < Vertices; ++i) 
            colores[i] = -1; 

        colores[color] = 1; 

        LinkedList<Integer> listaE = new LinkedList<Integer>(); 
        listaE.add(color); 

        while (listaE.size() != 0) 
        { 
            int u = listaE.poll(); 

            if (matriz[u][u] == 1) 
                return false;  

            for (int i = 0; i < Vertices; i++) 
            { 
                if (matriz[u][i] == 1 && colores[i] == -1) 
                { 
                    colores[i] = 1-colores[u]; 
                    listaE.add(i); 
                } 
                else if (matriz[u][i] == 1 && colores[i] == colores[u]) 
                    return false; 
            } 
        }
        return true;
    }
}
