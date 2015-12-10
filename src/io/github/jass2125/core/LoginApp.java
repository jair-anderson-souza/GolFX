package io.github.jass2125.core;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {
	private AnchorPane panel;
	private Button btEntrar;
	private Button btSair;
	private TextField txtLogin;
	private PasswordField txtPassword;
	private static Stage stage;
	
	private void initComponents(){
		panel = new AnchorPane();
		panel.setPrefSize(500, 300);
		panel.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, black 0%, silver 100%);");
		btEntrar = new Button("Entrar");
		btSair = new Button("Sair");
		
		txtLogin = new TextField();
		txtLogin.setPromptText("Digite seu login");
		
		txtPassword = new PasswordField();
		txtPassword.setPromptText("Digite aqui sua senha");
		
		panel.getChildren().addAll(btEntrar, btSair, txtLogin, txtPassword);
		
	}
	
	private void initLayout(){
		txtLogin.setLayoutX((panel.getWidth() - txtLogin.getWidth()) / 2);
		txtLogin.setLayoutY(50);
		
		txtPassword.setLayoutX((panel.getWidth() - txtPassword.getWidth()) / 2);
		txtPassword.setLayoutY(100);
		
		btEntrar.setLayoutX((panel.getWidth() - btEntrar.getWidth()) /2);
		btEntrar.setLayoutY(150);
		
		btSair.setLayoutX((panel.getWidth() - btSair.getWidth()) /2);
		btSair.setLayoutY(200);
		
	}
	
	private void logOnApp(){
		if(txtLogin.getText().equals("jass2125") && txtPassword.equals("123")){
			
		}else{
			JOptionPane.showMessageDialog(null, "Login e/ou senha invalidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void exitApp(){
		System.exit(0);
	}
	
	private void initListeners(){
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				logOnApp();
			}
		});
		
		btSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				exitApp();
				
			}
		});
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initListeners();
		Scene scene = new Scene(panel);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Login - GolFX");
		stage.show();
		initLayout();
		LoginApp.stage = stage;
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public static Stage getStage(){
		return LoginApp.stage;
	}

}
