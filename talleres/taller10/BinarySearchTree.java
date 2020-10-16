public class BinarySearchTree {

    private Node root;

    // Constructor sin parametros iniciar sin nodo
    public BinarySearchTree() {
        this.root = null;
    }
    //Contructor iniciando con nodo
    public BinarySearchTree(String nombre,int n) {
        this.root = new Node(new Persona1(nombre, n));
    }

    //Llama al metodo auxiliar insertar
    public void insertar(String nombre,int n) {
        insertarAux(root, n, nombre);
    }
    // Agrega un nodo al arbol
    private void insertarAux(Node node, int n, String nombre) {
        if (node.persona.telefono == n){
            return;
        }else if (n > node.persona.telefono) {
            if (node.right == null) {
                node.right = new Node(new Persona1(nombre,n));
            }else {
                insertarAux(node.right, n, nombre);
            }
        }else {
            if (node.left == null) {
                node.left = new Node(new Persona1(nombre,n));
            }else {
                insertarAux(node.left, n, nombre);
            }
        }
    }

    // Llama al metodo auxiliar buscar
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    //Busca en el arbol si existe un valor, devuelve true o false, dependiendo de si este o no
    private boolean buscarAux(Node node, int n) {
        if (node == null) {
            return false;
        }
        if (node.persona.telefono == n) {
            return true;
        }
        if (n > node.persona.telefono ) {
            return buscarAux(node.right, n);
        }
        return buscarAux(node.left, n);
    }

    public String print (Node nodo){
        String cabeza = "digraph G {"+"\n";
        String fin = "}";
        return cabeza +printaux(nodo)+fin;
    }

    public String printaux(Node nodo){
        String comilla = "\"";
        String flecha = " -> ";
        String texto = "";
        if (nodo == null){
            return texto;
        }
        if(nodo.left != null){
            texto = texto + comilla + nodo.toString() + comilla + flecha;
            texto = texto + comilla + nodo.left.toString() + comilla + "\n";
        }
        if(nodo.right != null){
            texto = texto + comilla + nodo.toString() + comilla + flecha;
            texto = texto + comilla + nodo.right.toString() + comilla + "\n";
        }
        
        texto = texto + printaux(nodo.left) +printaux(nodo.right);

        return  texto;
    }

    public static void main (String[]args){
        BinarySearchTree b1 = new BinarySearchTree ("simon",10);
        b1.insertar("christi", 17);
        b1.insertar("yeps", 5);
        b1.insertar("mesa", 8);
        b1.insertar("santi", 3);
        System.out.println(b1.print(b1.root));
    }

} 
