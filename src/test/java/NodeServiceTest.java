import pl.put.poznan.networkanalyzer.model.Connection;
import pl.put.poznan.networkanalyzer.model.Node;
import org.junit.Test;
import pl.put.poznan.networkanalyzer.service.NodeService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Testing class for NodeService class
 * @author  Michal Kukiela
 */
public class NodeServiceTest {

    @Test
    public void testGetAllNodes() {
        NodeService ns = new NodeService();
        assertEquals(0,ns.getAllNodes().size());
    }

    @Test
    public void testGetOneNode() {
        NodeService ns = new NodeService();
        ArrayList<Integer> out = new ArrayList<>(Arrays.asList(1,2,3)); //Arrays.asList();
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(4,5));
        int id = 10;
        Node n = new Node(id,"name","regular",out,in);
        ns.addNode(n);
        assertSame(n,ns.getOneNode(id));
    }

    @Test
    public void testAddNode() {
        NodeService ns = new NodeService();
        ns.addNode(new Node(1,"name1","entry"));
        ns.addNode(new Node(2,"name2","regular"));
        ns.addNode(new Node(3,"name3","exit"));
        assertEquals(3,ns.getAllNodes().size());
    }

    @Test
    public void TestUpdateNode() {
        NodeService ns = new NodeService();
        int id = 10;
        String name = "nameUpdated";
        String type = "entry";
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3)); //Arrays.asList();
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(4,5));

        Node n = new Node(id,"name","regular",l2,l1);
        ns.addNode(n);

        Node newNode = new Node(id,name,type,l1,l2);

        ns.updateNode(id,newNode);
        assertEquals(name,ns.getOneNode(id).getName());
        assertEquals(type,ns.getOneNode(id).getType());
        assertSame(l1,ns.getOneNode(id).getOutgoing());
        assertSame(l2,ns.getOneNode(id).getIncoming());
    }

    @Test
    public void testDeleteNode() {
        NodeService ns = new NodeService();
        int id = 10;
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,3)); //Arrays.asList();
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(4,5));
        Node n = new Node(id,"name","regular",l1,l2);
        ns.addNode(n);

        ns.deleteNode(id);
        assertNull(ns.getOneNode(id));
    }

//    @Test
//    public void setIO() {
//        NodeService ns = new NodeService();
//        ns.addNode(new Node(1,"name1","regular"));
//        ns.addNode(new Node(2,"name2","regular"));
//
//        Connection con = new Connection(1,2,3);
//        con.setConnectionIndex(5);
//
////        System.out.println(con.getConnectionIndex());
////        for (Node n: ns.getAllNodes()) {
////            System.out.println(n.getId());
////        }
//
//        ns.setIO(con);//nie działa ;__;
//
//        Node n1 = ns.getOneNode(1);
//        Node n2 = ns.getOneNode(2);
//
//        assertTrue(n1.getOutgoing().contains(5));//czy n1 ma w liscie outgoing connection 5
//        assertTrue(n2.getIncoming().contains(5));//czy n2 ma w liscie incoming connection 5
//    }

}