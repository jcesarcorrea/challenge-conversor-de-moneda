import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historial {

    private String base;
    private String destino;
    private double tasa;
    private double cantidad;
    private double resultado;
    private LocalDateTime fechaHora;

    public Historial(String base, String destino,
                     double tasa, double cantidad, double resultado) {
        this.base = base;
        this.destino = destino;
        this.tasa = tasa;
        this.cantidad = cantidad;
        this.resultado = resultado;
        this.fechaHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "[" + fechaHora.format(formatter) + "] "
                + cantidad + " [" + base + "] -> "
                + resultado + " [" + destino + "] "
                + "(Tasa: " + tasa + ")";
    }
}