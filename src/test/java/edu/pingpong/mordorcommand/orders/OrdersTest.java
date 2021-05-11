package edu.pingpong.mordorcommand.orders;


import edu.pingpong.mordorcommand.interfaces.Order;
import edu.pingpong.mordorcommand.interfaces.OrderTreatment;
import edu.pingpong.mordorcommand.interfaces.Processor;
import edu.pingpong.mordorcommand.orders.InternationalOrder;
import edu.pingpong.mordorcommand.processors.Office;
import edu.pingpong.mordorcommand.treatments.DangerousOrderTreatment;
import edu.pingpong.mordorcommand.treatments.InternationalOrderTreatment;
import edu.pingpong.mordorcommand.treatments.MultipleOrderTreatment;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * NO PUEDES MODIFICAR EL CODIGO DE LOS CASOS TEST 
 */
public class OrdersTest {

    /**
     * Crea una clase TratamientoPedidoInternacional que permita tratar
     * pedidos internacionales.
     * 
     * La clase permite tratar todos los pedidos excepto 
     * los que van a Mordor.
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
     */
    @Test
	public void mordorTest() {

        Order internationalOrder = new InternationalOrder("Mordor", 100);
        assertEquals("Mordor", internationalOrder.getDestination());

		OrderTreatment treatmentKO = new InternationalOrderTreatment(
                                                    (InternationalOrder) internationalOrder);
        assertNotNull(treatmentKO);
        assertFalse(treatmentKO.treat());
	}

	@Test
	public void comarcaTest() {

        Order internationalOrder = new InternationalOrder("Comarca", 100);
        assertEquals("Comarca", internationalOrder.getDestination());

		OrderTreatment treatmentOK = new InternationalOrderTreatment(
                                                    (InternationalOrder) internationalOrder);
        assertNotNull(treatmentOK);
        assertTrue(treatmentOK.treat());
    }

    /**
     * Crea una clase TratamientoPedidoPeligroso que permita tratar
     * pedidos peligrosos.
     * 
     * La clase permite tratar todos los pedidos segun sus
     * instrucciones excepto aquellos cuya instruccion sea 
     * "No ponerselo en el dedo". 
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
     */
    @Test
    public void dangerousOrderTreatmentKO() {

        Order dangerousOrder = new DangerousOrder("Monte del destino",
                                                           "No ponerselo en el dedo");
        assertEquals("Monte del destino", dangerousOrder.getDestination());

        OrderTreatment treatmentKO = new DangerousOrderTreatment(
                                                    (DangerousOrder) dangerousOrder);
        assertNotNull(treatmentKO);
        assertFalse(treatmentKO.treat());
    }

    @Test
    public void dangerousOrderTreatmentOK() {

        Order dangerousOrder = new DangerousOrder("Cima de los vientos",
                                                           "No urgarse en las uñas con este puñal");
        assertEquals("Cima de los vientos", dangerousOrder.getDestination());

        OrderTreatment treatmentOK = new DangerousOrderTreatment(
                                                    (DangerousOrder) dangerousOrder);
        assertTrue(treatmentOK.treat());
    }

    /**
     * Añade a las clases PedidoInternacional y PedidoPeligrosoOrden
     * una identificador Id de tipo String
     * autogenerado haciendo uso de la clase UUID de Java
     * https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html
    */

    @Test
    public void UUIDGeneratorTest() {

        InternationalOrder internationalOrder = new InternationalOrder("Mordor", 10);
        DangerousOrder dangerousOrder = new DangerousOrder("Cima de los vientos",
                                                                  "No urgarse en las uñas con este puñal");
        assertNotNull(internationalOrder.getId());
        assertNotNull(dangerousOrder.getId());
       
        assertNotEquals(internationalOrder.getId(), dangerousOrder.getId());
    }

    /**
     * Añade una clase para los pedidos nacionales.
     */

    @Test
    public void NationalOrderTest() {

        InternationalOrder internationalOrder = new InternationalOrder("Mordor", 10);
        assertNotNull(internationalOrder);
        NationalOrder nationalOrder = new NationalOrder("Gondor", 50);
        assertNotNull(nationalOrder);
        assertNotEquals(internationalOrder.getId(), nationalOrder.getId());
    }
    
    /**
     * Construye una oficina que procese todo tipo de pedidos.
     * 
     * La oficina procesa los pedidos en funcion de si
     * es posible tratarlos o no segun las reglas de cada
     * tipo de pedido
     */

    @Test
    public void ProcessorTest() {
        
        Processor correos = new Office();
        OrderTreatment internationalOrderTreatment = new InternationalOrderTreatment(
                                            new InternationalOrder("Comarca", 100));
        assertTrue(correos.processes(internationalOrderTreatment));

        OrderTreatment dangerousOrderTreatment = new DangerousOrderTreatment(
                                                 new DangerousOrder("Cima de los vientos",
                                                "No urgarse en las uñas con este puñal"));
        assertTrue(correos.processes(dangerousOrderTreatment));
    }

    /**
     * La oficina puede enviar un mensaje que informe del
     * status del pedido, en funcion de si ha sido posible procesarlo.
     * 
     * Hace uso de un tipo enumerado STATUS con las constantes
     * ACEPTADO y RECHAZADO.
     */

    @Test
    public void PrintStatusTest() {

        Office correos = new Office();
        InternationalOrder toComarcaWithLove = new InternationalOrder("Comarca", 100);
        OrderTreatment internationalOrderTreatment = new InternationalOrderTreatment(toComarcaWithLove);

        assertTrue(correos.processes(internationalOrderTreatment));
        assertEquals("Comarca ACCEPTED", correos.printStatus(
                                            correos.processes(internationalOrderTreatment), toComarcaWithLove));

        DangerousOrder dangerousOrder = new DangerousOrder("Monte del destino",
                                                                    "No ponerselo en el dedo");

        OrderTreatment treatmentKO = new DangerousOrderTreatment(dangerousOrder);

        assertFalse(correos.processes(treatmentKO));
        assertEquals("Monte del destino REJECTED", correos.printStatus(
                                                        correos.processes(treatmentKO), dangerousOrder));

    }

    /**
     * Crea una clase TratamientoPedidoMultiple que permita tratar
     * pedidos multiples.
     * 
     * La clase permite tratar el pedido multiple si 
     * el peso total de los pedidos es mayor que 0
     * y 
     * el numero de bultos coincide con el numero de
     * pedidos individuales que forman el pedido multiple.
     * 
     * Crea las clases necesarias que se requieren en los casos test
     * respetando los constructores que se exigen.
    */

    @Test
    public void MultipleOrderTreatmentTest() {

        /**
         * Crea una colección de tres pedidos nacionales, a "Gondor", "Minas Tirith", "Rohan"
         * con un peso de 10 cada uno.
         * 
         * Pasasela a TratamientoPedidosMultiple en su constructor.
        */

        Set<Order> orders = new HashSet<>();
        List<String> destinations = Arrays.asList("Gondor", "Minas Tirith", "Rohan");
        List<Integer> weights = Arrays.asList(10, 10, 10);
        
        for (int i=0; i<destinations.size(); i++) {
            orders.add(new NationalOrder(destinations.get(i), weights.get(i)));
        }
        assertEquals(3, orders.size());

        MultipleOrderTreatment multipleOrderTreatment = new MultipleOrderTreatment(orders);
        assertNotNull(multipleOrderTreatment);

        /**
         * Completa los metodos del pedido multiple.
         * Se valorara el uso de streams.
         * 
         * calcularTotalBultos
         * @param   void
         * @return  void
         *   
         * calcularPesoTotal
         * @param   void
         * @return  void
         * 
        */

        multipleOrderTreatment.calculatePackageQuantity();
        assertEquals(3, multipleOrderTreatment.getPackageQuantity(), 0);

        multipleOrderTreatment.calculateTotalWeight();
        assertEquals(30, multipleOrderTreatment.getTotalWeight(), 0);

        /**
         * Trata el pedido multiple.
        */

        assertTrue(multipleOrderTreatment.treat());

    }
}