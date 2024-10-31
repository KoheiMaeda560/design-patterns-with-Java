package adapter;

public class PrintBannerWithForwarding extends PrintWithForwarding {
	private Banner banner;


	public PrintBannerWithForwarding(String string) {
		this.banner = new Banner(string);
	}

	@Override
	public void printWeak() {
		banner.showWithParen();

	}

	@Override
	public void printStrong() {
		banner.showWithAster();
	}

}
