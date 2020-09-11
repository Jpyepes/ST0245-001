import java.lang.IndexOutOfBoundsException;
public class LinkedlistSJ
{
    Node head;
    private int size;

    public LinkedlistSJ() {
        size = 0;
        head = null;
    }

    /**
     * Returns the node at the specified position in this list.
     *
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size() {
        return size;
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            Node nuevo = new Node(data);
            nuevo.next = head;
            head = nuevo;
            size++;
        } else if(index != 0){
            Node temp = getNode(index - 1); 
            Node nuevo = new Node(data);
            nuevo.next= temp.next;  
            temp.next = nuevo;
            size++;
        }else 
        {
            throw new IndexOutOfBoundsException();
        }
    }
    // Borra el dato en la posición index

    public void remove(int index) {
        try {
            if (index == 0) {
                Node temp = head;
                head = temp.next;
                size--;
            } else if (index == size - 1) {
                Node temp = getNode(size - 2);
                temp.next = null;
                size--;
            } else {
                Node temp = getNode(index - 1);
                temp.next = temp.next.next;
                size--;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }

    }

    // Verifica si está un dato en la lista
    public boolean contains(int data) {
        try {
            for (int i = 0; i < size; i++) {
                if (get(i) == data) {
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Posición inválida");
        } 
        return false;
    }
    
    //Retorna donde esta el dato en la lista y si no esta retorna -1
    
    public int containsPosicion(int data) {
        try {
            for (int i = 0; i < size; i++) {
                if (get(i) == data) {
                    return i;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Posición inválida");
        } 
        return -1;
    }
}
