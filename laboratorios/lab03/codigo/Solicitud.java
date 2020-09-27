public class Solicitud {
    String local;
    int cantidad;

    public Solicitud(String local, int cantidad) {
        this.local = local;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "local='" + local + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}
