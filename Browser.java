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
		JButton butt=new JButton("History");
		butt.setBounds(0,0,120,25);
		jfxPanel.setBounds(0,25,1000,800);

		//Display the history for the current browsing session
		butt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				new HistoryPanel(history);
			}
		});

		jFrame.add(jfxPanel);
		jFrame.add(butt);
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		Platform.runLater(() -> {
			WebView webView=new WebView();
			jfxPanel.setScene(new Scene(webView));
			webView.getEngine().load("http://www.ddg.gg/");
			webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
				@Override
				public void changed(ObservableValue ov, State oldState, State newState) {
					if (newState == Worker.State.SUCCEEDED) {
						history.addItem(webView.getEngine().getTitle()+" - "+webView.getEngine().getLocation());
					}

				}
			});
		});

		jFrame.setVisible(true);
	}

}
