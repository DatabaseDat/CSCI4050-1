package object;

public class Promotion {
	private String promoName;
	private int amount;
	
	public Promotion(){
		this.setPromoName(null);
		this.setAmount(-1);
	}
	
	public Promotion(String pName, int a){
		this.setAmount(a);
		this.setPromoName(pName);
	}

	public String getPromoName() {
		return this.promoName;
	}

	public void setPromoName(String pName) {
		this.promoName = pName;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int a) {
		this.amount = a;
	}
}
