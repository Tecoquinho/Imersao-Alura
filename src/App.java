import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

	
	public static void main(String[] args) throws Exception {
				
		// Fazer uma conex�o HTTP e buscar os top 250 filmes
		String url = "https://api.themoviedb.org/3/trending/movie/week?api_key=97b906833708b19b1c5a476419a99348";
		URI endereco = URI.create(url);
		var client =  HttpClient.newHttpClient(); 
		var request = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		String body = response.body();
		
		
		
		// Extrair s� os dados que interessam
		JsonParser parser = new JsonParser();
		List<Map<String, String>> listaDeFilmes = parser.parse(body);	
		System.out.println(listaDeFilmes.size());
		// Exibir e manipular os dados
		
		
	}
}
