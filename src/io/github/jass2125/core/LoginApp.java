package io.github.jass2125.core;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application {
	private AnchorPane panel;
	private Button btEntrar;
	private Button btSair;
	private TextField txLogin;
	private TextField txPassword;
	private static Stage stage;
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		LoginApp.stage = stage;
	}
	
	public static Stage getStage(){
		return LoginApp.stage;
	}

}
