package gameobjects;


import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;



public abstract class Piece extends StackPane  {
	private boolean available;
	private double x;
	private double y;
	private String color;
	private String type;
	private Image image;
	public ImageView imageView;
	StackPane box;


	public Piece(StackPane box, double x, double y,String c,String t,Image i) {
		super();

		this.box = box;
		this.x = x;
		this.y = y;
		this.color = c;
		this.type = t;
		this.image = i;
		this.imageView = new ImageView(image);


		 this.imageView.relocate(x, y);

		addToLayer();
	}
	public void addToLayer() {
		this.box.getChildren().add(this.imageView);
	}
	public void reLocate(StackPane box){
		 this.imageView.relocate(box.getLayoutX(), this.getScaleY());
		 this.relocate(box.getLayoutX(), box.getLayoutY());
	}


	public String getColor() {
		return color;
	}

	public String getType() {
		return type;
	}

	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setLocation(int x,int y){
		this.x = x;
		this.y = y;
	}
	//	public void setDragListeners(final Piece block) {
	//
	//
	//		block.setOnMousePressed(new EventHandler<MouseEvent>() {
	//			@Override public void handle(MouseEvent mouseEvent) {
	//
	//
	//
	//				block.setCursor(Cursor.CLOSED_HAND);
	//
	//			}
	//		});
	//		block.setOnMouseReleased(new EventHandler<MouseEvent>() {
	//			@Override public void handle(MouseEvent mouseEvent) {
	//				block.setCursor(Cursor.HAND);
	//
	//			}
	//		});
	//		block.setOnMouseDragged(new EventHandler<MouseEvent>() {
	//			@Override public void handle(MouseEvent mouseEvent) {
	//				double x = block.getLayoutX() - mouseEvent.getSceneX();
	//				double y = block.getLayoutY() - mouseEvent.getSceneY();
	//				block.setLayoutX(mouseEvent.getSceneX() + x);
	//				block.setLayoutY(mouseEvent.getSceneY() + y);
	//
	//
	//
	//			}
	//		});
	//	}

	public abstract boolean isValidLmove(int toX,int toY,boolean cap,boolean lCheck);
	public abstract boolean isValidDmove(int toX,int toY,boolean cap,boolean dCheck);
	public abstract boolean isValidLCastle(int toX,int toY,boolean lCheck);
	public abstract boolean isValidDCastle(int toX,int toY,boolean dCheck);
}
