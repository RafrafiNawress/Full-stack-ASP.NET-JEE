package managedBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

import TrainingService.statService;




@ManagedBean
public class statBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel1 = new PieChartModel();
	private PieChartModel pieModel2;
	@EJB
	statService Service;

	@PostConstruct
	public void init() {
		createPieModel1();
       
	}

	public PieChartModel getPieModel1() {
		long res1 = Service.getNombredevJPQL();
		long res2 = Service.getNombrecompJPQL();
		long res3 = Service.getNombrefinJPQL();
		long res4 = Service.getNombredsJPQL();
		long res5 = Service.getPoureRequestJPQL();
		this.pieModel1.set("JavaEE", res1 * 100 / res5);
		this.pieModel1.set(".net", res2 * 100 / res5);
		this.pieModel1.set("sql", res3 * 100 / res5);
		this.pieModel1.set("Data Science", res4 * 100 / res5);

		this.pieModel1.setTitle("Les Specialite par Training En %");
		this.pieModel1.setLegendPosition("w");
		this.pieModel1.setShadow(false);
		return pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private void createPieModels() {
		createPieModel1();
		

	}

	private void createPieModel1() {
		pieModel1 = new PieChartModel();

	
	}

	public void setPieModel1(PieChartModel pieModel1) {
		
		this.pieModel1 = pieModel1;
	}
	
	

}