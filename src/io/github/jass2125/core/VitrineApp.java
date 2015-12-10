package io.github.jass2125.core;

import java.util.List;
import java.util.Observable;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VitrineApp extends Application{
	private AnchorPane panel;
	private TextField txtPesquisa;
	private TableView<ItensProperty> tbVitrine;
	private TableColumn<ItensProperty, String> columnProduto;
	private TableColumn<ItensProperty, Double> columnPreco;
	private static ObservableList<ItensProperty> listaItens = FXCollections.observableArrayList();
	private static Carrinho carrinho;
	
	
	public class ItensProperty{
		private SimpleStringProperty produto;
		private SimpleDoubleProperty preco;
		
		public ItensProperty(String produto, double preco) {
			this.produto = new SimpleStringProperty(produto);
			this.preco = new SimpleDoubleProperty(preco);
		}

		public SimpleStringProperty getProduto() {
			return produto;
		}

		public void setProduto(SimpleStringProperty produto) {
			this.produto = produto;
		}

		public SimpleDoubleProperty getPreco() {
			return preco;
		}

		public void setPreco(SimpleDoubleProperty preco) {
			this.preco = preco;
		}
		
		
	}
	
	private void initComponents(){
		panel = new AnchorPane();
		panel.setPrefSize(800, 600);
		
		txtPesquisa = new TextField();
		txtPesquisa.setPromptText("Digite o item para pesquisa");
		
		tbVitrine = new TableView<ItensProperty>();
		tbVitrine.setPrefSize(780, 550);
		columnProduto = new TableColumn<ItensProperty, String>();
		columnPreco = new TableColumn<ItensProperty, Double>();
		columnProduto.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("produto"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("preco"));
		tbVitrine.getColumns().addAll(columnProduto, columnPreco);
		tbVitrine.setItems(listaItens);
		panel.getChildren().addAll(txtPesquisa, tbVitrine);
		carrinho = new Carrinho();
		
		
	}
	
	private void initListeners(){
		txtPesquisa.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(!txtPesquisa.getText().equals("")){
					tbVitrine.setItems(finItems());
				}else {
					tbVitrine.setItems(listaItens);
				}
			}
		});
	}
	private void initItens(){
		Vitrine v = new Vitrine();
		v.add(new Produto("Bola Topper", 15.00), new Produto("Luvas Umbro", 9.00), new Produto("Camisa Esportiva", 40.00), new Produto("Chuteira Nike Mercurial", 199.00), new Produto("Caneleira Topper", 10.00));
		for (Produto it : v.getProdutos()) {
			listaItens.add(new ItensProperty(it.getProduto(), it.getPreco()));
		}
	}
	
	private ObservableList<ItensProperty> finItems(){
		ObservableList<ItensProperty> itensEncontrados = FXCollections.observableArrayList();
		for (ItensProperty it : listaItens) {
			if (((List<ItensProperty>) it.getProduto()).contains(txtPesquisa.getText())) {
				itensEncontrados.add(it);
			}
		}
		return itensEncontrados;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initItens();
		initListeners();
		Scene scene = new Scene(panel);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	
	
	
	
	
	
	
	
	
	
	}

}
