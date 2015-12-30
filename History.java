import java.util.ArrayList;
public class History{
    ArrayList<String> items;
    public History(){
        items=new ArrayList<String>();
    }
    public void addItem(String item){
		items.add(item);
    }
    public ArrayList<String> getItems(){
        return items;
    }
}
