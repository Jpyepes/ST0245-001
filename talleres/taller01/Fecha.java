
public class Fecha
{
    private final int año;
    private final int mes;
    private final int dia;

    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    /**
     * Método para obtener la variable global dia.
     *
     * @return el dia
     */
    public int dia() {
        return this.dia;
    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes
     */
    public int mes() {
        return this.mes;
    }

    /**
     * Método para obtener la variable global anio.
     *
     * @return el año
     */
    public int año() {
        return this.año;
    }

    /**
     * @param otra representa la fecha con la cual se va a comparar.
     *
     * El método comparar se encarga de devolvernos respuesta a tres posibilidades.
     * 1: si la fecha es menor que la otra retorna -1.
     * 2: si la fecha es igual que la otra retorna 0.
     * 3: si la fecha es mayor que la otra retorna 1.
     *
     * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
     *
     */

    public int comparar(Fecha otra) {
        if(año() < otra.año()){
            return -1;
        }
        if(año() > otra.año()){
            return 1;
        }

        if(mes() < otra.mes()){
            return -1;
        }
        if(mes() > otra.mes()){
            return 1;
        }

        if(dia() < otra.dia()){
            return -1;
        }
        if(dia() > otra.dia()){
            return 1;
        }
        return 0;
    }

    /**
     * toString se encargará de convertir el tipo abstracto fecha en un tipo cadena
     * para su posterior visualización
     *
     * @return una cadena que contiene la fecha
     */
    public String toString() {
       String texto = dia() + "/" + mes() + "/" + año();
       return texto;
    }
}


