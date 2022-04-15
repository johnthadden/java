/*Example Java problem for a Technical Support Engineer role.
Backstory was that there were two Crystals that could peform very detailed and accurate mathematical
feats and each were to be tested to see which was more accurate. Employer provided all of the methods
starting at the comment labeled "original code given for problem.

The solution uses threads as the emploer requested that two parallel instances would be run and they wanted 
to make sure that two separate instances would be used. The error of either calculator is randomized at the 
employer's request, as there code for the method 'addQuantumError' shows.*/

import java.util.Random; //only interface needed to compile

public class crystalComparer {

	public static void main (String[] args) {

            CrystalThread object = new CrystalThread();
            object.start(); //output

	}
}

public class CrystalThread extends Thread { //making sure instances run parallel as threads instead of consecutively
    public void run()
    {
        Crystal crystal1 = new Crystal(); //instance #1
        Crystal crystal2 = new Crystal(); //instance #2

		System.out.println(crystal1.Crystal("1"));
        System.out.println(crystal2.Crystal("2")); 
        System.out.println("Crystal 1 Success rate: " + crystal1.successRate());
        System.out.println("Crystal 2 Success rate: " + crystal2.successRate());

        if (crystal1.successRate() > crystal2.successRate()) {
			System.out.println("Crystal 1 is better.");
		}
		else if (crystal2.successRate() > crystal1.successRate()) {
			System.out.println("Crystal 2 is better.");
		}
		else {
			System.out.println("Both Crystal 1 and Crystal 2 are equally accurate.");			
		}
    }
}

public class Crystal{

    double crystalSuccessRate = 0.0;

    public String Crystal(String name) {
        Calculator Crystal = new Calculator("");
		Random rand = new Random(); 
        String blankSpace = "";

        System.out.println("Calculator Crystal " + name + ":");
		for (int i = 0; i < 20; i ++) { // produced 20 pairs since that's what you said in the instructions, although your example output only had 10 pairs per calculator. My apologies for any confusion
			double randomA = rand.nextDouble(0, 10);
			double randomB = rand.nextDouble(0, 10);
			double answer = Crystal.add(randomA, randomB);
			String result = "";

			if ((randomA + randomB) == answer){
				result = String.format("%10s", ("(correct)")); //formatting for each calculation
				crystalSuccessRate = crystalSuccessRate + 0.05;
			} else {
				result = String.format("%10s", ("(error)")); //formatting for each calculation
			}
            String algebraicString = String.format("%-62s", ("" + randomA + " + " + randomB + " = " + answer));
            System.out.print(algebraicString);
            System.out.println(result);
		}
        return blankSpace; //creating a linebreak inbetween calculators and the summary information
    }

    public double successRate() {
        return crystalSuccessRate;
    }

}

public class Calculator{ // original code given for problem

	private String name;
	private double errorConstant;
	
	public Calculator(String name) {
		this.name = name;
		this.errorConstant = Math.random();
	}
	
	public double add(Double a, Double b) {
		double calculation = a + b;

		calculation = addQuantomError(calculation);
		
		return calculation;
	}

	
	public double subtract(Double a, Double b) {
		double calculation = a - b;

		calculation = addQuantomError(calculation);
		
		return calculation;
	}
	
	private double addQuantomError(double calculation) {
		if (Math.random() < this.errorConstant) {
			calculation = calculation + Math.random();
		}
		return calculation;
	}

	public String getName() {
		return name;
	}

}
