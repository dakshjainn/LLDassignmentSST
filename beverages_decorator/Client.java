package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println("=== Beverage Decorator Pattern Demo ===\n");

		// Basic beverages
		System.out.println("--- Basic Beverages ---");
		Beverage cappuccino = new Cappuccino();
		printBeverage(cappuccino);
		
		Beverage latte = new Latte();
		printBeverage(latte);

		// Single decorators
		System.out.println("\n--- Single Decorators ---");
		Beverage cappuccinoWithChocolate = new ChocolateDecorator(new Cappuccino());
		printBeverage(cappuccinoWithChocolate);
		
		Beverage latteWithMilk = new MilkDecorator(new Latte());
		printBeverage(latteWithMilk);

		// Multiple decorators
		System.out.println("\n--- Multiple Decorators ---");
		Beverage fancyCappuccino = new WhipDecorator(
			new ChocolateDecorator(
				new MilkDecorator(
					new Cappuccino()
				)
			)
		);
		printBeverage(fancyCappuccino);

		Beverage sweetLatte = new SugarDecorator(
			new MilkDecorator(
				new Latte()
			)
		);
		printBeverage(sweetLatte);

		// Complex combinations
		System.out.println("\n--- Complex Combinations ---");
		Beverage deluxeCappuccino = new WhipDecorator(
			new ChocolateDecorator(
				new SugarDecorator(
					new MilkDecorator(
						new Cappuccino()
					)
				)
			)
		);
		printBeverage(deluxeCappuccino);

		// Double decorators (stacking)
		System.out.println("\n--- Stacked Decorators ---");
		Beverage doubleChocolate = new ChocolateDecorator(
			new ChocolateDecorator(
				new Cappuccino()
			)
		);
		printBeverage(doubleChocolate);
	}

	private static void printBeverage(Beverage beverage) {
		System.out.println(beverage.getDescription() + " - Cost: ₹" + beverage.cost());
	}
}