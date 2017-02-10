package spring.di.exam2;

public class Calc {
	int n1, n2, result;
	public Calc(int n1, int n2){
		this.n1 = n1;
		this.n2 = n2;
	}
	public void sum(){
		result = this.n1 + this.n2;
	}
	public void display(){
		System.out.printf("%d + %d = %d\n",this.n1, this.n2, this.result);
	}
}
