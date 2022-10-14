package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("\nProduct #" + i + " data");
			System.out.print("- Common, used or imported? (c/u/i) ");
			char type = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("- Name: ");
			String name = sc.nextLine();
			
			System.out.print("- Price: ");
			double price = sc.nextDouble();
			
			if(type == 'i') {
				System.out.print("- Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
			if(type == 'u') {
				System.out.print("- Manufacture date: ");
				LocalDate date = LocalDate.parse(sc.next(), 
						DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				list.add(new UsedProduct(name, price, date));
			}
			
			if(type == 'c') {
				list.add(new Product(name, price));
			}
			
		}
		
		System.out.println("\nPRICE TAGS:");
		for(Product p : list) {
			System.out.println(p.priceTag());
		}

	}

}
