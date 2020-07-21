package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Criteria;
import Entities.Employee;
import Entities.EvaluationSheet;
import Entities.TypeEvaluationSheet;
import ServiceImpl.CriteriaService;
import ServiceImpl.EvaluationSheetService;

@ManagedBean(name = "criteriaBean") 
@SessionScoped 
public class CriteriaBean  implements Serializable{
	private static long serialVersionUID = 1L;
	private Employee selectEmp;
	private EvaluationSheet selectEv;
	
	public EvaluationSheet getSelectEv() {
		return selectEv;
	}



	public void setSelectEv(EvaluationSheet selectEv) {
		this.selectEv = selectEv;
	}



	public void setSelectEmp(Employee selectEmp) {
		this.selectEmp = selectEmp;
		
	}

	private List<Criteria> criterias;
	private TypeEvaluationSheet typeevaluation;
	private Date date;
	
	public TypeEvaluationSheet getTypeevaluation() {
		return typeevaluation;
	}



	public void setTypeevaluation(TypeEvaluationSheet typeevaluation) {
		this.typeevaluation = typeevaluation;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}
	
	public CriteriaBean() {
		criterias = new ArrayList<>();
	}
	
	

	public List<Criteria> getCriterias() {
		//criterias = criteriaservice.getAllCriterien();
		return criterias;
	}
	public void RemoveCriterien(int criterienId) { criterias.remove(criterienId);}
	public void Removecri(int citerId) {criteriaservice.removeCriterien(citerId);}
	
	
	@EJB 
	EvaluationSheetService evaluationsheetservice;

	public EvaluationSheetService getEvaluationsheetservice() {
		return evaluationsheetservice;
	}



	public void setEvaluationsheetservice(EvaluationSheetService evaluationsheetservice) {
		this.evaluationsheetservice = evaluationsheetservice;
	}

	@EJB 
	CriteriaService criteriaservice;
public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

private String description;
	

	public void addECriterien() { 
		//criteriaservice.ajouterCriteria((new Criteria(description)));
		criterias.add(new Criteria(description));
		
		
	}
	
	public String addEv() {
		EvaluationSheet ev = new EvaluationSheet();
		ev.setCriteria(criterias);
		for(Criteria criteria : criterias) {
			criteria.setEvaluationsheet(ev);
		}
		ev.setTypeevaluation(typeevaluation);
		ev.setEmployee(selectEmp);
		ev.setDate(date);
		int id = criteriaservice.ajouterev(ev);
		System.out.println(typeevaluation);
		criterias.clear();
		return "evaluationForm.xhtml/?faces-redirect=true&sheetID="+ id; 
	}
	
	public String addForm(int id) {
		return "FormulaireCritere.xhtml/?faces-redirect=true&empID="+ id; 
	}
	
	



	public void setAfficheEval(EvaluationSheet afficheEval) {
		this.afficheEval = afficheEval;
	}
	public String ListeSheet(int id) {
		return "ListeSheet.xhtml/?faces-redirect=true&empID="+ id; 
	}
	

	private EvaluationSheet afficheEval ;
	
	


	public EvaluationSheet getAfficheEval() {
		Map<String, String> param =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		if(param.containsKey("empID")) {
			String id = param.get("empID");
			
			this.selectEv = evaluationsheetservice.getevalbyemp(Integer.parseInt(id));
		}
		return selectEv;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public CriteriaService getCriteriaservice() {
		return criteriaservice;
	}

	public void setCriteriaservice(CriteriaService criteriaservice) {
		this.criteriaservice = criteriaservice;
	}

	public String getNew_criteria() {
		return new_criteria;
	}

	public void setNew_criteria(String new_criteria) {
		this.new_criteria = new_criteria;
	}

	private String new_criteria;	
	
	



	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
	}

	public String getNewCriteria() {
		return new_criteria;
	}



	public void setNewCriteria(String new_criteria) {
		this.new_criteria = new_criteria;
	}
	

}
