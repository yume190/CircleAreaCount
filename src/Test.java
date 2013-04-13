//import java.util.ArrayList;

public class Test {
	public static void main (String[] args)  {
		AreaCount AC = new AreaCount(10,10,0.5);
		AC.addCircle(4, 4, 3);
		//AC.show();
		AC.addCircle(5, 4, 3);
		AC.show();
		
		System.out.println("The coverage rate :" + AC.getCoverageRate());
		System.out.println("The coverage :" + AC.getCoverageAmount());
		for(int a = 0;a < AC.getCoverageAmountDetail().length;a++){
			System.out.println("The coverage [" + a + "] : " + AC.getCoverageAmountDetail()[a]);
		}
		
		//AC.flush();
		//AC.show();
	}  
}