package stock.BO;

/**
 * This class acts as JAVA Bean for a stock purchase.
 * @author Amanulla Shaik
 *
 */
public class Purchase {
	String purchaseDate;
	float purchasePrice;
	float sellingPrice;

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public float getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}
