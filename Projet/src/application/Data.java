package application;

import java.util.ArrayList;
import java.util.List;

import connexion.connexion;
import projet.service.EmployeeService;

public class Data {
	private List<Salarie> importList;
	private List<Salarie> exportList;

    EmployeeService c = new EmployeeService();

		public Data() {
			 connexion.getCon();

			importList = new ArrayList<Salarie>();
			 for(Salarie c2 : c.findAll())
			importList.add( new Salarie(c2.getMatricule(),c2.getNom(),c2.getEmail(),c2.getAnnee(),c2.getSalaire(),c2.getCategorie()));
		
			exportList = new ArrayList<Salarie>(); 
		} 
		public List<Salarie> getImportList() {
			return importList;
		} 
		public List<Salarie> getExportList() {
			return exportList; 
		} 
		public void setExportList(List<Salarie> exportList) {
			this.exportList.addAll( exportList);
			for(Salarie p :this.exportList)
				System.out.println(p); 
		} 

}
