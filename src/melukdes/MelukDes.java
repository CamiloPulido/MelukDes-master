package melukdes;

import java.io.*;
import java.util.*;

public class MelukDes {

    public static String leerTxt() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            br.close();
            return everything;
        } catch (Exception e) {
            return e.toString();
        }
    }

    //LECTURA DEJA EL STRING SIN SALTOS DE LINEA Y SIN ESPACIOS
    public static String[] lecturaString(String arregloPalabras) {
        arregloPalabras = arregloPalabras.toUpperCase();
        String[] result = arregloPalabras.split("\\s+");
        return result;
    }
    /*
     public static void leer(String arregloPalabras) {
     String[] dividido = arregloPalabras.split("\\s+");
     for (int i = 0; i < dividido.length; i++) {
     //System.out.println(dividido[i]);
     if (dividido[i].length() >= 5) {
     String dude = dividido[i].substring(0, 4);
     if (dividido[i].startsWith("Loop")) {
     System.out.println("Aqui encontro algo dude");
     }
     if (dividido[i].equalsIgnoreCase("loop1")) {
     System.out.println("coge mayusculas?");
     }
     System.out.println(dude);
     }
     }
     }
     */

    public static void imprimirArregloString(String[] txt) {
        for (int i = 0; i < txt.length; i++) {
            if (i == 0) {
                System.out.print("[" + txt[i] + ", ");
            } else if (i == txt.length - 1) {
                System.out.println(txt[i] + "]");
            } else {
                System.out.print(txt[i] + ", ");
            }
        }
    }

    public static void main(String[] args) {

        HashMap<String, String> mapaComandos = new HashMap<>();
        mapaComandos.put("NOP", "0");
        mapaComandos.put("LDI", "1");
        mapaComandos.put("LD", "2");
        mapaComandos.put("ST", "3");
        mapaComandos.put("ADD", "4");
        mapaComandos.put("INC", "5");
        mapaComandos.put("NEG", "6");
        mapaComandos.put("SUB", "7");
        mapaComandos.put("JMP", "8");
        mapaComandos.put("JZ", "9");
        mapaComandos.put("JN", "A");

        String[] txt = lecturaString(leerTxt());
        imprimirArregloString(txt);
    }
}
