//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * The interface which NodeList, NodeListOptional, and NodeSequence
 * implement.
 */
public interface NodeListInterface extends Node {
   public void addNode(Node n);
   public Node elementAt(int i);
   public java.util.Enumeration<Node> elements();
   public int size();

   public void accept(visitor.Visitor v);
   public <Rclass1,A> Rclass1 accept(visitor.GJVisitor<Rclass1,A> v, A argu);
   public <Rclass1> Rclass1 accept(visitor.GJNoArguVisitor<Rclass1> v);
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu);
}

