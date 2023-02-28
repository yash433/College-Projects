//MouseEvent.any
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import java.util.ArrayList;
public class MyGame extends Application implements EventHandler<InputEvent>
{
		GraphicsContext gc;
		Image background;
		Image gun;
		Image crosshair;
		Image duck;
		int x = 0;
		int y = 0;
		AnimateObjects animate;
		AudioClip clip;
		Canvas canvas;
		ArrayList<Image> ducks = new ArrayList<Image>();
		boolean launch = true;
		int i = 0;
		int score = 0;




	public static void main(String[]args)
	{
		launch();
	}
	public void start (Stage stage)
	{
		stage.setTitle("Final Project Title");
		Group root = new Group();
		canvas = new Canvas(1700, 900);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		scene.addEventHandler(MouseEvent.ANY, this);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		gc = canvas.getGraphicsContext2D();
		background = new Image("background.jpg" );
		gun = new Image("gun.png");
		gc.drawImage(gun, 500, 560);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
		crosshair = new Image("crosshair.png");
		gc.drawImage(crosshair, 700, 300);
		duck = new Image("duck.png");
		//gc.drawImage(duck, 700, 300);
		animate = new AnimateObjects();
		animate.start();
		stage.show();


	}
	public class AnimateObjects extends AnimationTimer
	{

		public void handle(long now)
		{


			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			gc.drawImage(background, 0, 0);
			gc.drawImage(duck, 698, 300);
			gc.drawImage(gun, 0+x, 560);


			Rectangle2D crosshair1 = new Rectangle2D( 0+x,0+y,crosshair.getWidth(), crosshair.getHeight());
			//gc.fillRect( 0+x,0+y,crosshair.getWidth(), crosshair.getHeight());
			Rectangle2D duck1 = new Rectangle2D( 698, 300, duck.getWidth(), duck.getHeight());
			//gc.fillRect( 698, 300, duck.getWidth(), duck.getHeight());


			if (crosshair1.intersects(duck1) )
			{


				System.out.println("HIT");
				score +=500;
			}
			int c = (int)(Math.random()*2)+245;

					if (launch == true)
					{

						for (int i = 0; i < 50; i ++)

							ducks.add(duck);

							int a = 0;
							if (a < 3000)
							{

								c = (int)(Math.random()*234)+245;
								int e = 5;
								e +=50;
								a+=21;

								gc.drawImage(ducks.get(i), 0+a, 345);
							}

					}

gc.drawImage(crosshair, 0+x, 0+y);


		}

	}


		public void handle(final InputEvent event)
		{

			if (event instanceof MouseEvent)
			{

				x = (int)((MouseEvent)event).getX();
				y = (int)((MouseEvent)event).getY();


				//System.out.println( ((MouseEvent)event).getX());
				//System.out.println( ((MouseEvent)event).getY());

			}









		}



}