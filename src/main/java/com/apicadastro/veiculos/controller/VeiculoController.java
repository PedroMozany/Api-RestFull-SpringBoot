package com.apicadastro.veiculos.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apicadastro.veiculos.domain.Veiculo;
import com.apicadastro.veiculos.repository.VeiculoRepository;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository repo;

	@GetMapping
	public List<Veiculo> listar() {
		return repo.findAll();
	}
	
	
	@RequestMapping(value = "/modelo", method = RequestMethod.GET)
	public List<Veiculo> modelo(@RequestParam("nome") String modelo){
		return repo.findAll();
	}
	
	@RequestMapping(value = "/descricao", method = RequestMethod.GET)
	public List<Veiculo> descricao(@RequestParam("descricao") String detalhe){
		return repo.findAll();
	}
	
	
	@PutMapping
	public List<Veiculo> uptdate(@RequestBody Veiculo veiculo)  {
		Scanner teclado = new Scanner(System.in);
		int ano = teclado.nextInt();
		String descricao = teclado.nextLine();
		veiculo.setAno(ano);
		veiculo.setDescricao(descricao);
		teclado.close();
		return repo.findAll();
		
	} 
	
	@PatchMapping
	public List<Veiculo> atualizar(@RequestBody Veiculo veiculo){
		Scanner teclado = new Scanner(System.in);
		String vedindo = teclado.nextLine();
		veiculo.setVendido(vedindo);
		teclado.close();
		return repo.findAll();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculo adicionar(@RequestBody Veiculo veiculo) {
		return repo.save(veiculo);
	}

	
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void delete(Veiculo id) {
		repo.delete(id);
	}
	

}
