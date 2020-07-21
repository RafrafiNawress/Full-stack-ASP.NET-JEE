package managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;

import Entities.Criteria;
import Entities.Employee;
import Entities.EvaluationSheet;
import Entities.TypeEvaluationSheet;
import ServiceImpl.EvaluationSheetService;

@ManagedBean(name = "evaluationsheetBean") 
@SessionScoped 
public class EvaluationSheetBean implements Serializable {

	private static long serialVersionUID = 1L;
	private EvaluationSheet selectedEv;
	
	
	
	public EvaluationSheetBean() {
		
	}


	private List<Employee> employes;



	public List<Employee> getEmployes() {
		employes = evaluationsheetservice.getAllEmployes(); return employes;
	}



	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
	}


	@EJB 
	EvaluationSheetService evaluationsheetservice;
	
	@NotNull(message="champ vide")
	private TypeEvaluationSheet typeevaluation;
	private Date date;
	
	private Float score;



	public void addEvaluationSheet() { evaluationsheetservice.ajouterEvaluationSheet((new EvaluationSheet(typeevaluation,score))); 
	}
	
	
	public String redirect() {
		return "/Ajout.xhtml?faces-redirect=true";   
	}
	


	public EvaluationSheet getSelectedEv() {
		Map<String, String> params =FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
		if(params.containsKey("sheetID")) {
			String id = params.get("sheetID");
			this.selectedEv = evaluationsheetservice.findEvalById(Integer.parseInt(id));
		}
		return selectedEv;
	}
	


	



	



	public void setSelectedEv(EvaluationSheet selectedEv) {
		this.selectedEv = selectedEv;
	}
	
	public void save() {
		selectedEv.setScore(getNotefina());
		
		evaluationsheetservice.updateEval(selectedEv);
		
		
		
		
	}
	public void save2()
	{ evaluationsheetservice.updateEvalscore(selectedEv);}

	private int Notefina;
	
	public int getNotefina() {
		 {
				List<Criteria> c= selectedEv.getCriteria();
				int score=0;
				int result;
				int taille;
				for(Criteria criteria : c) {
					score=score+criteria.getNote();
				}
				taille=c.size();
				result=score/taille;
				return result;
			}
	}



	public void setNotefina(int notefina) {
		Notefina = notefina;
	}



	public void RemoveEval(int evaluationId) { evaluationsheetservice.removeEval(evaluationId);}

	private Integer employeIdToBeUpdated;
	public void displayEval(EvaluationSheet eval)
	{
		this.setTypeevaluation(eval.getTypeevaluation());
		this.setScore(eval.getScore());

	}
	private List<EvaluationSheet> evaluations;
	
	
	
	public void deleteAllevaluationJPQL() {
		evaluationsheetservice.deleteAllevaluationJPQL();
	};

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}



	public static void setSerialVersionUID(long serialVersionUID) {
		EvaluationSheetBean.serialVersionUID = serialVersionUID;
	}



	public EvaluationSheetService getEvaluationsheetservice() {
		return evaluationsheetservice;
	}



	public void setEvaluationsheetservice(EvaluationSheetService evaluationsheetservice) {
		this.evaluationsheetservice = evaluationsheetservice;
	}



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



	public Float getScore() {
		return score;
	}



	public void setScore(Float score) {
		this.score = score;
	}



	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}



	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}



	public void setEvaluations(List<EvaluationSheet> evaluations) {
		this.evaluations = evaluations;
	}



	public List<EvaluationSheet> getEvaluations() {
		evaluations = evaluationsheetservice.getAllEval(); 
		return evaluations;
	}



	public void updateEval()
	{ evaluationsheetservice.updateEval(new EvaluationSheet(employeIdToBeUpdated,typeevaluation,score)); }


}