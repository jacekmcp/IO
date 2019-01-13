package pl.put.poznan.networkanalyzer.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.model.Node;
import pl.put.poznan.networkanalyzer.model.Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class NetAnalServiceTest {

    private static final String TYP = "EXAMPLE_TYPE";
    private static final String NAME = "EXAMPLE_NAME";

    @Mock
    public NodeService nodeService;

    @Mock
    public ConnectionService connectionService;

    private NetAnalService netAnalService;

    private ArrayList<Node> nodeList = new ArrayList<>();
    private ArrayList<Connection> connectionList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        connectionList.add(new Connection(1,2,10));
        connectionList.add(new Connection(1,3,10));
        connectionList.add(new Connection(1,4,10));
        connectionList.add(new Connection(3,5,10));
        connectionList.add(new Connection(4,5,10));

        Mockito.when(connectionService.getAllConnections())
                .thenReturn(this.connectionList);

        for (int i = 0; i < 5; i++) {
            nodeList.add(new Node(i+1,TYP,NAME,new ArrayList<>(),new ArrayList<>()));
        }

        for (int i = 0; i < 5; i++) {
            setIO(connectionList.get(i));
        }

        Mockito.when(nodeService.getAllNodes())
                .thenReturn(nodeList);

        netAnalService = new NetAnalService(connectionService,nodeService);
    }

    @Test
    public void bfsTest_bfsType() {
        Mockito.when(connectionService.getConnectionByNodes(Matchers.anyInt(),Matchers.anyInt())).thenReturn(
                new Connection(1,1,-1)
        );
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(1),Matchers.eq(2))).thenReturn(connectionList.get(0));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(1),Matchers.eq(3))).thenReturn(connectionList.get(1));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(1),Matchers.eq(4))).thenReturn(connectionList.get(2));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(3),Matchers.eq(5))).thenReturn(connectionList.get(3));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(4),Matchers.eq(5))).thenReturn(connectionList.get(4));

        Mockito.when(nodeService.getOneNode(Mockito.anyInt())).thenAnswer(invocationOnMock -> this.nodeList.get((Integer) invocationOnMock.getArguments()[0]-1));

        ArrayList<Integer> givenPath = netAnalService.BFSPath(1,5,"BFS");
        ArrayList<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(5);
        expectedPath.add(4);
        expectedPath.add(1);

        assertEquals(expectedPath,givenPath);
    }

    @Test
    public void dfsTest_dfsType() {
        Mockito.when(connectionService.getConnectionByNodes(Matchers.anyInt(),Matchers.anyInt())).thenReturn(
                new Connection(1,1,-1)
        );
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(1),Matchers.eq(2))).thenReturn(connectionList.get(0));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(1),Matchers.eq(3))).thenReturn(connectionList.get(1));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(1),Matchers.eq(4))).thenReturn(connectionList.get(2));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(3),Matchers.eq(5))).thenReturn(connectionList.get(3));
        Mockito.when(connectionService.getConnectionByNodes(Matchers.eq(4),Matchers.eq(5))).thenReturn(connectionList.get(4));

        Mockito.when(nodeService.getOneNode(Mockito.anyInt())).thenAnswer(invocationOnMock -> this.nodeList.get((Integer) invocationOnMock.getArguments()[0]-1));

        ArrayList<Integer> givenPath = netAnalService.BFSPath(1,5,"DFS");
        ArrayList<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(5);
        expectedPath.add(4);
        expectedPath.add(1);

        assertEquals(expectedPath,givenPath);
    }

    private void setIO(Connection connection) {
        Integer outNode = connection.getFrom();
        Integer inNode = connection.getTo();

        for (Node node: nodeList) {
            if(node.getId().equals(outNode)){
                node.addOutgoing(connection.getTo());
            }else if(node.getId().equals(inNode)){
                node.addIncoming(connection.getFrom());
            }
        }
    }
}

