import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{
	 	
	@FXML
	    private Button btn1;
	/*@FXML
	public static  ArrayList<String> Listmenus=new ArrayList<String>();
	@FXML
	public static ArrayList<Integer> Listquantity=new ArrayList<Integer>();
	@FXML
	public static ArrayList<Double> Listprix=new ArrayList<Double>();
	@FXML
	public static ArrayList<Double> Listtotal=new ArrayList<Double>();

	    @FXML
	    private Button btn2;

	*/    @FXML   private Label lb1;

          double sum=0.00;
    
	    @FXML   private Label lb2;

	    @FXML   private Label lb3;

	    @FXML   private Label lb4;

	    @FXML   private ListView<String> totlist;

	    @FXML   private TextField txt1;

	    @FXML   private TextArea txtarea;

	    @FXML   private TextField txt3;

	    @FXML  private TableColumn<Product, String> pid;

	    @FXML  private TableColumn<Product, Double> pu;

	    @FXML  private TableColumn<Product, Integer> qty;

	    @FXML  private TableView<Product> tb;

	    @FXML  private ComboBox<Integer> combo1;

	    @FXML  private TableColumn<Product, Double> tp;
	    
	    @FXML  private TextField fntxt;
	    
	    
	    @FXML  private TextField txtno;

	String[] Menus= {"nann-2.00","pouletcurry-3.50","legumescurry-3.00",
			       "salade-2.00","pizza-5.00","jusdefruitmixed-1.50","sorbet-2.00",
			         "glace-2.00","soupe-2.00"};
	
	String Choisi;	
	
	@Override
	public void initialize(URL arg0,ResourceBundle arg1)
	{
	totlist.getItems().addAll(Menus);
	 //Product(String item,Integer quantity, Double prixunitaire, Double prixtotal)
	pid.setCellValueFactory(new PropertyValueFactory<Product,String>("items"));
	qty.setCellValueFactory(new PropertyValueFactory<Product,Integer>("quantities"));
	pu.setCellValueFactory(new PropertyValueFactory<Product,Double>("prixunitaires"));		 
	tp.setCellValueFactory(new PropertyValueFactory<Product,Double>("prixtotale"));
	
	totlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		
		
		@Override
		public void changed(ObservableValue<? extends String>arg0, String arg1,String arg2) {
				//String arg2,String arg3,String arg4,String arg5,String arg6,String arg7,String arg8,String arg9) {
		Choisi = totlist.getSelectionModel().getSelectedItem();
		int i = totlist.getSelectionModel().getSelectedIndex();
		System.out.println("the value of index of totlist menus"+i);
		
		for(int j=0;j<Menus.length;j++)
		{
			if(j==i)
			{
		String[] Prixu =Menus[i].split("-");
		String prixu1 =Prixu[0];
		String prixu2 =Prixu[1];
		txt1.setText(prixu1);
		txt3.setText(prixu2);
		}
		}
		}
	
	});
	combo1.getItems().addAll(1,2,3,4,5,6,7,8,9);
	
	}
	
	public void continuer(ActionEvent e)
	{
		
		double x = (combo1.getValue())*(Double.valueOf(txt3.getText()));
		txtno.setText(String.valueOf(x));
		sum = sum + (Double.valueOf(txtno.getText()));
		//txtarea.setText(txt1.getText()+"  "+combo1.getValue()+"  "+txt3.getText()+"  "+txtno.getText());
		//txt1.clear();
		//txt3.clear();
		
		/*Listmenus.add(txt1.getText());
		Listquantity.add(Integer.valueOf(combo1.getValue()));
		Listprix.add(Double.valueOf(txt3.getText()));
		Listtotal.add(Double.valueOf(txtno.getText()));
		
		System.out.println(Listmenus);
		System.out.println(Listquantity);
		System.out.println(Listprix);
		System.out.println(Listtotal);*/
		//tb.getColumns().add(0, pid);
		
		//Product.getItems().add(txtarea.getText());
		//tb.getItems().addAll(txtarea.getText());
		
		
		tb.getItems().addAll(new Product(txt1.getText(),Integer.valueOf(combo1.getValue()),Double.valueOf(txt3.getText()),Double.valueOf(txtno.getText())));
		ObservableList<Product> tb =FXCollections.observableArrayList();
		txt1.clear();
		txt3.clear();
		combo1.setValue(0);
	}
	
	public void printbill(ActionEvent ee)
	{
			
		fntxt.setText(String.valueOf(sum));
      		
	}
	

}
