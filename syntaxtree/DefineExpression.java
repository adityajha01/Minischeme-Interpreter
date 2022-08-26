//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> "("
 * f1 -> "define"
 * f2 -> Identifier()
 * f3 -> Expression()
 * f4 -> ")"
 */
public class DefineExpression implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public Identifier f2;
   public Expression f3;
   public NodeToken f4;

   public DefineExpression(NodeToken n0, NodeToken n1, Identifier n2, Expression n3, NodeToken n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public DefineExpression(Identifier n0, Expression n1) {
      f0 = new NodeToken("(");
      f1 = new NodeToken("define");
      f2 = n0;
      f3 = n1;
      f4 = new NodeToken(")");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <Rclass1,A> Rclass1 accept(visitor.GJVisitor<Rclass1,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <Rclass1> Rclass1 accept(visitor.GJNoArguVisitor<Rclass1> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

