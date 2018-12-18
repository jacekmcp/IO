import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.service.ConnectionService;

import static org.junit.Assert.*;





public class ConnectionServiceTest {

    ConnectionService service =  null;
    Connection testConnection = null;

    @Before
    public void setUptest() throws Exception{
        service = new ConnectionService();
    }

    @After
    public void resetTest(){
       service = null;
       testConnection.setIndexNumber(0); //ponieważ to statyczne pole indeksowane jest w connections, musimy
    }                                   //wyzerowac pole po każdej "sesji" service (zeby znowu było od 0, a jego wartosci "przewidywalne")

    @Test
    public void addConnectionAndDeleteConnectionTest(){
    //ConnectionService service = new ConnectionService();
    Connection c1 = new Connection(1,2,3);
    Connection c2 = new Connection(2, 3, 4);
    service.addConnection(c1);
    service.addConnection(c2);
    assertEquals(c1.getConnectionIndex(), (Integer)0);
    assertEquals(c2.getConnectionIndex(), (Integer)1);
    service.deleteConnection(1);
    assertNull(service.getConnection(1));
    }

    @Test
    public void getConnectionTest(){
        //ConnectionService service = new ConnectionService();
        Connection c1 = new Connection(1, 2, 5);
        for(int i =0; i<10; i++) {
            Connection c2 = new Connection(1, i, 5);
            service.addConnection(c2); //adding few connections(values not important);
        }
        service.addConnection(c1);
        System.out.println(c1.getConnectionIndex());
        assertNull(service.getConnection(13));
        assertEquals(c1.getValue(), service.getConnection(3).getValue());
    }

    @Test
    public void updateConnectionTest() {
      //  ConnectionService service = new ConnectionService();
        Connection c1 = new Connection(1, 2, 5);
        Integer index = 5;
        service.addConnection(c1); // addConnection automaticaly add next connection number()
        c1.setConnectionIndex(5);

        Connection c2 = new Connection(3, 2, 7);
        assertTrue(service.updateConnection(index, c2));
        assertEquals(java.util.Optional.ofNullable(service.getConnection(5).getValue()), java.util.Optional.of(7));
    }


    @Test
    public void updateConnectionTest2() {
       // ConnectionService service = new ConnectionService();
        Connection c1 = new Connection(1, 2, 5);
        Integer index = 1;
        service.addConnection(c1); // addConnection automaticaly add next connection number()
        service.addConnection(c1);

        Connection c2 = new Connection(3, 2, 7);
        assertTrue(service.updateConnection(index, c2));
    }

    @Test (expected = NullPointerException.class)
    public void connectionServiceGeneralTest(){
       // ConnectionService service = new ConnectionService();
        Connection c1 = new Connection(1,2,3);
        Connection c2 = new Connection(2,1,5);
        service.addConnection(c1);
        service.deleteConnection(0);
        service.addConnection(c2);
        service.deleteConnection(1);
        Integer idx = service.getConnection(1).getValue();
    }
}