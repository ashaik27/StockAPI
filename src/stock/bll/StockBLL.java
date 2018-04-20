package stock.bll;

import java.util.List;

import stock.BO.Purchase;
import stock.BO.Stock_OHLCV;
import stock.dao.StockDAO;
/**
 * This class serves as the business logic layer for Stock resource.
 * @author Amanulla Shaik
 *
 */
public class StockBLL {
	/**
	 * Returns list of purchases made by an agent.
	 * @param agentId
	 * @return
	 */
	public static List<Purchase> getInvestments(String agentId) {

		return StockDAO.getInvestments(agentId);

	}
	/**
	 * Returns Open-High-Low-Close data points list for a given stock.
	 * @param stockId
	 * @return
	 */
	public static List<Stock_OHLCV> getOHLCV(String stockId) {

		return StockDAO.getOHLCV(stockId);

	}
}
