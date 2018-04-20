package stock.bll;

import java.util.List;
import stock.BO.Agent;
import stock.BO.Transaction;
import stock.dao.AgentDAO;

/**
 * This class serves as the business logic layer for Agent resource
 * 
 * @author Amanulla Shaik
 *
 */
public class AgentBLL {
	/**
	 * Returns list of stock purchases made by an agent.
	 * 
	 * @param agentId
	 * @return
	 */
	public static List<Transaction> getStocks(String agentId) {

		return AgentDAO.getStocks(agentId);

	}

	/**
	 * Returns agent profile for input agentID.
	 * 
	 * @param agentId
	 * @return
	 */
	public static Agent getAgent(String agentId) {

		return AgentDAO.getAgent(agentId);

	}

}
