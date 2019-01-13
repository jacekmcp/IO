import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.service.ConnectionService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ConnectionServiceTest {

    ConnectionService service =  null;
    Connection testConnection = null;
    @Mock Connection mockConnection;
    @Before
    public void setUptest() throws Exception{
        MockitoAnnotations.initMocks(this);
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
        Integer index = 0;
        service.addConnection(c1); // addConnection automaticaly add next connection number()
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

    //MOCKITO

    @Test
    public void connectionServiceGetConnectionTest(){
        when(mockConnection.getFrom()).thenReturn(1);
        when(mockConnection.getTo()).thenReturn(2);
        when(mockConnection.getConnectionIndex()).thenReturn(5);
        service.addConnection(mockConnection);
        assertTrue(service.getConnection(5).equals(mockConnection));
    }
    @Test
    public void connectionServiceAddConnectionTest() {
        when(mockConnection.getFrom()).thenReturn(1);
        when(mockConnection.getTo()).thenReturn(2);
        when(mockConnection.getConnectionIndex()).thenReturn(123);
        service.addConnection(mockConnection);
        boolean isThere = false;
        for(Connection c : service.getAllConnections())
        {
            if(c.getConnectionIndex().equals(123)) isThere=true;
        }
        assertTrue(isThere);
    }
    @Test
    public void connectionServiceUpdateConnectionTest() {
        when(mockConnection.getConnectionIndex()).thenReturn(0);
        when(mockConnection.getFrom()).thenReturn(2);
        when(mockConnection.getTo()).thenReturn(3);
        when(mockConnection.getValue()).thenReturn(420);
        Connection connection = new Connection(7,8,9);
        service.addConnection(connection);
        service.updateConnection(0, mockConnection);
        int value = service.getConnection(0).getValue();
        assertEquals(value, 420);
    }
    @Test
    public void connectionServiceGetConnectionByNodesTest(){
        when(mockConnection.getFrom()).thenReturn(6);
        when(mockConnection.getTo()).thenReturn(9);
        service.addConnection(mockConnection);
        Connection con = service.getConnectionByNodes(6,9);
        assertSame(con, mockConnection);
    }

    @Test
    public void connectionServiceNotUniqueAddTest(){
        when(mockConnection.getFrom()).thenReturn(1);
        when(mockConnection.getTo()).thenReturn(2);
        when(mockConnection.getValue()).thenReturn(100);
        Connection mockTwo = mock(Connection.class);
        when(mockTwo.getFrom()).thenReturn(1);
        when(mockTwo.getTo()).thenReturn(2);
        when(mockTwo.getValue()).thenReturn(200);
        service.addConnection(mockConnection);
        service.addConnection(mockTwo);
        Connection c = service.getConnectionByNodes(1,2);
        assertSame(c, mockConnection);
    }
    @Test
    public void connectionServiceAddLoopbackConnectionTest() {
        when(mockConnection.getFrom()).thenReturn(1);
        when(mockConnection.getTo()).thenReturn(1);
        service.addConnection(mockConnection);
        assertNull(service.getConnection(0));
    }




}