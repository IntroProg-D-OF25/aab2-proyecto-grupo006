package sistemabuses;

import java.util.Scanner;

class SistemaBuses {
    static String[] paradas = new String[5];
    static String[][] horarios = new String[5][2]; // [parada][0 = salida, 1 = llegada]
    static String[][] rutas = new String[3][5]; // [ruta][paradas]

    static void registrarParada(int indice, String nombre, String salida, String llegada) {
        if (indice >= 0 && indice < paradas.length) {
            paradas[indice] = nombre;
            horarios[indice][0] = salida;
            horarios[indice][1] = llegada;
        }
    }

    static void registrarRuta(int indice, String[] ruta) {
        if (indice >= 0 && indice < rutas.length) {
            for (int i = 0; i < ruta.length; i++) {
                rutas[indice][i] = ruta[i];
            }
        }
    }

    static void mostrarParadas() {
        System.out.println("\nParadas y Horarios:");
        for (int i = 0; i < paradas.length; i++) {
            if (paradas[i] != null) {
                System.out.println((i + 1) + ". " + paradas[i] + " - Salida: " + horarios[i][0] + ", Llegada: " + horarios[i][1]);
            }
        }
    }

    static void mostrarRutas() {
        System.out.println("\nRutas de Autobuses:");
        for (int i = 0; i < rutas.length; i++) {
            if (rutas[i][0] != null) {
                System.out.print("Ruta " + (i + 1) + ": ");
                for (int j = 0; j < rutas[i].length; j++) {
                    if (rutas[i][j] != null) {
                        System.out.print(rutas[i][j] + " -> ");
                    }
                }
                System.out.println("Fin");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar Parada");
            System.out.println("2. Registrar Ruta");
            System.out.println("3. Mostrar Paradas");
            System.out.println("4. Mostrar Rutas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el índice de la parada (0-4): ");
                    int indiceParada = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre de la parada: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Hora de salida: ");
                    String salida = scanner.nextLine();
                    System.out.print("Hora de llegada: ");
                    String llegada = scanner.nextLine();
                    registrarParada(indiceParada, nombre, salida, llegada);
                    break;
                
                case 2:
                    System.out.print("Ingrese el índice de la ruta (0-2): ");
                    int indiceRuta = scanner.nextInt();
                    scanner.nextLine();
                    String[] ruta = new String[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Ingrese la parada " + (i + 1) + " (o presione Enter para terminar): ");
                        String parada = scanner.nextLine();
                        if (parada.isEmpty()) break;
                        ruta[i] = parada;
                    }
                    registrarRuta(indiceRuta, ruta);
                    break;
                
                case 3:
                    mostrarParadas();
                    break;
                
                case 4:
                    mostrarRutas();
                    break;
                
                case 5:
                    System.out.println("Saliendo...");
                    break;
                
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
