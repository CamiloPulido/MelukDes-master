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

        for (int i = 0; i < 16; i++) {

            for (int j = 0; j < 16; j++) {
                if (txt[i].equals("")) {
                    System.out.print("x\"00\",");
                } else {
                    System.out.print("x\"" + txt[i] + "\",");
                }
            }
            System.out.println("");

        }
    }

    public static void main(String[] args) {

        HashMap<String, String> mapaComandos = new HashMap<>();
        HashMap<String, String> mapaRegistros = new HashMap<>();

        String[] everything = MelukDes.lecturaString(MelukDes.leerTxt());

        for (int i = 0; i < everything.length; i++) {

        }

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

        mapaRegistros.put("R0R0", "0");
        mapaRegistros.put("R0R1", "1");
        mapaRegistros.put("R0R2", "2");
        mapaRegistros.put("R0R3", "3");

        mapaRegistros.put("R1R0", "4");
        mapaRegistros.put("R1R1", "5");
        mapaRegistros.put("R1R2", "6");
        mapaRegistros.put("R1R3", "7");

        mapaRegistros.put("R2R0", "8");
        mapaRegistros.put("R2R1", "9");
        mapaRegistros.put("R2R2", "A");
        mapaRegistros.put("R2R3", "B");

        mapaRegistros.put("R3R0", "C");
        mapaRegistros.put("R3R1", "D");
        mapaRegistros.put("R3R2", "E");
        mapaRegistros.put("R3R3", "F");
        mapaRegistros.put("R0", "0");
        mapaRegistros.put("R1", "4");
        mapaRegistros.put("R2", "8");
        mapaRegistros.put("R3", "C");

        String[] aux = new String[everything.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = "";
        }
        int i = 0;
        while (true) {
            String s = everything[i];
            if (mapaComandos.containsKey(s)) {
                aux[i] += mapaComandos.get(s);
            }
            if (everything[i].equals(".DATA")) {
                break;
            }
            i++;
        }
        i = 0;
        while (true) {
            String s = everything[i];
            if (s.equals("R0") || s.equals("R1") || s.equals("R2") || s.equals("R3")) {
                if (everything[i + 1].equals("R0") || everything[i + 1].equals("R1") || everything[i + 1].equals("R2") || everything[i + 1].equals("R3")) {
                    s = s + everything[i + 1];
                    if (mapaRegistros.containsKey(s)) {
                        aux[i - 1] += mapaRegistros.get(s);
                    }
                }
            }
            if (everything[i].equals(".DATA")) {
                break;
            }
            i++;
        }
        imprimirArregloString(aux);

    }
}
