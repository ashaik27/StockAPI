package stock.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import stock.bll.StockBLL;
import stock.util.GsonBuilder;

/**
 * 
 * @author Amanulla Shaik
 *
 */
@Path("/stock")
public class StockResource {
	/**
	 * This method returns Agent profile for a given agent ID
	 * 
	 * @param agentId
	 * @return
	 */
	@GET
	@Path("/purchases/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAgentInfo(@PathParam("id") String agentId) {
		String output = GsonBuilder.toJson(StockBLL.getInvestments(agentId));

		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(output).build();

	}

	/**
	 * This method processes and return stock Open-High-Low-Closing values for a given stock. 
	 * @param stockId
	 * @return
	 */
	@GET
	@Path("/ohlcv/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOHLCV(@PathParam("id") String stockId) {
		String output = GsonBuilder.toJson(StockBLL.getOHLCV(stockId));

		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(output).build();

	}
}
