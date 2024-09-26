import java.io.*;

public class Main {
    public static void main(String[] args) {
        String cadea = "o tempo está xélido";
        String ficheiro = "text5.dat";

        // Mensaje de inicio
        System.out.println("Iniciando o proceso de escritura... crucemos os dedos");
        try (
                // Creo el FileOutputStream
                FileOutputStream fileOutputStream = new FileOutputStream(ficheiro);
                // Creo el BufferedOutputStream y DataOutputStream
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)
        ) {
            // Bucle para escribir la cadena dos veces
            for (int i = 0; i < 2; i++) {
                System.out.println("Escribindo: " + cadea);
                System.out.println("A lonxitude desta cadea en caracteres é: " + cadea.length() + " caracteres");
                dataOutputStream.writeChars(cadea);
                System.out.println("Levánse escritos: " + dataOutputStream.size() + " bytes");
            }

            // Mensaje de confirmación
            System.out.println("Escritura completada con exito!");

        } catch (IOException e) {
            System.out.println("Produciuse un erro durante a escritura: " + e.getMessage());
        }

        // Mensaje de inicio de lecturaa
        System.out.println("Iniciando o proceso de lectura... cruzemos os dedos");
        try (
                // Creo el FileInputStream
                FileInputStream fileInputStream = new FileInputStream(ficheiro);
                // Creo el BufferedInputStream y DataInputStream
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)
        ) {
            // Bucle para leer las dos cadenas
            for (int i = 0; i < 2; i++) {
                System.out.print("Lemos a cadea: ");
                for (int j = 0; j < cadea.length(); j++) {
                    System.out.print(dataInputStream.readChar());
                }
                System.out.println();
                System.out.println("Restan por ler: " + dataInputStream.available() + " bytes");
            }

            // Mensaje de confirmación
            System.out.println("Lectura completada con exito!");

        } catch (IOException e) {
            System.out.println("Produciuse un erro durante a lectura: " + e.getMessage());
        }
    }
}
