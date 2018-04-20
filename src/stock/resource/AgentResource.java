package stock.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import stock.bll.AgentBLL;
import stock.util.GsonBuilder;

@Path("/agent")
public class AgentResource {
	/**
	 * This methods returns stock details for an input agent ID.
	 * @param agentId
	 * @return
	 */
	@GET
	@Path("/stocks/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStocksById(@PathParam("id") String agentId) {

		String output = GsonBuilder.toJson(AgentBLL.getStocks(agentId));

		return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(output).build();
	}

	/**
	 * This method returns agent profile for a given agent ID
	 * @param agentId
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAgentInfo(@PathParam("id") String agentId) {
		return GsonBuilder.toJson(AgentBLL.getAgent(agentId));
	}

}