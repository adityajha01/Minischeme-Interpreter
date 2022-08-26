package visitor;

public class Rclass1 {
	String str1;
	int integer1;
	boolean b1;
	String categ; //Data type category
	public ProcClass  pc =new ProcClass ();
	public void setInteger1(int integer1) {
		this.integer1 = integer1;
	}
	public int getInteger1() {
		return integer1;
	}
	public void setB1(boolean b1) {
		this.b1 = b1;
	}
	public boolean getB1() {
		return b1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	public String getStr1() {
		return str1;
	}
	public void setCateg(String categ) {
		this.categ = categ;
	}
	public String getCateg() {
		return categ;
	}
	public ProcClass getPc() {
		return pc;
	}
	public void setPc(ProcClass pc) {
		this.pc = pc;
	}
}
