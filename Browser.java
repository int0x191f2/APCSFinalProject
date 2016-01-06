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
		String currentURL="";
		History history=new History();
		Bookmark bookmarks=new Bookmark();
		JFrame jFrame=new JFrame("Browser");
		JFXPanel jfxPanel=new JFXPanel();
		JButton historyButt=new JButton("History");
		JButton addBookmark=new JButton("Add bookmark");
		JButton bookmarkButt=new JButton("Bookmarks");

		historyButt.setBounds(0,0,120,25);
		addBookmark.setBounds(125,0,250,25);
		bookmarkButt.setBounds(380,0,170,25);
		jfxPanel.setBounds(0,25,1000,800);

		//Display the history for the current browsing session
		historyButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				new HistoryPanel(history);
			}
		});

		bookmarkButt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				new BookmarkPanel(bookmarks);
			}
		});

		addBookmark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev){
				bookmarks.addItem(history.getItems().get(history.getItems().size()-1));
			}
		});

		jFrame.add(jfxPanel);
		jFrame.add(historyButt);
		jFrame.add(addBookmark);
		jFrame.add(bookmarkButt);
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
