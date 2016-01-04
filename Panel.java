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
public class Panel{
    JFrame frame;
    public Panel(String title){
        frame=new JFrame(title);
    }
    public void displayPanel(){
        this.frame.setVisible(true);
    }
    public JFrame getFrame(){
        return frame;
    }
}
