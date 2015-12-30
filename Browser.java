import javafx.scene.web.WebView;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.application.Platform;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import javafx.concurrent.Worker.State;
import javafx.beans.value.*;
import javafx.concurrent.*;
public class Browser{
	public static void main(String[] args){
		History history=new History();
		JFrame jFrame=new JFrame("Browser");
		JFXPanel jfxPanel=new JFXPanel();

		jFrame.add(jfxPanel);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Platform.runLater(() -> {
			WebView webView=new WebView();
			jfxPanel.setScene(new Scene(webView));
			webView.getEngine().load("http://www.ddg.gg/");
			webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				@Override
				public void changed(ObservableValue ov, State oldState, State newState) {
					if (newState == Worker.State.SUCCEEDED) {
						System.out.println(webView.getEngine().getLocation());
						history.addItem(webView.getEngine().getLocation());
						System.out.println(history.getItems());
					}

				}
			});
		});

		jFrame.setVisible(true);
	}

}
