

import gameobjects.Piece;
import gameobjects.Rook;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class ChessBoard extends Application {
	BorderPane borderLayer;
	Pane boardLayer;
	Pane pieceLayer;
	Image whiteImage;
	Image blackImage;
	private ArrayList<BoardTile>nodes = new ArrayList<BoardTile>();
	private ArrayList<Piece>black = new ArrayList<Piece>();
	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();
		//Group piece = new Group();
		  pieceLayer = new Pane();
		  boardLayer = new Pane();
		  borderLayer = new BorderPane();
		final int size = 8 ;
		Image bRook = new Image(getClass().getResource("bRook.png").toExternalForm());
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col ++) {
				
				BoardTile square;
				String color ;
				if ((row + col) % 2 == 0) {
					color = "white";
					square = new BoardTile(row,col,"w");
					nodes.add(square);
				} else {
					color = "black";
					square = new BoardTile(row,col,"b");
					square.setMaxSize(1000/8, 750/8);
					square.setMinSize(1000/8, 750/8);
					nodes.add(square);
				}
				
				
				square.setStyle("-fx-background-color: "+color+";");
				
				root.add(square, col, row);
				System.out.println(col + " " + row);
				
			}
		}
		for (int i = 0; i < size; i++) {
			root.getColumnConstraints().add(new ColumnConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
			root.getRowConstraints().add(new RowConstraints(5, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
		}
		createPlayers();
		for (BoardTile block : nodes) {
			
				setDragListeners(block,black.get(0));
			
			
		}
		
		borderLayer.setCenter(root);
		borderLayer.setTop(makeMenu());
		primaryStage.setScene(new Scene(borderLayer, 1000, 750));
		primaryStage.show();
		
	//	root.getChildren().add(boardLayer);
		
		
	}
	
	private MenuBar makeMenu()
	    {
	        MenuBar menuBar = new MenuBar();
	        Menu menuFile = new Menu("File");  
	        Menu menuHelp = new Menu("Help");
	        MenuItem howTo = new MenuItem("How To Play");
	        MenuItem exit = new MenuItem("Quit");
//	        
//	        howTo.setOnAction(new EventHandler<ActionEvent>() {
//
//	            @Override
//	            public void handle(ActionEvent e) {
//	            	
//	            	 Stage stage = new Stage();
//	                 stage.setTitle("My New Stage Title");
//	                 stage.setScene(new Scene(root, 450, 450));
//	                 stage.show();
//	            }
//	        });
//	        
	        exit.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent e) {
	            	System.exit(0);
	            }
	        });
	        menuFile.getItems().add(exit);
	        menuHelp.getItems().add(howTo);
	        menuBar.getMenus().addAll(menuFile, menuHelp);
	        return menuBar;
	    }

	
	 class Delta { double x, y; }
	public void setDragListeners(final BoardTile block,final Piece piece) {
		 final Delta dragDelta = new Delta();

		block.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override public void handle(MouseEvent mouseEvent) {
				dragDelta.x = piece.getLayoutX() - mouseEvent.getSceneX();
	            dragDelta.y = piece.getLayoutY() - mouseEvent.getSceneY();
	            System.out.println(piece.getLayoutX());
				block.setStyle("-fx-background-color:red;");
				piece.setCursor(Cursor.CLOSED_HAND);

				block.setCursor(Cursor.CLOSED_HAND);

			}
		});
		block.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				block.setCursor(Cursor.HAND);
				
				if(block.color.equalsIgnoreCase("w")){
					block.setStyle("-fx-background-color:white;");
					
				}
				else if(block.color.equalsIgnoreCase("b")){
					block.setStyle("-fx-background-color:black;");
				}
				
				piece.reLocate(nodes.get(1));	
				
			}
		});
		block.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent mouseEvent) {
				
				
//				piece.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
//	            piece.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
	           piece.reLocate(nodes.get(1));

			}
		});
	}
	 private void createPlayers() {
		 blackImage = new Image( getClass().getResource("bRook.png").toExternalForm());
	        // player input
	        

	        // register input listeners
	       // pControl.addListeners(); // TODO: remove listeners on game over

	        ;

	        // center horizontally, position at 70% vertically
	       double x = nodes.get(0).getLayoutX();
	        double y = nodes.get(0).getLayoutY();

	        // create player
	        Rook blackRook = new Rook(nodes.get(0), 1, 1,"b","r", blackImage);
	        
	        black.add(blackRook);
	        blackRook.setMaxSize(1000/8, 750/8);

	        // register player
	       // players.add( player);

	    }

	public static void main(String[] args) {
		launch(args);
	}

}