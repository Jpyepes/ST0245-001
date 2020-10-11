
public class Pairs {
    String condicion;
    String exito;

    public Pairs(String condicion, String exito) {
        this.condicion = condicion;
        this.exito = exito;
    }

    @Override
    public String toString() {
        return "Pairs{" +
        "condicion='" + condicion + '\'' +
        ", exito='" + exito + '\'' +
        '}';
    }
}
