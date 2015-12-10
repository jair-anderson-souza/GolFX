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
		"https://www.google.com.br/imgres?imgurl=http://www.netshoes.com.br/Produtos/32/138-9048-032/138-9048-032_detalhe1.jpg&imgrefurl=http://www.netshoes.com.br/produto/bola-topper-extreme-3-society-138-9048&h=410&w=410&tbnid=7AFE8wRVRTzomM:&docid=a3faTtWHxcSgeM&ei=LKxpVvu1E4WjwgT1npCIDg&tbm=isch&client=ubuntu&ved=0ahUKEwj7-5z73tHJAhWFkZAKHXUPBOEQMwgyKAAwAA" +
		"https://www.google.com.br/imgres?imgurl=http://1.bp.blogspot.com/_H8uGs8K8kaY/TLZTXR8nIgI/AAAAAAAAF_0/BvpxdqGF4PE/s1600/luva_umbro.png&imgrefurl=http://guarda-metas.com/luvas/luvas-luvas/nova-luva-da-umbro-na-tka/&h=600&w=900&tbnid=jCH9TVpfb91F7M:&docid=4bBJe8WR-XuVIM&ei=SKxpVunKK8SpwgSG_brACg&tbm=isch&client=ubuntu&ved=0ahUKEwjpjuKI39HJAhXElJAKHYa-DqgQMwgyKAAwAA" +  
		"https://www.google.com.br/imgres?imgurl=http://www.jcconfeccoes.com.br/img/produtos/5/079.jpg&imgrefurl=http://www.jcconfeccoes.com.br/index.php/prods/139/Uniformes-Esportivos-Camisas/&h=750&w=750&tbnid=hXCxMPNZHHPaaM:&docid=GQvMjXR5cszSMM&ei=bqxpVpSWJsH6wQTc86vAAw&tbm=isch&client=ubuntu" + 
		"https://www.google.com.br/imgres?imgurl=http://images.centauro.com.br/900x900/829401Q4/chuteira-de-campo-nike-mercurial-victory-v-fg-img.jpg&imgrefurl=http://www.centauro.com.br/chuteira-de-futebol-de-campo-nike-mercurial-victory-v-fg-829401.html&h=1200&w=1200&tbnid=eKQKcWlpiuiQVM:&docid=Wpw2oS262ZWZEM&ei=hqxpVr8oibXABPPxnNAC&tbm=isch&client=ubuntu&ved=0ahUKEwi_g_-l39HJAhWJGpAKHfM4ByoQMwgyKAAwAA" + 
		"https://www.google.com.br/imgres?imgurl=http://img.submarino.com.br/produtos/01/00/item/115494/0/115494055_2GG.jpg&imgrefurl=http://www.submarino.com.br/produto/115494055/caneleira-topper-training-2-difusion&h=500&w=500&tbnid=r02Rx_nO90ExBM:&docid=KWo0uWbR4VebVM&ei=mqxpVtLWIMWhwgSvqqDIBQ&tbm=isch&client=ubuntu"
	};
	
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
