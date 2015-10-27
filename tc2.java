import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class tc2 {
	public static class Customer {
		private int id;
		private String name;

		public Customer(int i, String n) {
			this.id = i;
			this.name = n;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}


	public static void main(String[] args) {
		Queue<Integer> integerPq = new PriorityQueue<>(7);
		Random rand = new Random();

		for (int i = 0; i < 7; i++) {
			integerPq.add(new Integer(rand.nextInt(100)));
		}

		for (int i = 0; i < 7; i++) {
			Integer in = integerPq.poll();
			System.out.println("Processing Integer: " + in);
		}

		Queue<Customer> customerPq = new PriorityQueue<>(7, idComparator);
		addDataToQueue(customerPq);

		pollDataFromQueue(customerPq);
	}
public static Comparator<Customer> idComparator = new Comparator<Customer>() {
	public int compare(Customer c1, Customer c2) {
		return (int) (c1.getId() - c2.getId());
	}
};

private static void addDataToQueue(Queue<Customer> customerPq) {
	Random rand = new Random();
	for (int i = 0; i < 7; i++) {
		int id = rand.nextInt(100);
		customerPq.add(new Customer(id, "Women" + id));
	}

}

private static void pollDataFromQueue(Queue<Customer> customerPq) {
	while (true) {
		Customer cust = customerPq.poll();
		if (cust == null) break;
		System.out.println("Processing Customer with ID = " + cust.getId());
	}
}


	

}