import java.util.ArrayList;
public class History{
    ArrayList<String> items;
	/**
	 * Constructor for History
	 */
    public History(){
        items=new ArrayList<String>();
    }
	/**
	 * Adds items to the history
	 * @param String item to add to history
	 */
    public void addItem(String item){
		items.add(item);
    }
	/**
	 * Gets an arraylist of all history items
	 * @return ArrayList<String> arraylist of history values
	 */
    public ArrayList<String> getItems(){
        return items;
    }
}
