package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import entities.Order;


public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Enter client data: \nName: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth data (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.print("Enter order data: \nStatus: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order: ");
		int qtd = sc.nextInt();
		
		for (int i=1;i<=qtd;i++) {
			System.out.print("Enter #" + i + " item data: \nProduct name: ");
			sc.nextLine();
			String nameP = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(nameP, price);
			
			OrderItem orderItem = new OrderItem(quantity, price, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("\nORDER SUMMARY: ");
		System.out.println(order);
		/*System.out.println("Order moment: " + order.getMoment());
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + client.getName() + " (" 
						+ client.getBirthDate() + ") - " + client.getEmail());
		System.out.println("Order items: ");*/
	
		
		sc.close();

	}

}
