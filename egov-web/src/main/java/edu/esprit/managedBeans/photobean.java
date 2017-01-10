package edu.esprit.managedBeans;


import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import tn.esprit.domain.Citizen;
import tn.esprit.services.CitizenGestionLocal;



@ManagedBean
@RequestScoped
public class photobean implements Serializable{
	
	private Citizen citizen;
	
	private StreamedContent myImage;
	

	@EJB
	 CitizenGestionLocal citizenGestionLocal;
	@PostConstruct
	public void init() {
		
		setCitizen(new Citizen());
		
		

	}
	
	public StreamedContent getMyImage() {
		
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            return new DefaultStreamedContent();
        }
        else {
         
           
            return new DefaultStreamedContent(new ByteArrayInputStream(citizen.getInpic()));
        }
    
}


	
	public void setMyImage(StreamedContent myImage) {
		this.myImage = myImage;
	}
	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	


}
