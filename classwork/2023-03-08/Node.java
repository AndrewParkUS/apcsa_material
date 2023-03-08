public class Node {
  Node nodeB = pointer getNext();
  Node nodeE = new Node("e");
  
  nodeE.setNext(nodeB.getNext());
  nodeB.setNext(nodeE);
}
