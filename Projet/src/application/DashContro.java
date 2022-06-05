package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import projet.service.EmployeeService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import connexion.connexion;
public class DashContro implements Initializable {

    public DashContro() {

    }   
    @FXML
   	private Button min;
    @FXML
   	private Button cat;
    @FXML
   	private Button export;
    @FXML
   	private Button afficher;
    @FXML
   	private Button update;
    @FXML
   	private Button clear;
    @FXML
	private Button remove;
	@FXML
	private Button ajouter;
	@FXML
	private Button importBtn;
    @FXML
    private TableView <Salarie> table;
    @FXML
    private TableColumn<Salarie,Integer> col_mat;
    @FXML
    private TableColumn<Salarie,String> col_nom;
    @FXML
    private TableColumn <Salarie,String>col_email;
    @FXML
    private TableColumn<Salarie,Double> col_annee;
    @FXML
    private TableColumn <Salarie,Double>col_salaire;
    @FXML
    private TableColumn <Salarie,String>col_categorie;
    @FXML
	private TextField txt_categorie;
	@FXML
	private TextField txt_nom;
	@FXML
	private TextField txt_email;
	@FXML
	private TextField txt_annee;
	@FXML
	private TextField txt_salaire;
	@FXML
	private TextField txt_matricule;
	private Data data;
    int index = -1 ; 
    Connection conn=null ;
    PreparedStatement pst  =null;
	EmployeeService c = new EmployeeService();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	       this.data=new Data() ;		

	    col_mat.setCellValueFactory(new PropertyValueFactory<Salarie,Integer>("matricule"));
	    col_nom.setCellValueFactory(new PropertyValueFactory<Salarie,String>("nom"));
	    col_email.setCellValueFactory(new PropertyValueFactory<Salarie,String>("email"));
	    col_annee.setCellValueFactory(new PropertyValueFactory<Salarie,Double>("annee"));
	    col_salaire.setCellValueFactory(new PropertyValueFactory<Salarie,Double>("salaire"));
	    col_categorie.setCellValueFactory(new PropertyValueFactory<Salarie,String>("categorie"));
	   

		
	}
	
	@FXML

	protected void Ajouter()
	{ 
		  
	          conn =  connexion.getCon();
	            String req = "insert into salarie (matricule,nom,email,annee,salaire,categorie) values (?,?,?,?,?,?)";
	            
	            try 
	            {
	            	pst=conn.prepareStatement(req);
	            	pst.setInt(1,Integer.parseInt(txt_matricule.getText()));
	            	pst.setString(2,txt_nom.getText());
	            	pst.setString(3,txt_email.getText());
	            	pst.setDouble(4,Double.parseDouble(txt_annee.getText()));
	            	pst.setDouble(5,Double.parseDouble(txt_salaire.getText()));
	            	pst.setString(6,txt_categorie.getText());

	            	pst.execute();
	            } catch (Exception e ) {
	            	
	            }
	            Salarie s = new Salarie (Integer.parseInt(txt_matricule.getText()),txt_nom.getText(),txt_email.getText(),Double.parseDouble(txt_annee.getText()),Double.parseDouble(txt_salaire.getText()),txt_categorie.getText());
	    		data.getImportList().add(s);
	    		table.getItems().add(s);
	}
	@FXML

	protected void select()
	{ 
		Salarie s1 = table.getSelectionModel().getSelectedItem();
		txt_nom.setText(s1.getNom());
		txt_matricule.setText(String.valueOf(s1.getMatricule()));
		txt_email.setText(s1.getEmail());
		txt_annee.setText(String.valueOf(s1.getAnnee()));
		txt_salaire.setText(String.valueOf(s1.getSalaire()));
		txt_categorie.setText(s1.getCategorie());

	}	

	@FXML

    protected void update() {       

        Salarie s = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(s);

        String req = "update salarie set nom ='"+txt_nom.getText()+"', email ='"+txt_email.getText()+"' , annee ='"+Double.parseDouble(txt_annee.getText())+"',salaire ='"+Double.parseDouble(txt_salaire.getText())+"', categorie ='"+txt_categorie.getText()+"' where matricule = "+Integer.parseInt(txt_matricule.getText());
        try {
            Statement st = connexion.getCon().createStatement();
             st.executeUpdate(req);

        } catch (SQLException e) {
        }

        Salarie s2 = new Salarie (Integer.parseInt(txt_matricule.getText()),txt_nom.getText(),txt_email.getText(),Double.parseDouble(txt_annee.getText()),Double.parseDouble(txt_salaire.getText()),txt_categorie.getText());

        data.getImportList().add(s2);

           table.getItems().add(s2);
    }
	 
	@FXML

    protected void sort() {       

		col_annee.setSortType(TableColumn.SortType.ASCENDING);
		table.getSortOrder().add(col_annee);
		table.sort();

      
     
    }
	@FXML

	protected void Supprimer()
{ 
		Salarie s1 = table.getSelectionModel().getSelectedItem();
		table.getItems().remove(s1);
	    
	        c.delete(c.findByMatricule(s1.getMatricule()));
}
	
	@FXML

	protected void clear()
{ 
			table.getItems().clear();
		
}
	@FXML
	protected void handleImportButtonAction()
	{ 
		table.getItems().clear();
	 table.getItems().addAll(data.getImportList());

	}
	@FXML  
	protected void Export() throws IOException     {   
		table.getItems().addAll(data.getExportList());  
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("salarie.txt"), "utf-8"))) {
			for(Salarie str: data.getImportList()) {      
				try { writer.write(str + System.lineSeparator());
				} catch (IOException e) {      
				e.printStackTrace();  
				}   
				}	}
			}
	}
		
	


