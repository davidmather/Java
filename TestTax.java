
class TestTax
{
public static void main(String[] args){
	Tax t=new Tax();
	t.grossIncome=500000;
	t.dependents=2;
	t.state="NJ";
	double yourTax=t.calcTax();
System.out.print("Your tax is "+yourTax);

}
}