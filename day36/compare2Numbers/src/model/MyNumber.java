package model;

public class MyNumber {
    private int n1;
	private int n2;
    public MyNumber(int n1,int n2) {
    	this.n1=n1;
    	this.n2=n2;
    }
	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}
    public String compare() {
    	if(n1>n2)
    		return String.format("n1=%d >  n2=%d %n",n1,n2);
    	else if(n1<n2)
    		return String.format("n1=%d <  n2=%d %n",n1,n2);
    	else
    		return String.format("n1=%d ==  n2=%d %n",n1,n2);
    }
}
