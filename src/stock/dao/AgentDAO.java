package stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import stock.BO.Agent;
import stock.BO.Transaction;
import stock.util.Constants;
import stock.util.DBUtil;
import stock.util.Queries;

/**
 * @author Amanulla Shaik
 *
 */
public class AgentDAO {
	static ResultSet resultSet;

	/**
	 * This method return list of purchases that given agent has made.
	 * 
	 * @param agentId
	 * @return
	 */
	public static List<Transaction> getStocks(String agentId) {
		Transaction stock = null;
		List<Transaction> stocks = null;
		try {
			resultSet = DBUtil.getResultSet(Queries.getStocksById(agentId));
			stocks = new ArrayList<Transaction>();
			while (resultSet.next()) {
				stock = new Transaction();
				stock.setStockId(resultSet.getString(Constants.STOCK_ID));
				stock.setStockCode(resultSet.getString(Constants.CODE));
				stock.setStockName(resultSet.getString(Constants.NAME));
				stock.setAgentId(resultSet.getString(Constants.AGENT_ID));
				stock.setPurchaseDate(resultSet.getString(Constants.PURCHASE_DATE));
				stock.setQuantity(resultSet.getInt(Constants.QUANTITY));
				stock.setPurchasePrice(resultSet.getFloat(Constants.PURCHASE_PRICE));
				stock.setSellingPrice(resultSet.getFloat(Constants.SELLING_PRICE));
				stocks.add(stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stocks;
	}

	/**
	 * This method return agent profile for a given agent ID
	 * @param agentId
	 * @return
	 */
	public static Agent getAgent(String agentId) {
		Agent agent = null;

		try {
			resultSet = DBUtil.getResultSet(Queries.getAgentById(agentId));
			agent = new Agent();
			while (resultSet.next()) {
				agent.setFirstName(resultSet.getString(Constants.FIRSTNAME));
				agent.setLastName(resultSet.getString(Constants.LASTNAME));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agent;
	}
}
