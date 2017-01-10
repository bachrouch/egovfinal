package edu.esprit.managedBeans;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.context.RequestContext;

import tn.esprit.domain.Reclamation;
import tn.esprit.services.ClaimGestionLocal;


@ManagedBean
@ViewScoped
public class ReclamationBean  implements Serializable {
	/**
	 * 
	 */
	 private Map<Long, Boolean> checked = new HashMap<Long, Boolean>();
	public  boolean  displaytable; 
	 private List<String> selectedConsoles;
	private List<Reclamation> selectedListReclamation;
	public String msg;
	public String name;
	public String subject;
	public String mailAddress;
	public boolean cocher;
	private   boolean Activerformulaire;

	public boolean isCocher() {
		return cocher;
	}



	public void setCocher(boolean cocher) {
		this.cocher = cocher;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getMailAddress() {
		return mailAddress;
	}



	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}



	public Map<Long, Boolean> getChecked() {
		return checked;
	}



	public void setChecked(Map<Long, Boolean> checked) {
		this.checked = checked;
	}



	public boolean isDisplaytable() {
		return displaytable;
	}



	public void setDisplaytable(boolean displaytable) {
		this.displaytable = displaytable;
	}



	public String Typeclaim;
	 private Reclamation reclamation ;
	 
	 
		private List<Reclamation> reclamations;
		private String ResultRecheche;
		
		@EJB
		ClaimGestionLocal claimGestionLocal; 
		

		@PostConstruct
		public void init() {
		
			setReclamation(new Reclamation());
			setReclamations(claimGestionLocal.chercherReclamation());
		   displaytable=true;
			 if (reclamations.size()==0){
					FacesMessage message =new FacesMessage("ERROR:","validation error. You must enter a value.");
					FacesContext.getCurrentInstance().addMessage("nom", message);
					
				 setDisplaytable(false);
				}else {
			 setDisplaytable(true);
		
		}
			setActiverformulaire(false);
			
		}
		
		
		
		public boolean isActiverformulaire() {
			return Activerformulaire;
		}



		public void setActiverformulaire(boolean activerformulaire) {
			Activerformulaire = activerformulaire;
		}



		public Reclamation getReclamation() {
		return reclamation;
		}




	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}



     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }



		
		
		public  String DoAddClaim(){
			String navigateTo = null;
			FacesMessage message =new FacesMessage("ERROR:","validation error. You must enter a value.");
			FacesContext.getCurrentInstance().addMessage("nom", message);
	
				
			claimGestionLocal.addClaim(reclamation);
			navigateTo = "/agent/DispClaims?faces-redirect=true";
			init();
			
	
			return navigateTo;
		}

		public List<Reclamation> getReclamations() {
			return reclamations;
		}


		public void setReclamations(List<Reclamation> reclamations) {
			this.reclamations = reclamations;
		}

		public  String  doDelete( Reclamation reclamation){
			
			claimGestionLocal.deleteClaim( reclamation);
		init();
			addMessage("System Error", "Please try again later.");
			 if (reclamations.size()==0){
				 setDisplaytable(false);
				
				 return null; 
		}else {
			 setDisplaytable(true);
			 init();
		}
		
		
			return null ;
		}
		public  String  doDelete2( ){
			init();
			return null ;
		}
		public  String  doRecherche( String typeclaim){
			/*if (typeclaim.equals("Technical")){
				 setReclamations(claimGestionLocal.findReclamationByType(typeclaim));
				return null ;
			}*/
		
		 if (typeclaim.equals("")){
			 setReclamations(claimGestionLocal.chercherReclamation());
			 if (reclamations.size()==0){
				 setDisplaytable(false);
				 return null; 
		}else {
			 setDisplaytable(true);
		}
			 
			 return null ; 
		 }
		 else if (typeclaim.equals("Technical")){
			 setReclamations(claimGestionLocal.findReclamationByType(typeclaim));
		if (reclamations.size()==0){
				 setDisplaytable(false);
				 return null; 
		}else {
			 setDisplaytable(true);
		}
		
			 return null ;
		} else if (typeclaim.equals("Services")){
			 setReclamations(claimGestionLocal.findReclamationByType(typeclaim));
			 if (reclamations.size()==0){
				 setDisplaytable(false);
				 return null; 
		}else {
			 setDisplaytable(true);
		}
			 return null ;
		} 
		 
	
			return null ;
			}

		public String getResultRecheche() {
			return ResultRecheche;
		}


		public void setResultRecheche(String resultRecheche) {
			ResultRecheche = resultRecheche;
		}



		public String getTypeclaim() {
			return Typeclaim;
		}



		public void setTypeclaim(String typeclaim) {
			Typeclaim = typeclaim;
		}



		public List<String> getSelectedConsoles() {
			return selectedConsoles;
		}



		public void setSelectedConsoles(List<String> selectedConsoles) {
			this.selectedConsoles = selectedConsoles;
		}





	



		public List<Reclamation> getSelectedListReclamation() {
			return selectedListReclamation;
		}



		public void setSelectedListReclamation(List<Reclamation> selectedListReclamation) {
			this.selectedListReclamation = selectedListReclamation;
		}


		 public String submit() {
		        //List<Item> checkedItems = new ArrayList<Item>();
System.err.println("ok1");
		        for (Reclamation reclam: reclamations) {
		        	System.err.println("ok2");
		            if (checked.get(reclam.getId())) {
		            	System.err.println("ok3");
		        		claimGestionLocal.deleteClaim( reclam);
		        	
		        		
		            }
		        }
		   	 setCocher(false);
		        checked.clear(); // If necessary.
		        init();
		        return "/agent/DispClaims?faces-redirect=true";
		        // Now do your thing with checkedItems.
		    }

		    public void viewCars() {
		        Map<String,Object> options = new HashMap<String, Object>();
		        options.put("resizable", false);
		        RequestContext.getCurrentInstance().openDialog("ViewMail", options, null);
		    }

		    public void Doadress(String Adresse){
		    
		    	
		    	 System.out.println(Adresse);
		    	setMailAddress(Adresse);
		    	 System.out.println(mailAddress+"ooo");
		    
		    	
		    			
		    			
		    }
		    
		    
		    
		    public boolean sendPwd() {
		    	System.out.println(mailAddress+"okkkkk");
				//Citizen citizen = citizenService.recuppererMotDePasse(email);
				
					final String username = "admegovernment@gmail.com";
					final String password = "dreamteam";
					Properties properties = new Properties();
					properties.put("mail.smtp.auth", "true");
					properties.put("mail.smtp.starttls.enable", "true");
					properties.put("mail.smtp.host", "smtp.gmail.com");
					properties.put("mail.smtp.port", "587");

					Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					});
					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress("noreply@egov.tn"));
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailAddress));
						message.setSubject("Response to your claim ok");
						message.setText("\n " +subject
								+"!\n Have a good day.");
						Transport.send(message);
						setSubject(null);
						setActiverformulaire(false);
						return true;

					} catch (MessagingException e) {
						throw new RuntimeException(e);
					}
					

				
		    }
		
			
			

	}
