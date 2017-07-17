package object;

import java.util.List;

public class PaymentInfo {
	private String cardType;
	private long cardNumber;
	private int cardExp;
	private String cardName;
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCardExp() {
		return cardExp;
	}
	public void setCardExp(int cardExp) {
		this.cardExp = cardExp;
	}
	public String getcardName() {
		return cardName;
	}
	public void setcardName(String cardName) {
		this.cardName = cardName;
	}
	
	public void calcPrice(List <Book> book){
	}
	
	public void addToProfile(String cardNum, String cardExp, String cardName){		
	}
}
