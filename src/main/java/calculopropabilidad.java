import javafx.application.Application;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;

public class calculopropabilidad extends Application {

    public static void main(String[] args) {
        //launch(args);
        List<Integer> bola1 = new ArrayList<>();
        List<Integer> bola2 = new ArrayList<>();
        List<Integer> bola3 = new ArrayList<>();
        List<Integer> bola4 = new ArrayList<>();

        Random bola = new Random();
        int numIntentos = 10000;
        int totalTemas = 23;
        int total = 0;
        int porcentajeTotal = 0;
        int temas = 49;

        Map<Integer, Integer> porcentajeBolas = new HashMap<>();
        Map<Integer, Integer> temasRepetidos = new HashMap<>();

        for (int i = 1; i <= temas; i = i + 1) {
            temasRepetidos.put(i, 0);
        }

        for (int i = 0; i <= numIntentos; i = i + 1)
        {
            bola1.add(bola.nextInt(temas) + 1);
            bola2.add(bola.nextInt(temas) + 1);
            bola3.add(bola.nextInt(temas) + 1);
            bola4.add(bola.nextInt(temas) + 1);

            if (bola1.get(i) <= totalTemas) {
                total = total + 1;
            }

            if (bola2.get(i) <= totalTemas) {
                total = total + 1;
            }

            if (bola3.get(i) <= totalTemas) {
                total = total + 1;
            }

            if (bola4.get(i) <= totalTemas) {
                total = total + 1;
            }

            temasRepetidos.replace(bola1.get(i), temasRepetidos.get(bola1.get(i)) + 1);
            temasRepetidos.replace(bola2.get(i), temasRepetidos.get(bola2.get(i)) + 1);
            temasRepetidos.replace(bola3.get(i), temasRepetidos.get(bola3.get(i)) + 1);
            temasRepetidos.replace(bola4.get(i), temasRepetidos.get(bola4.get(i)) + 1);
        }

//        for (Integer element: sorted.keySet()) {
//            System.out.println(element + ":" + sorted.get(element));
//        }


        Collections.sort(bola1);
        System.out.println("***************** BOLA 1 *******************");
        for (int i = 0; i <= numIntentos; i = i + 1)
        {
            if (bola1.get(i) <= totalTemas) {
                if (!porcentajeBolas.containsKey(1)) {
                    porcentajeBolas.put(1, 1);
                }

                porcentajeBolas.replace(1, porcentajeBolas.get(1) + 1);
            }
           //System.out.println(bola1.get(i));
        }



        System.out.println("Total: " + totalTemas + " : " + (porcentajeBolas.get(1) - 1));
        System.out.println("Porcentaje: " + ((porcentajeBolas.get(1) - 1) * 100) / numIntentos);

        Collections.sort(bola2);
        System.out.println("***************** BOLA 2 *******************");
        for (int i = 0; i <= numIntentos; i = i + 1)
        {
            if (bola2.get(i) <= totalTemas) {
                if (!porcentajeBolas.containsKey(2)) {
                    porcentajeBolas.put(2, 1);
                }

                porcentajeBolas.replace(2, porcentajeBolas.get(2) + 1);
            }

           // System.out.println(bola2.get(i));
        }

        System.out.println("Total: " + totalTemas + " : " + (porcentajeBolas.get(2) - 1));
        System.out.println("Porcentaje: " + ((porcentajeBolas.get(2) - 1) * 100) / numIntentos);

        Collections.sort(bola3);
        System.out.println("***************** BOLA 3 *******************");
        for (int i = 0; i <= numIntentos; i = i + 1)
        {
            if (bola3.get(i) <= totalTemas) {
                if (!porcentajeBolas.containsKey(3)) {
                    porcentajeBolas.put(3, 1);
                }

                porcentajeBolas.replace(3, porcentajeBolas.get(3) + 1);
            }

            //System.out.println(bola3.get(i));
        }

        System.out.println("Total: " + totalTemas + " : " + (porcentajeBolas.get(3) - 1));
        System.out.println("Porcentaje: " + ((porcentajeBolas.get(3) - 1) * 100) / numIntentos);

        Collections.sort(bola4);
        System.out.println("***************** BOLA 4 *******************");
        for (int i = 0; i <= numIntentos; i = i + 1)
        {
            if (bola4.get(i) <= totalTemas) {
                if (!porcentajeBolas.containsKey(4)) {
                    porcentajeBolas.put(4, 1);
                }

                porcentajeBolas.replace(4, porcentajeBolas.get(4) + 1);
            }

            //System.out.println(bola4.get(i));
        }

        System.out.println("Total: " + totalTemas + " : " + (porcentajeBolas.get(4) - 1));
        System.out.println("Porcentaje: " + ((porcentajeBolas.get(4) - 1) * 100) / numIntentos);


        porcentajeTotal = ((total - 1) * 100) / (numIntentos * 4);
        System.out.println("Porcentaje Total: " + porcentajeTotal);

        System.out.println("****** Repetidos ******");

        Map<Integer, Integer> sorted = temasRepetidos
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));

        System.out.println(sorted);


    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("caca");
    }
}
