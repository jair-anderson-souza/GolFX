package io.github.jass2125.core;



import com.sun.webkit.ContextMenu.ShowContext;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ItemApp extends Application {
	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbPreco;
	private Label lbDescricao;
	private Button btAddCarrinho;
	private static Stage stage;
	private static Produto produto;
	private static int index;
	private static String[] images = {
		"http://www.sportcenterlopes.com.br/images/" +
				"250_topper_campo_2009replic.jpg",
				"http://1.bp.blogspot.com/_H8uGs8K8kaY/TLZTXR8nIgI/" +
				"AAAAAAAAF_0/BvpxdqGF4PE/s1600/luva_umbro.png",
				"http://bimg2.mlstatic.com/camisa-nike-active-importada-manga-" +
				"longa-esportiva-vermelha_MLB-F-199843960_1391.jpg",
				"http://www.showtenis.com.br/images/_product/979/979112/" +
				"chuteira-nike-mercurial-glide-3-fg-campo--199fd9.jpg",
				"http://www.katy.com.br/imagens/produtos/original/" +
				"caneleira-topper-trainning-difusion-13340619502673137.jpg" };
	
	private void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		String img = "http://mlb-s2-p.mlstatic.com/sapato-social-stilo-ferracin-democra-osklen-rafarillo-gofer-18005-MLB20148461154_082014-F.jpg";
		imgItem = new ImageView(new Image(images[index]));
		
		lbPreco = new Label("Preço");
		lbDescricao = new Label("Descrição");
		
		btAddCarrinho = new Button("Adicione ao Carrinho");
//		btAddCarrinho.setText("Adicione ao carrinho");
		
		
		btAddCarrinho.setPrefSize(170, 20);
		
		pane.getChildren().addAll(imgItem, lbDescricao,lbPreco, btAddCarrinho);
	}
	
	private void initLayout(){
		lbDescricao.setLayoutX((pane.getWidth() - lbDescricao.getWidth()) / 10);
		lbDescricao.setLayoutY(50);
		
		lbPreco.setLayoutX((pane.getWidth() - lbPreco.getWidth()) / 10);
		lbPreco.setLayoutY(100);
		
		btAddCarrinho.setLayoutX(650);
		btAddCarrinho.setLayoutY(720);
		
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
		initLayout();
		ItemApp.stage = stage;
		
		
	}
	public static Stage getStage(){
		return ItemApp.stage;
	}
	
	public static Produto getProduto(){
		return ItemApp.produto;
	}
	
	public static void setProduto(Produto produto){
		ItemApp.produto = produto;
	}
	
	public static int getIndex() {
		return index;
	}
	public static void setIndex(int index) {
		ItemApp.index = index;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
