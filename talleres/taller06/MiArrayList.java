public class MiArrayList {


        /**
         * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
         * de la clase ya implementada "ArrayList"
         * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio.
         * Para más información de la clase ArrayList:
         * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
         *
         *
         * @author Mauricio Toro, Andres Paez
         * @version 1
         */
    
    //Nota: Hacen falta algunas partes de las lineas de codigo, estas estan indicadas con una linea, ¡debes completarlas!
            private int size;
            private int array[];
    
            /**
             * El metodo constructor se utiliza para incializar
             * variables a valores neutros como 0 o null.
             * El contructor no lleva parámetros en este caso.
             */
            public MiArrayList() {
                array = new int[10];
                size = 0;
            }
    
    
            /**
             * Tiene la intención de retornar la longitud del objeto
             * @return longitud del objeto
             *
             * El size esta influenciado por las funciones add y del
             */
            public int size() {
                return size;
            }
    
            /**
             * @param e el elemento a guardar
             * Agrega un elemento e a la última posición de la lista
             *
             */
            public void add(int e) {
                add( size, e);
            }
    
    
            /**
             * @param i es un íncide donde se encuentra el elemento posicionado
             * Retorna el elemento que se encuentra en la posición i de la lista.
             *
             */
            public int get(int i) {
                if (i < size && i >= 0) {
                    return array[i];
                }else {
                    throw new IndexOutOfBoundsException("Index : " + i);
                }
            }
    
    
            /**
             * @param index es la posicion en la cual se va agregar el elemento
             * @param e el elemento a guardar
             * Agrega un elemento e en la posición index de la lista
             *
             */
            public void add(int index, int e) {
                if ( index < size && index >= 0) {
    
                    for (int i = 0; i <= size; i++) {
                        if (i == size && size == array.length) {
                            extend();
                        }
                        // ¿Esto funciona si se recorre el arreglo de izquierda a derecha?
                        if (i == index) {
                            int swap = e ;
                            array[i] = swap;
                            i++;
                            size++;
                        }
                    }
                }else if ( index >= size) {
                    array[index] = e;
                    size++;
                    if (size == array.length) {
                        extend();
                    }
                }
            }
    
            private void extend() {
                int [] array2 =  new int[array.length*2];
                for (int i = 0; i < size; i++) {
                    array2[i] = array[i];
                }
                array = array2;
            }
    
            /**
             * @param index es la posicion en la cual se va eliminar el elemento
             *
             * ELimina el elemento  en la posición index de la lista
             *
             */
            public void del(int index){
                
                for (int i = index; i < size; i++) {
                          array[i] = array[i+1];
                      
                        }
                        array [size]= 0;
                        size--;
            
}


    public static void main(String[] args) {
	MiArrayList obj = new MiArrayList();

	obj.add(14);
	obj.add(15);
	obj.add(2, 28);
	obj.add(1, 34);
    obj.add(3,79);
     for(int i = 0; i<obj.size(); i++)
        System.out.println(obj.get(i));
    
    System.out.println("index 0 delete");
    obj.del(0);
    for(int i = 0; i<obj.size(); i++)
            System.out.println(obj.get(i));
    }
}


