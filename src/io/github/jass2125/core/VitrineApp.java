package io.github.jass2125.core;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

		public String getProduto() {
			return produto.getValue();
		}

		public void setProduto(SimpleStringProperty produto) {
			this.produto = produto;
		}

		public Double getPreco() {
			return preco.getValue();
		}

		public void setPreco(SimpleDoubleProperty preco) {
			this.preco = preco;
		}
		
		
	}
	
	private void initComponents(){
		panel = new AnchorPane();
		panel.setLayoutY(30);
		panel.setPrefSize(780, 550);
		
		txtPesquisa = new TextField();
		txtPesquisa.setPromptText("Digite o item para pesquisa");
		txtPesquisa.setLayoutY(-27.5);
		
		
		tbVitrine = new TableView<ItensProperty>();
		tbVitrine.setPrefSize(780, 550);
		columnProduto = new TableColumn<ItensProperty, String>();
		columnPreco = new TableColumn<ItensProperty, Double>();
		columnProduto.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("produto"));
		columnProduto.setText("Produto");
		
		columnPreco.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("preco"));
		columnPreco.setText("Preço");
		
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
					tbVitrine.setItems(findItems());
				}else {
					tbVitrine.setItems(listaItens);
				}
			}
		});
		
		tbVitrine.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItensProperty>() {
			
			public void changed(ObservableValue<? extends ItensProperty> value, ItensProperty oldItem, ItensProperty newItem) {
				
				ItemApp.setProduto(new Produto(newItem.getProduto(), newItem.getPreco()));
				ItemApp.setIndex(tbVitrine.getSelectionModel().getSelectedIndex());
				
				try{
					new ItemApp().start(new Stage());
					
				}catch(Exception e){
					e.printStackTrace();
				}
				
			};
		});
		
	}
	private void initItens(){
		Vitrine v = new Vitrine();
		v.add(new Produto("Bola Topper", 15.00), new Produto("Luvas Umbro", 9.00), new Produto("Camisa Esportiva", 40.00), new Produto("Chuteira Nike Mercurial", 199.00), new Produto("Caneleira Topper", 10.00));
		for (Produto it : v.getProdutos()) {
			listaItens.add(new ItensProperty(it.getProduto(), it.getPreco()));
		}
	}
	
	private ObservableList<ItensProperty> findItems(){
		ObservableList<ItensProperty> itensEncontrados = FXCollections.observableArrayList();
		for (ItensProperty it : listaItens) {
			if ((it.getProduto()).contains(txtPesquisa.getText())) {
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
