package stock.util;

/**
 * This method maintains static list of queries for reference. Will be deprecated after moving queries to DB environment in future..
 * @author a1727212
 *
 */
public class Queries {
	/**
	 * @param agentId
	 * @return
	 */
	public static String getStocksById(String agentId) {
		return String.format(
				"select * from stock AS s join [dbo].[stockTransaction] AS t on s.id = t.stockId where agentId = %s",
				agentId);
	}
	/**
	 * @param stockId
	 * @return
	 */
	public static String getStockById(String stockId) {
		return String.format("SELECT * FROM [dbo].[stock] where id=%s", stockId);
	}
	/**
	 * @param agentId
	 * @return
	 */
	public static String getAgentById(String agentId) {
		return String.format("SELECT * FROM [dbo].[agent] where id=%s", agentId);
	}
	/**
	 * @param stockId
	 * @return
	 */
	public static String getOHLCV(String stockId) {
		return String.format("select * from [dbo].[ohlcv] where stockId=%s order by date", stockId);
	}
	/**
	 * @param agentId
	 * @return
	 */
	public static String getPurchaseHistory(String agentId) {
		return String
				.format(" select t.purchaseDate, Avg(s.sellingPrice) As 'sellingPrice',Avg(t.purchasePrice) As 'purchasePrice' "
						+ "from stock AS s join [dbo].[stockTransaction] AS t on s.id = t.stockId "
						+ "where agentId=%s group by purchaseDate ", agentId);
	}
}
