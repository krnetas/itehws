package sim.rest.SWS;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Path("/find")
public class MainDBpedia {

	@Path("/actor")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Response actor(@QueryParam("name") String name) throws JSONException {
		JSONObject obj = new JSONObject();
		Response r = null;
		String thumb = DBpediaService.getThumbnil(name).get(0);
		obj.put("thumb", thumb);
		String abs = DBpediaService.getAbstract(name).get(0);
		obj.put("abs", abs);
		List<String> starred = DBpediaService.getMoviesStarred(name);
		obj.put("starred", starred);
		List<String> produced = DBpediaService.getMoviesDirected(name);
		obj.put("produced", produced);

		String data = obj.toString();
		r = Response.ok(data).build();

		return r;
	}

	@Path("/scientist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Response scientist(@QueryParam("name") String name) throws JSONException {
		JSONObject obj = new JSONObject();
		Response r = null;
		String thumb = DBpediaService.getThumbnil(name).get(0);
		obj.put("thumb", thumb);
		String abs = DBpediaService.getAbstract(name).get(0);
		obj.put("abs", abs);
		List<String> paper = DBpediaService.getListOfPublishedBooks(name);
		obj.put("paper", paper);

		String data = obj.toString();
		r = Response.ok(data).build();

		return r;
	}

//	@Path("/scientist")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public static Response writer(@QueryParam("name") String name) throws JSONException {
//		JSONObject obj = new JSONObject();
//		Response r = null;
//		String thumb = DBpediaService.getThumbnil(name).get(0);
//		obj.put("thumb", thumb);
//		String abs = DBpediaService.getAbstract(name).get(0);
//		obj.put("abs", abs);
//		List<String> books = DBpediaService.getListOfPublishedBooks(name);
//		obj.put("books", books);
//
//		String data = obj.toString();
//		r = Response.ok(data).build();
//
//		return r;
//
//	}

}

// needed only if querying behind a firewall
// System.setProperty("http.proxyHost", "proxy.fon.bg.ac.rs");
// System.setProperty("http.proxyPort", "8080");
