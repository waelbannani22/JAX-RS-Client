import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class HelloResourceClient {

	public static void main(String[] args) {
		
		//create new jax re client 
		Client client = ClientBuilder.newClient();
		
		//the base url of the service 
		
		WebTarget target = client.target("http://localhost:8080/Hello_JAX-RS/rest/greetings");
		
		//consuming sayhello method 
		//get the response from the target url
		Response response = target.request().get();
		
		//read the result as a string
		
		String result =response.readEntity(String.class);
		
		//print the result of standard output
		System.out.println(result);
		
		
		// method 2
		WebTarget hello2 =target.queryParam("FirstName", "wael").queryParam("LastName", "banani");
		Response response2= hello2.request().get();
		String result2 =response2.readEntity(String.class);
		System.out.println(result2);
	
		//method3
		WebTarget hello3 =target.path("ahmed").path( "bannani");
		Response response3= hello3.request().get();
		String result3 =response3.readEntity(String.class);
		System.out.println(result3);
		
		
		
		
		response.close();
		
	}

}
