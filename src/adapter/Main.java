package adapter;

public class Main {

	public static void main(String[] args) {
		Print p = new PrintBanner("Hello");
		p.printWeak();
		p.printStrong();

		PrintWithForwarding p2 = new PrintBannerWithForwarding("Hello");
		p2.printWeak();
		p2.printStrong();

	}

}
