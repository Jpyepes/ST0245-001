public class Node {

    public Node left,right;
    public Persona1 persona;

    public Node(Persona1 persona) {
        this.left = null;
        this.right = null;
        this.persona = persona;
    }
    public String toString(){
       String texto = this.persona.nombre +" , "+ this.persona.telefono;
       return texto;
    }
}

