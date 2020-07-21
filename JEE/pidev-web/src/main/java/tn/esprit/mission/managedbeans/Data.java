package tn.esprit.mission.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Entities.Role;
import Entities.Type;
import Entities.TypeEvaluationSheet;

@ManagedBean(name="data")
@ApplicationScoped
public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Type[] getTypes() { return Type.values(); }
	public Role[] getRoles() { return Role.values(); }
	public TypeEvaluationSheet[] getType() 
	{ 
		return TypeEvaluationSheet.values();
	}}
