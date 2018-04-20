package stock.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import stock.BO.Purchase;
import stock.BO.Stock;
import stock.BO.Stock_OHLCV;
import stock.util.Constants;
import stock.util.DBUtil;
import stock.util.Queries;

/**
 * @author Amanulla Shaik
 * This class contains DAO methods for stock API Resource
 */
public class StockDAO {
	static ResultSet resultSet;
	/**
	 * Returns Stock details for input Stock ID 
	 * @param stockId
	 * @return
	 */
	public static Stock getStock(String stockId) {
		Stock stock = null;
		try {
			resultSet = DBUtil.getResultSet(Queries.getStockById(stockId));
			while (resultSet.next()) {
				stock = new Stock();
				stock.setId(resultSet.getString(Constants.ID));
				stock.setCode(resultSet.getString(Constants.CODE));
				stock.setName(resultSet.getString(Constants.NAME));
				stock.setSellingPrice(resultSet.getString(Constants.SELLING_PRICE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}
	/**
	 * This method return list of purchases for a given Agent ID
	 * @param agentId
	 * @return
	 */
	public static List<Purchase> getInvestments(String agentId){
		List<Purchase> purchases = new ArrayList<Purchase>();
		Purchase purchase = null;
		try {
			resultSet = DBUtil.getResultSet(Queries.getPurchaseHistory(agentId));
			while (resultSet.next()) {
				purchase = new Purchase();
				purchase.setPurchaseDate(resultSet.getString(Constants.PURCHASE_DATE));
				purchase.setPurchasePrice(resultSet.getFloat(Constants.PURCHASE_PRICE));
				purchase.setSellingPrice(resultSet.getFloat(Constants.SELLING_PRICE));
				purchases.add(purchase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchases;
	}
	public static List<Stock_OHLCV> getOHLCV(String stockId){
		List<Stock_OHLCV> stockList = new ArrayList<Stock_OHLCV>();
		Stock_OHLCV stock = null;
		try {
			resultSet = DBUtil.getResultSet(Queries.getOHLCV(stockId));
			while (resultSet.next()) {
				stock = new Stock_OHLCV();
				stock.setStockId(resultSet.getInt(Constants.STOCK_ID));
				stock.setDate(resultSet.getDate(Constants.DATE).toString());
				stock.setOpen(resultSet.getFloat(Constants.OPEN));
				stock.setHigh(resultSet.getFloat(Constants.HIGH));
				stock.setLow(resultSet.getFloat(Constants.LOW));
				stock.setClose(resultSet.getFloat(Constants.CLOSE));
				stock.setVolume(resultSet.getInt(Constants.VOLUME));
				stockList.add(stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stockList;
	}

}
