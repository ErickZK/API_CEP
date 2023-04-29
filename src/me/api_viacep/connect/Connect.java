package me.api_viacep.connect;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import me.api_viacep.cep.CepViacep;

public class Connect {
	
	public CepViacep getConect(String url) throws IOException, InterruptedException{

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String json = response.body();

		return new Gson().fromJson(json, CepViacep.class);
	}

}
