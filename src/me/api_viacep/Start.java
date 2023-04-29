package me.api_viacep;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import me.api_viacep.cep.Cep;
import me.api_viacep.connect.Connect;

public class Start {

	public static void main(String[] args) throws IOException {

		Connect con = new Connect();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String busca = "";
		List<Cep> ceps = new ArrayList<Cep>();
		while (!busca.equalsIgnoreCase("sair")) {
			System.out.println("digite um cep");
			busca = scan.nextLine();
			//String url = "https://viacep.com.br/ws/"+ busca +"/json/";
			if(busca.equalsIgnoreCase("sair")) {
				break;
			}else if(busca.length() < 8) {
				System.out.println("o cep e composto por 8 digitos, nao menos");
				busca = scan.nextLine();
			}else if(busca.length() > 8){
				System.out.println("o cep e composto 8 digitos, nao mais");
				busca = scan.nextLine();
			}
			String url = "https://viacep.com.br/ws/"+ busca +"/json/";
		try {
			Cep cep = new Cep(con.getConect(url));

			ceps.add(cep);
			
			System.out.println(con.getConect(url));
		} catch (IOException|InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			} 
		}
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
		System.out.println(ceps);
			FileWriter file = new FileWriter("Ceps.json");
			file.write(gson.toJson(ceps));
			file.close();
			System.out.println("arquivo gerado!");
		
	}

}
