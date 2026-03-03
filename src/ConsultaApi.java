import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ConsultaApi {
    private ArrayList<Historial> listaHistorial = new ArrayList<>();

    private final String apikey = "Your-api-here";
    private final HttpClient client = HttpClient.newHttpClient();

    public void convertir(String baseCode, String conversionRate, double cantidad) {

        try {
            HttpClient cliente = HttpClient.newHttpClient();

            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/"+apikey+"/latest/"+baseCode))
                    .GET()
                    .build();

            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());


            JsonElement elemento = JsonParser.parseString(respuesta.body());
            JsonObject objectRoot = elemento.getAsJsonObject();

            JsonElement conversionRates = objectRoot.get("conversion_rates");
            JsonObject ratesObject = conversionRates.getAsJsonObject();

            JsonElement monedaElement = ratesObject.get(conversionRate);
            double tasa = monedaElement.getAsDouble();
            double resultado = cantidad*tasa;
            System.out.println("El valor "+cantidad+"["+baseCode+"]"+" corresponde al valor final de =>>>> "+(resultado)+"["+conversionRate+"]");

            Historial registro = new Historial(
                    baseCode,
                    conversionRate,
                    tasa,
                    cantidad,
                    resultado
            );

            listaHistorial.add(registro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void mostrarHistorial() {

        if(listaHistorial.isEmpty()){
            System.out.println("No hay conversiones realizadas.");
            return;
        }

        System.out.println("===== HISTORIAL =====");

        for(Historial h : listaHistorial){
            System.out.println(h);
        }
    }
}
