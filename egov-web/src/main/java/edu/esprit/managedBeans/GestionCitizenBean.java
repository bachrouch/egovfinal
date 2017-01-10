package edu.esprit.managedBeans;

import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import tn.esprit.domain.Agent;
import tn.esprit.domain.Citizen;
import tn.esprit.services.AgentGestionLocal;
import tn.esprit.services.CitizenGestionLocal;

@ManagedBean
@SessionScoped
public class GestionCitizenBean {
	private String email;
	private String login;
	private String password;
	private Citizen citizen;
	
	public static int idCard;
	private Agent agent;
	public static int idAgent;
	private boolean loggedIn;

	private StreamedContent myImage;
	@EJB
	CitizenGestionLocal citizenService;
	@EJB
	AgentGestionLocal agentService;

	@PostConstruct
	public void init() {

		citizen = new Citizen();
		agent = new Agent();

	}

	public String doLogin() {

		String navigateTo = null;
		citizen = citizenService.Authentification(login, password);
		agent = agentService.Authentification(login, password);
		System.out.println("kkk" + agent);
		// idCard=citizen.getCin();

		if (citizen != null) {
			idCard = citizen.getCin();
			setLoggedIn(true);
			navigateTo = "/citizen/dashboard?faces-redirect=true";

		} else if (agent != null) {
			idAgent = agent.getId();
			setLoggedIn(true);
			navigateTo = "/agent/dashboard?faces-redirect=true";

		} else
			FacesContext.getCurrentInstance().addMessage("fromLogin:btn",
					new FacesMessage("login et/ou password incorrect"));
		return navigateTo;
	}

	public String doUpdate() {

		String navigateTo = null;
		citizenService.update(citizen);
		if (citizen != null) {
			
			navigateTo = "/citizen/dashboard?faces-redirect=true";

		}
		return navigateTo;
	}

	public String doInscription() {
		String navigateTo = null;
		click();
		citizenService.inscription(citizen);
		navigateTo = "/citizen/dashboard?faces-redirect=true";
		return navigateTo;

	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/home.jsf?faces-redirect=true";
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

	public void click() {
		RequestContext requestContext = RequestContext.getCurrentInstance();

		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public StreamedContent getMyImage() {

		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {

			return new DefaultStreamedContent(new ByteArrayInputStream(citizen.getInpic()));
		}

	}

	public void setMyImage(StreamedContent myImage) {
		this.myImage = myImage;
	}

	public static int getIdCard() {
		return idCard;
	}

	public static void setIdCard(int idCard) {
		GestionCitizenBean.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean sendPwd() {
		Citizen citizen = citizenService.recuppererMotDePasse(email);
		if (citizen != null) {
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
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("Password Recovery");
				message.setText("\n \n Votre nom d'utilisateur est: " + citizen.getLogin()
						+ "\n Votre mot de passe est: " + citizen.getPwd()
						+ "\n Merci de ne plus l'oublier la prochaine fois !\n Bonne Journée.");
				Transport.send(message);
				return true;

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		}
		return false;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public static int getIdAgent() {
		return idAgent;
	}

	public static void setIdAgent(int idAgent) {
		GestionCitizenBean.idAgent = idAgent;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
