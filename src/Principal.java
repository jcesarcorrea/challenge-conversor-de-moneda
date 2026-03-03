import com.google.gson.*;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaApi consultaApi = new ConsultaApi();

        while (true){
            System.out.println("""
            ***************************************
            Sea bienvenido/a al conversor de moneda
            1) Dólar =>> Peso argentino
            2) Peso argentino =>> Dólar
            3) Dólar =>> Real brasileño
            4) Real brasileño =>> Dolar
            5) Dolar =>> Peso colombiano
            6) Peso colombiano =>> Dolar
            7) Historial de conversiones
            8) Salir
            Elija una opción válida:
            ***************************************""");

            var opcion = teclado.nextLine();

            if (opcion.equalsIgnoreCase("8")){
                break;
            }

            switch (opcion){
                case "1":
                    System.out.println("Ingresa el valor que desees convertir");
                    consultaApi.convertir("USD","ARS",Double.parseDouble(teclado.nextLine()));
                    break;
                case "2":
                    System.out.println("Ingresa el valor que desees convertir");
                    consultaApi.convertir("ARS","USD",Double.parseDouble(teclado.nextLine()));
                    break;
                case "3":
                    System.out.println("Ingresa el valor que desees convertir");
                    consultaApi.convertir("USD","BRL",Double.parseDouble(teclado.nextLine()));
                    break;
                case "4":
                    System.out.println("Ingresa el valor que desees convertir");
                    consultaApi.convertir("BRL","USD",Double.parseDouble(teclado.nextLine()));
                    break;
                case "5":
                    System.out.println("Ingresa el valor que desees convertir");
                    consultaApi.convertir("USD","COP",Double.parseDouble(teclado.nextLine()));
                    break;
                case "6":
                    System.out.println("Ingresa el valor que desees convertir");
                    consultaApi.convertir("COP","USD",Double.parseDouble(teclado.nextLine()));
                    break;
                case "7":
                    consultaApi.mostrarHistorial();
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        }
    }
}
