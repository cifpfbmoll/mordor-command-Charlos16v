package edu.pingpong.mordorcommand;


import edu.pingpong.mordorcommand.interfaces.Order;
import edu.pingpong.mordorcommand.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.orders.DangerousOrder;
import edu.pingpong.mordorcommand.orders.InternationalOrder;
import edu.pingpong.mordorcommand.orders.NationalOrder;
import edu.pingpong.mordorcommand.processors.Office;
import edu.pingpong.mordorcommand.treatments.DangerousOrderTreatment;
import edu.pingpong.mordorcommand.treatments.InternationalOrderTreatment;
import edu.pingpong.mordorcommand.treatments.MultipleOrderTreatment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Crea una oficina que procesa pedidos.
 * <p>
 * En funcion de si el tratamiento del pedido es posible o no
 * la oficina procesa el pedido (true /false)
 * e informa de su estado (aceptado /rechazado).
 * <p>
 * Como los pedidos pueden ser de multiples tipos,
 * muchos de ellos aun desconocidos y cada uno
 * con sus particularidades propias,
 * vamos a usar el patron COMMAND.
 * <p>
 * Consulta el manual de referencia para ver un ejemplo del patron.
 * <p>
 * Aplicando el patron COMMAND no procesaremos pedidos,
 * sino que le pasaremos a la oficina /procesador
 * el tipo de tratamiento que ha de aplicar a cada pedido,
 * y sera el propio pedido el que decida como debe ser tratado.
 * <p>
 * PASA LOS CASOS TEST PROPUESTOS y utilizalos como guia para el desarrollo.
 * NO PUEDES MODIFICAR EL CODIGO DE LOS CASOS TEST
 * <p>
 * La clase App.java contiene el MAIN y ha de funcionar.
 * NO PUEDES MODIFICAR EL CODIGO DEL MAIN
 * <p>
 * Crea un proyecto MAVEN siguiendo el esquema: org.mvpigs.commandpattern
 * Respeta la estructura del proyecto indicada
 * en el nombre de los paquetes que se indican en los casos test.
 * <p>
 * - Realiza commits periódicamente mientras avanzas en el desarrollo de la aplicación.
 * - Publica tu solucion en GitHub.
 * - Enviame tu proyecto comprimido en un ZIP a gelpiorama@gmail.com
 * <p>
 * No olvides dibujar a mano alzada el DIAGRAMA DE CLASES UML de tu solucion
 * para completar la evaluacion de la parte practica de ED.
 */

public class App {

    public static void main(String[] args) {

        Office office = new Office();

        System.out.println("====== InternationalOrder to Comarca! ======");
        Order orderToComarca = new InternationalOrder("Comarca", 10);
        OrderTreatment internationalOrderTreatmentComarca = new InternationalOrderTreatment(
                (InternationalOrder) orderToComarca);
        System.out.println(office.printStatus(office.processes(internationalOrderTreatmentComarca), orderToComarca) + '\n');


        System.out.println("====== InternationalOrder to Mordor! ======");
        Order orderToMordor = new InternationalOrder("Mordor", 10);
        OrderTreatment internationalOrderTreatmentMordor = new InternationalOrderTreatment((InternationalOrder) orderToMordor);
        System.out.println(office.printStatus(office.processes(internationalOrderTreatmentMordor), orderToMordor) + '\n');

        System.out.println("====== DangerousOrder to Cima de los vientos! ======");
        Order dangerousOrder = new DangerousOrder("Cima de los vientos",
                "No urgarse en las uñas con este puñal");
        OrderTreatment dangerousOrderTreatment = new DangerousOrderTreatment((DangerousOrder) dangerousOrder);

        System.out.println(office.printStatus(office.processes(dangerousOrderTreatment), dangerousOrder) + '\n');


        System.out.println("====== DangerousOrder to Monte del destino! ======");
        Order rejetedDangerousOrder = new DangerousOrder("Monte del destino",
                "No ponerselo en el dedo");
        OrderTreatment rejectedDangerousOrderTreatment = new DangerousOrderTreatment((DangerousOrder) rejetedDangerousOrder);

        System.out.println(office.printStatus(office.processes(rejectedDangerousOrderTreatment), rejetedDangerousOrder) + '\n');


        System.out.println("====== MultipleOrder! ======");
        Set<Order> orders = new HashSet<>();
        List<String> destinations = Arrays.asList("Gondor", "Minas Tirith", "Rohan");
        List<Integer> weights = Arrays.asList(10, 10, 10);

        for (int i = 0; i < destinations.size(); i++) {
            orders.add(new NationalOrder(destinations.get(i), weights.get(i)));
        }


        MultipleOrderTreatment multipleOrderTreatment = new MultipleOrderTreatment(orders);

        orders.forEach(order -> {
            System.out.println(office.printStatus(office.processes(multipleOrderTreatment), order));
        });

        multipleOrderTreatment.calculatePackageQuantity();
        System.out.println("\nPACKAGE QUANTITY : " + multipleOrderTreatment.getPackageQuantity());
        multipleOrderTreatment.calculateTotalWeight();
        System.out.println("TOTAL WEIGHT : " + multipleOrderTreatment.getTotalWeight());

    }
}
