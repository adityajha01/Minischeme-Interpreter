//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst implements GJVisitor<Rclass1,EnvironmentClass> {
	 //
	   // Auto class visitors--probably don't need to be overridden.
	   //
		

	   public Rclass1 visit(NodeList n, EnvironmentClass argu) {
	      Rclass1 _ret=null;
	      int _count=0;
	      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	         e.nextElement().accept(this, argu);
	         _count++;
	      }
	      return _ret;
	   }

	   public Rclass1 visit(NodeListOptional n, EnvironmentClass argu) {
	      if ( n.present() ) {
	         Rclass1 _ret=null;
	         int _count=0;
	         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	            e.nextElement().accept(this, argu);
	            _count++;
	         }
	         return _ret;
	      }
	      else
	         return null;
	   }

	   public Rclass1 visit(NodeOptional n, EnvironmentClass argu) {
	      if ( n.present() )
	         return (Rclass1)n.node.accept(this, argu);
	      else
	         return null;
	   }

	   public Rclass1 visit(NodeSequence n, EnvironmentClass argu) {
	      Rclass1 _ret=null;
	      int _count=0;
	      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
	         e.nextElement().accept(this, argu);
	         _count++;
	      }
	      return _ret;
	   }

	   public Rclass1 visit(NodeToken n, EnvironmentClass argu) { return null; }

	   //
	   // User-generated visitor methods below
	   //

	   /**
	    * f0 -> ( Line() )*
	    * f1 -> <EOF>
	    */
	   public Rclass1 visit(Goal n, EnvironmentClass argu) {
	      Rclass1 _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> Expression()
	    */
	   public Rclass1 visit(Line n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      _ret=(Rclass1)n.f0.accept(this, argu);
	      if(_ret==null) {
	    	  return null;
	      }
	      if(_ret.getCateg()=="int")
	      {
	    	  System.out.println(_ret.getInteger1());
	      }
	      else if(_ret.getCateg()=="bool")
	      {
	    	  if(_ret.getB1()==true)
	    		  System.out.println("#t");
	    	  else
	    		  System.out.println("#f");
	    		  
	      }
	      else if(_ret.getCateg()=="idfr")
	      {
	    	  //System.out.println(_ret.getInteger1());
	    	  String s1 = _ret.getStr1();
	    	  if(argu.h1.get(s1) == null)
	    	  {
	    		  System.out.println("Symbol \'"+ s1 + "\' not found in the environment.");
	    	  }
	    	  else
	    		  System.out.println(argu.h1.get(s1).getInteger1());
	      }
	      else
	      {
	    	  return null;
	      }
	     
	      return _ret;
	   }

	   /**
	    * f0 -> IntegerLiteral()
	    *       | TrueLiteral()
	    *       | FalseLiteral()
	    *       | Identifier()
	    *       | BeginExpression()
	    *       | PlusExpression()
	    *       | MinusExpression()
	    *       | MultiplyExpression()
	    *       | DivideExpression()
	    *       | GTExpression()
	    *       | LTExpression()
	    *       | EQExpression()
	    *       | IfExpression()
	    *       | DefineExpression()
	    *       | Assignment()
	    *       | ProcedureExp()
	    *       | Application()
	    */
	   public Rclass1 visit(Expression n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      _ret=(Rclass1)n.f0.accept(this, argu);
	      //System.out.println(_ret.integer1);
	      return _ret;
	   }

	   /**
	    * f0 -> <INTEGER_LITERAL>
	    */
	   public Rclass1 visit(IntegerLiteral n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      n.f0.accept(this, argu);
	      
	      _ret.setInteger1(Integer.parseInt(n.f0.tokenImage));
	      String type1="int";
	      _ret.setCateg(type1);
	      return _ret;
	   }

	   /**
	    * f0 -> "#t"
	    */
	   public Rclass1 visit(TrueLiteral n, EnvironmentClass argu) {
		  Rclass1 _ret=new Rclass1();
		  n.f0.accept(this, argu);
	      String s1=n.f0.tokenImage;
	      if((s1=="#t")||(s1=="#true")) {
	    	  _ret.setB1(true);
	    	  String type1="bool";
	          _ret.setCateg(type1);
	      }
	      else
	      {
	    	  System.out.println("read-syntax: bad syntax "+s1);
	    	  System.exit(0);
	      }
	      return _ret;
	   }

	   /**
	    * f0 -> "#f"
	    */
	   public Rclass1 visit(FalseLiteral n, EnvironmentClass argu) {
		  Rclass1 _ret=new Rclass1();
		  n.f0.accept(this, argu);
	      String s1=n.f0.tokenImage;
	      if((s1=="#f")||(s1=="#false")) 
	      {
	    	  _ret.setB1(false);
	    	  String type1="bool";
	          _ret.setCateg(type1);
	      }
	      else
	      {
	    	  System.out.println("read-syntax: bad syntax "+s1);
	    	  System.exit(0);
	      }
	    	 
	      
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "begin"
	    * f2 -> ( Expression() )*
	    * f3 -> ")"
	    */
	   public Rclass1 visit(BeginExpression n, EnvironmentClass argu) {
	      Rclass1 _ret=null;
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      n.f3.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "+"
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(PlusExpression n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      int num1=0;
	      int num2=0;
	      
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      _ret=(Rclass1)n.f2.accept(this, argu);
	      if(_ret.getCateg() == "bool")
	      {
	    	  System.out.println("Expected number, can't be boolean");
	    	  System.exit(0);
	      }
	      else if(_ret.getCateg()=="int")
	      {
	    	  num1=_ret.getInteger1();
	      }
	      else              
	      {
	    	  String s1 = _ret.getStr1();
	    	  if(argu.h1.containsKey(s1))
	    	  {
	    		  if(argu.h1.get(s1).getCateg()=="int")
	    			  num1=argu.h1.get(s1).getInteger1();
	    		  if(argu.h1.get(s1).getCateg()=="bool")
	    		  {
	    			  System.out.println("Expected number, can't be boolean");
	    	    	  System.exit(0);
	    		  }
	    	  }
	    	  else 
	    		  return _ret;
	    	  
	      }
	      
	      _ret=(Rclass1)n.f3.accept(this, argu);
	      if(_ret.getCateg() == "bool")
	      {
	    	  System.out.println("Expected number, can't be boolean");
	    	  System.exit(0);
	      }
	      else if(_ret.getCateg()=="int")
	      {
	    	  num2=_ret.getInteger1();
	      }
	      else
	      {
	    	  String s1 = _ret.getStr1();
	    	  if(argu.h1.containsKey(s1))
	    	  {
	    		  if(argu.h1.get(s1).getCateg()=="int")
	    			  num2=argu.h1.get(s1).getInteger1();
	    		  if(argu.h1.get(s1).getCateg()=="bool")
	    		  {
	    			  System.out.println("Expected number, can't be boolean");
	    	    	  System.exit(0);
	    		  }
	    	  }
	    	  else 
	    		  return _ret;
	      }
	      int res=(num1+num2);
	      _ret.setInteger1(res);
	      _ret.setCateg("int");
	      
	     
	      n.f4.accept(this, argu);
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "-"
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(MinusExpression n, EnvironmentClass argu) {
		   Rclass1 _ret=new Rclass1();
		      int num1=0;
		      int num2=0;
		      
		      n.f0.accept(this, argu);
		      n.f1.accept(this, argu);
		      _ret=(Rclass1)n.f2.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num1=_ret.getInteger1();
		      }
		      else              
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num1=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		    	  
		      }
		      
		      _ret=(Rclass1)n.f3.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num2=_ret.getInteger1();
		      }
		      else
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num2=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		      }
		      int res=(num1-num2);
		      _ret.setInteger1(res);
		      _ret.setCateg("int");
		      
		     
		      n.f4.accept(this, argu);
		      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "*"
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(MultiplyExpression n, EnvironmentClass argu) {
		   Rclass1 _ret=new Rclass1();
		      int num1=0;
		      int num2=0;
		      
		      n.f0.accept(this, argu);
		      n.f1.accept(this, argu);
		      _ret=(Rclass1)n.f2.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num1=_ret.getInteger1();
		      }
		      else              
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num1=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		    	  
		      }
		      
		      _ret=(Rclass1)n.f3.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num2=_ret.getInteger1();
		      }
		      else
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num2=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		      }
		      int res=(num1*num2);
		      _ret.setInteger1(res);
		      _ret.setCateg("int");
		      
		      
		      n.f4.accept(this, argu);
		      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "/"
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(DivideExpression n, EnvironmentClass argu) {
		   Rclass1 _ret=new Rclass1();
		      int num1=0;
		      int num2=0;
		      
		      n.f0.accept(this, argu);
		      n.f1.accept(this, argu);
		      _ret=(Rclass1)n.f2.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num1=_ret.getInteger1();
		      }
		      else              
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num1=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		    	  
		      }
		      
		      _ret=(Rclass1)n.f3.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num2=_ret.getInteger1();
		      }
		      else
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num2=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		      }
		      if(num2!=0)
		      {
		    	  int res=(num1/num2);
			      _ret.setInteger1(res);
			      _ret.setCateg("int");
		      }
		      else 
		      {
		    	  System.out.println("/: division by zero");
		    	  System.exit(0);
		    	  
		      }  
		      n.f4.accept(this, argu);
		      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> ">"
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(GTExpression n, EnvironmentClass argu) {
		   Rclass1 _ret=new Rclass1();
		      int num1=0;
		      int num2=0;
		      
		      n.f0.accept(this, argu);
		      n.f1.accept(this, argu);
		      _ret=(Rclass1)n.f2.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num1=_ret.getInteger1();
		      }
		      else              // identifier
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num1=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		    	  
		      }
		      
		      _ret=(Rclass1)n.f3.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num2=_ret.getInteger1();
		      }
		      else
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num2=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		      }
		      if(num1>num2)
		      {
			     
			      _ret.setB1(true);
		    	  String type1="bool";
		          _ret.setCateg(type1);
		      }
		      else
		      {
		    	  
			      _ret.setB1(false);
		    	  String type1="bool";
		          _ret.setCateg(type1);
		      }
		      
		      n.f4.accept(this, argu);
		      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "<"
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(LTExpression n, EnvironmentClass argu) {
		   Rclass1 _ret=new Rclass1();
		      int num1=0;
		      int num2=0;
		      
		      n.f0.accept(this, argu);
		      n.f1.accept(this, argu);
		      _ret=(Rclass1)n.f2.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num1=_ret.getInteger1();
		      }
		      else              // identifier
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num1=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		    	  
		      }
		      
		      _ret=(Rclass1)n.f3.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num2=_ret.getInteger1();
		      }
		      else
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num2=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		      }
		      if(num1<num2)
		      {
			     
			      _ret.setB1(true);
		    	  String type1="bool";
		          _ret.setCateg(type1);
		      }
		      else
		      {
		    	  
			      _ret.setB1(false);
		    	  String type1="bool";
		          _ret.setCateg(type1);
		      }
		      
		      n.f4.accept(this, argu);
		      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "="
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(EQExpression n, EnvironmentClass argu) {
		   Rclass1 _ret=new Rclass1();
		      int num1=0;
		      int num2=0;
		      
		      n.f0.accept(this, argu);
		      n.f1.accept(this, argu);
		      _ret=(Rclass1)n.f2.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num1=_ret.getInteger1();
		      }
		      else           
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num1=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		    	  
		      }
		      
		      _ret=(Rclass1)n.f3.accept(this, argu);
		      if(_ret.getCateg() == "bool")
		      {
		    	  System.out.println("Expected number, can't be boolean");
		    	  System.exit(0);
		      }
		      else if(_ret.getCateg()=="int")
		      {
		    	  num2=_ret.getInteger1();
		      }
		      else
		      {
		    	  String s1 = _ret.getStr1();
		    	  if(argu.h1.containsKey(s1))
		    	  {
		    		  if(argu.h1.get(s1).getCateg()=="int")
		    			  num2=argu.h1.get(s1).getInteger1();
		    		  if(argu.h1.get(s1).getCateg()=="bool")
		    		  {
		    			  System.out.println("Expected number, can't be boolean");
		    	    	  System.exit(0);
		    		  }
		    	  }
		    	  else 
		    		  return _ret;
		      }
		      if(num1==num2)
		      {
			    
			      _ret.setB1(true);
		    	  String type1="bool";
		          _ret.setCateg(type1);
		      }
		      else
		      {
		    	  
			      _ret.setB1(false);
		    	  String type1="bool";
		          _ret.setCateg(type1);
		      }
		      
		      n.f4.accept(this, argu);
		      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "if"
	    * f2 -> Expression()
	    * f3 -> Expression()
	    * f4 -> Expression()
	    * f5 -> ")"
	    */
	   public Rclass1 visit(IfExpression n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      n.f0.accept(this, argu); // 
	      n.f1.accept(this, argu); //  
	      boolean cond;
	      _ret=(Rclass1)n.f2.accept(this, argu);
	
	      if(_ret.getCateg()=="bool")
	      {
	    	  cond=_ret.getB1();
	    	  if(cond==true) {
	        	  _ret=(Rclass1)n.f3.accept(this, argu);
	        	  n.f5.accept(this, argu);
	        	  
	              
	          }
	          else
	          {
	        	  _ret=(Rclass1)n.f4.accept(this, argu);
	        	  n.f5.accept(this, argu);
	        	  
	          }
	      }
	      
	      return _ret;
	      
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "define"
	    * f2 -> Identifier()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(DefineExpression n, EnvironmentClass argu) {
		  String key;
	      Rclass1 _ret=new Rclass1();
	      
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      _ret=(Rclass1)n.f2.accept(this, argu);
	      key=_ret.getStr1();
	      _ret=(Rclass1)n.f3.accept(this, argu);
	      if(!argu.h1.containsKey(key))
	       argu.h1.put(key, _ret);
	      else
	      {
	    	  System.out.println("identifier "+key+" already defined!");
	    	  System.exit(0);
	      }
	    	  
	  
	      n.f4.accept(this, argu);
	      
	      return null;
	   }

	   /**
	    * f0 -> <IDENTIFIER>
	    */
	   public Rclass1 visit(Identifier n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      n.f0.accept(this, argu);
	      _ret.setStr1(n.f0.tokenImage);
	      _ret.setCateg("idfr");
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "set!"
	    * f2 -> Identifier()
	    * f3 -> Expression()
	    * f4 -> ")"
	    */
	   public Rclass1 visit(Assignment n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      _ret=n.f2.accept(this, argu);
	      String id=_ret.getStr1();
	      _ret=n.f3.accept(this, argu);
	      if(argu.h1.containsKey(id))
	      {
	    	  argu.h1.put(id,_ret);
	      }
	      else
	      {
	    	  System.out.println("SET! assignment disallowed \ncannot set variable before its definition\n" + 
		    	  		"  variable:"+ id);
	    	  System.exit(0);
	      }
	      
	      n.f4.accept(this, argu);
	      return null;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> "lambda"
	    * f2 -> "("
	    * f3 -> ( Identifier() )* (lambda ( x )(+ x 4))
	    * f4 -> ")"
	    * f5 -> Expression()
	    * f6 -> ")"
	    */
	   public Rclass1 visit(ProcedureExp n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      n.f2.accept(this, argu);
	      
	      ProcClass p =new ProcClass();
	      n.f3.accept(this, argu);
	      int i;
	      for(i=0;i < n.f3.size();i++) {
	    	  p.funp.add(((Identifier)n.f3.nodes.get(i)).f0.tokenImage);
	      }
	      n.f4.accept(this,argu);
	      p.funb = n.f5;
//      _ret = n.f5.accept(this,argu);
	      _ret.setPc(p);
	      _ret.setCateg("proc");
	      
	      //_ret.setType("Procedure");
	      //n.f6.accept(this
	      return _ret;
	   }

	   /**
	    * f0 -> "("
	    * f1 -> Expression()
	    * f2 -> ( Expression() )*
	    * f3 -> ")"
	    */
	   public Rclass1 visit(Application n, EnvironmentClass argu) {
	      Rclass1 _ret=new Rclass1();
	      EnvironmentClass ev=new EnvironmentClass();
	      ev.h1.putAll(argu.h1);
	      
	      n.f0.accept(this, argu);
	      n.f1.accept(this, argu);
	      String func=n.f1.accept(this,argu).getStr1();
	      _ret=argu.h1.get(func);
	      if(argu.h1.containsKey(func))
	      {
	    	  if(_ret.getPc().funp.size()>n.f2.nodes.size())
	    	  {
	    		  System.out.println("Number of supplied arguments to procedure \'"+ func + "\' is less than expected.");
	    		  System.exit(0);
	    	  }
	    	  if(_ret.getPc().funp.size()<n.f2.nodes.size())
	    	  {
	    		  System.out.println("Number of supplied arguments to procedure \'"+ func + "\' is more than expected.");
	    		  System.exit(0);
	    	  }
	    	  for(int i=0;i<n.f2.nodes.size();i++) {
	    		  Rclass1 rc=new Rclass1();
		    	  int ival = n.f2.nodes.get(i).accept(this,argu).getInteger1();
		    	  String k1 = _ret.getPc().funp.get(i);
		    	  rc.setStr1(k1);
		    	  rc.setInteger1(ival);
		    	  rc.setCateg("proc");
		    	 //set categ
		    	  ev.h1.put(k1, rc);
//		    	  System.out.println(key + " " + value);
	    	  }
//	    	  for(int i=0;i<argu.map.size();i++)
//	    	  {
//	    		  System.out.println(argu.map.get(i));
//	    	  }
	    	  _ret.getPc().funb.accept(this, ev);
	    	  System.out.println(_ret.integer1);
	    	  n.f2.accept(this,ev);
	    	  n.f3.accept(this,ev);
	      }
	      
	  
	      return _ret;
	   }

}
