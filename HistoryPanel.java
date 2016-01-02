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
public class HistoryPanel{
    JFrame frame;
    JList list;
    JScrollPane scrollPane;
    public HistoryPanel(History history){
        frame=new JFrame("History");
        list=new JList(history.getItems().toArray());
        scrollPane=new JScrollPane(list);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
