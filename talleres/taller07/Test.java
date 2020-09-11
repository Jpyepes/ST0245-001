import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
public class Test
{

    public void testInsert() {
        LinkedlistSJ list = new LinkedlistSJ();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));			
        }		
    }

    public void testRemove() {
        LinkedlistSJ list = new LinkedlistSJ();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        System.out.println(list.contains(3));
        list.remove(2);
        System.out.println(list.contains(3));
    }

    public void testContains() {
        LinkedlistSJ list = new LinkedlistSJ();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        System.out.println(list.contains(3));
        System.out.println(list.contains(10));
    }

    public void testContainsPosicion() {
        LinkedlistSJ list = new LinkedlistSJ();
        list.insert(5, 0);
        list.insert(4, 0);
        list.insert(3, 0);
        list.insert(2, 0);
        list.insert(1, 0);
        System.out.println(list.containsPosicion(3));
        System.out.println(list.containsPosicion(10));
    }

    public static void main (String [] args){
        Test p1 = new Test ();
        p1.testInsert();
        p1.testRemove();
        p1.testContains();
        p1.testContainsPosicion();
    }

}

