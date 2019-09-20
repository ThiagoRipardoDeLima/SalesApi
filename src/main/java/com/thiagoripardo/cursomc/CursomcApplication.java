package com.thiagoripardo.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thiagoripardo.cursomc.domain.Categoria;
import com.thiagoripardo.cursomc.domain.Cidade;
import com.thiagoripardo.cursomc.domain.Cliente;
import com.thiagoripardo.cursomc.domain.Endereco;
import com.thiagoripardo.cursomc.domain.Estado;
import com.thiagoripardo.cursomc.domain.Produto;
import com.thiagoripardo.cursomc.domain.enums.TipoCliente;
import com.thiagoripardo.cursomc.repositories.CategoriaRepository;
import com.thiagoripardo.cursomc.repositories.CidadeRepository;
import com.thiagoripardo.cursomc.repositories.ClienteRepository;
import com.thiagoripardo.cursomc.repositories.EnderecoRepository;
import com.thiagoripardo.cursomc.repositories.EstadoRepository;
import com.thiagoripardo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository cat;
	@Autowired
	private ProdutoRepository prod;
	@Autowired
	private EstadoRepository est;
	@Autowired
	private CidadeRepository cid;
	@Autowired
	private ClienteRepository cli;
	@Autowired
	private EnderecoRepository end;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		cat.saveAll(Arrays.asList(cat1,cat2));
		prod.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null,"Uberlandia",est1);
		Cidade cid2 = new Cidade(null,"São Paulo",est2);
		Cidade cid3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		est.saveAll(Arrays.asList(est1,est2));
		cid.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","01717169147", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("6530258585","65999319411"));
		
		Endereco e1 = new Endereco(null,"Rua Flores", "300","Apto 303", "Jardim", "38220834",cli1,cid1);
		Endereco e2 = new Endereco(null,"Avenida Matos", "105","sala 800", "Centro", "38777012",cli1,cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		cli.saveAll(Arrays.asList(cli1));
		end.saveAll(Arrays.asList(e1,e2));
		
		
	}

}
