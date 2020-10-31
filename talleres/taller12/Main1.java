public class Main1{
     public static void main() {
        DigraphAL graph = new DigraphAL(8);
        graph.addArc(1,2,0);
        graph.addArc(2,4,0);
        graph.addArc(4,8,0);
        graph.addArc(1,5,0);
        System.out.println(graph.caminoBFS(graph, 1, 8));
        System.out.println(graph.caminoBFS(graph, 1, 5));
        System.out.println(graph.caminoBFS(graph, 1, 3));
    }
}