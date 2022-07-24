import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public  class Product {
     private  SimpleStringProperty items;
	 private  SimpleIntegerProperty quantities;
	 private  SimpleDoubleProperty prixunitaires;
	 private  SimpleDoubleProperty prixtotale;
	 
	 Product(String item,Integer quantity, Double prixunitaire, Double prixtotal) {
	 this.items = new SimpleStringProperty(item);
	 this.quantities = new SimpleIntegerProperty(quantity);
	 this.prixunitaires = new SimpleDoubleProperty(prixunitaire);
	 this.prixtotale = new SimpleDoubleProperty(prixtotal);
	 }
	 public String getItems() {
	 return items.get();
	 }
	 public void setItems(String item) {
		 items.set(item);
	 }

	 public Integer getQuantities() {
	 return quantities.get();
	 }
	 public void setQuantities(Integer quantity) {
	 quantities.set(quantity);
	 }

	 public Double getPrixunitaires() {
	 return prixunitaires.get();
	 }
	 public void setPrixunitaires(Double prixunitaire) {
		 prixunitaires.set(prixunitaire);
	 }
	 public Double getPrixtotale() {
		 return prixtotale.get();
		 }
		 public void setPrixtotale(Double prixtotal) {
			 prixtotale.set(prixtotal);
		 }

	}