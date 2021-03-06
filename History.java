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
	 * @param item to add to history
	 */
    public void addItem(String item){
		items.add(item);
    }
	/**
	 * Gets an arraylist of all history items
	 * @return arraylist of history values
	 */
    public ArrayList<String> getItems(){
        return items;
    }
	/**
	 * Gets amount of history items
	 * @return int count of history items
	 */
	public int getItemCount(){
		int count=0;
		for(int i=0;i<items.size();i++){
			count++;
		}
		return count;
	}
}
