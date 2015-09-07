package com.jescy.spotter.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;

import com.jescy.spotter.model.ExerciseDataGridModel;
import com.jescy.spotter.model.ExerciseDecorator;
import com.jescy.spotter.service.ExerciseService;

@ViewScoped
@ManagedBean
public class ExerciseController extends GenericController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private transient ExerciseService exerciseService;
	
	private List<ExerciseDecorator> exerciseDropdown = new ArrayList<ExerciseDecorator>();
	
	private ExerciseDecorator exerciseToInsert = new ExerciseDecorator(); 
	
	private ExerciseDecorator selectedExercise;
	
	private ExerciseDataGridModel dataGridModel = new ExerciseDataGridModel();

	private void refreshDropdown(){
		exerciseDropdown = exerciseService.getExercises();
	}
	
	public void add() {
		exerciseService.saveOrUpdate(exerciseToInsert);
		refreshDropdown();
	}

	public void addToExercise(ActionEvent actionEvent){
		dataGridModel.addExercise(getSelectedExercise());
	}
	
	/**
	 * @return the exerciseDropdown
	 */
	public List<ExerciseDecorator> getExerciseDropdown() {
		if (!FacesContext.getCurrentInstance().isPostback()){
			refreshDropdown();
		}
		return exerciseDropdown;
	}

	/**
	 * @return the exerciseToInsert
	 */
	public ExerciseDecorator getExerciseToInsert() {
		return exerciseToInsert;
	}
	
	/**
	 * @return the selectedExercise
	 */
	public ExerciseDecorator getSelectedExercise() {
		return selectedExercise;
	}

	/**
	 * @param exerciseDropdown the exerciseDropdown to set
	 */
	public void setExerciseDropdown(List<ExerciseDecorator> exerciseDropdown) {
		this.exerciseDropdown = exerciseDropdown;
	}

	/**
	 * @param exerciseToInsert the exerciseToInsert to set
	 */
	public void setExerciseToInsert(ExerciseDecorator exerciseToInsert) {
		this.exerciseToInsert = exerciseToInsert;
	}

	/**
	 * @param selectedExercise the selectedExercise to set
	 */
	public void setSelectedExercise(ExerciseDecorator selectedExercise) {
		this.selectedExercise = selectedExercise;
	}

	/**
	 * @return the dataGridModel
	 */
	public ExerciseDataGridModel getDataGridModel() {
		return dataGridModel;
	}

	/**
	 * @param dataGridModel the dataGridModel to set
	 */
	public void setDataGridModel(ExerciseDataGridModel dataGridModel) {
		this.dataGridModel = dataGridModel;
	}
	
	
}
