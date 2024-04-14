package br.com.mario.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.model.DadosSerie;
import br.service.ConsumoAPI;
import br.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	private String url = "http://www.omdbapi.com/?i=tt3896198&apikey=d73f361a";

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto Spring sem web");
		ConsumoAPI consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obterDados(url);
		// System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}

}
