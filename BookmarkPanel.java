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
public class BookmarkPanel extends Panel{
    JList list;
    JScrollPane scrollPane;
    public BookmarkPanel(Bookmark bookmark){
        super("Bookmarks");
        list=new JList(bookmark.getItems().toArray());
        scrollPane=new JScrollPane(list);
        getFrame().add(scrollPane);
        displayPanel();
    }
}
