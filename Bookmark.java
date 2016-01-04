import java.util.ArrayList;
public class Bookmark{
    ArrayList<String> bookmarks;
    /**
     * Constructor for bookmark
     */
    public Bookmark(){
        bookmarks=new ArrayList<String>();
    }
    public void addItem(String item){
        bookmarks.add(item);
    }
    public ArrayList<String> getItems(){
        return bookmarks;
    }
}
