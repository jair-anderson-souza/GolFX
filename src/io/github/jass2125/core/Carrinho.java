package io.github.jass2125.core;

import java.util.List;
import java.util.ArrayList;

public class Carrinho {
	private List<Produto> produtos = new ArrayList();
	
	public void add(Produto ... produto){
		for(Produto it : produto){
			produtos.add(it);
		}
	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}
}
