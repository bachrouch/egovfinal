package edu.esprit.managedBeans;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Table;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.domain.Request;
import tn.esprit.services.AgentGestionLocal;
import tn.esprit.services.RequestGestionLocal;

@ManagedBean
@ViewScoped
public class GestionRequestBean {
	private Request  request2;
	
	

	public Request getRequest2() {
		return request2;
	}
	public void setRequest2(Request request2) {
		this.request2 = request2;
	}

	private String fname;
	private String lname;
	private int cin;
	private  Date birthDate;
	private String residencePlace;
	private String university;
	private Request request1;
	private List <Request> requests;
	private List<Request> req;
	
	private String department;
	@EJB
	RequestGestionLocal requestGestionLocal;
	AgentGestionLocal agentService;
	@PostConstruct
	public void init() {
		//success ="";
		request1 =new Request();
		req=requestGestionLocal.findRequestByDepartementState(requestGestionLocal.findRequestById(GestionCitizenBean.idAgent).getDepartement());
		setRequests(requestGestionLocal.findRequestByCin(GestionCitizenBean.idCard));
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getResidencePlace() {
		return residencePlace;
	}
	public void setResidencePlace(String residencePlace) {
		this.residencePlace = residencePlace;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	//private String success;
	
	public Request getRequest1() {
		return request1;
	}
	public void setRequest1(Request request1) {
		this.request1 = request1;
	}
	
	
	
//	public void doSave() {
//		
//		requestGestionLocal.addRequest(request1);
//		//success="bien ajouté";
//		
//		
//	}
	

	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	public RequestGestionLocal getRequestGestionLocal() {
		return requestGestionLocal;
	}
	public void setRequestGestionLocal(RequestGestionLocal requestGestionLocal) {
		this.requestGestionLocal = requestGestionLocal;
		
	
	}
	
	
	public AgentGestionLocal getAgentService() {
		return agentService;
	}
	public void setAgentService(AgentGestionLocal agentService) {
		this.agentService = agentService;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String doServiceDiplome(){
		String serv="";
		serv="Asking for a Diploma :"+" / "+fname+" / "+lname+" / "+cin+" / "+birthDate+" / "+residencePlace+" / "+university;
		return serv;
	}
	
	public String addaskDiplome(){
		String navigateTo = null;
		Boolean activ;
		request1.setDepartement("Hight Education  Ministry");
		request1.setEtat(0);
		request1.setService(doServiceDiplome());
		request1.setCin(GestionCitizenBean.idCard);
		activ = requestGestionLocal.addRequest(request1);
		if(activ)
			navigateTo = "/citizen/asked?faces-redirect=true";
		return navigateTo;
	}
	public String addinscri(){
		String navigateTo = null;
		Boolean activ;
		request1.setDepartement("Hight Education  Ministry");
		request1.setEtat(0);
		request1.setService(doServiceinscri());
		request1.setCin(GestionCitizenBean.idCard);
		activ = requestGestionLocal.addRequest(request1);
		if(activ)
			navigateTo = "/citizen/asked?faces-redirect=true";
		return navigateTo;
	}
	
	public String doServiceinscri(){
		String serv="";
		doRequestDepartement();
		serv="Asking for an inscription  :"+" / "+fname+" / "+lname+" / "+cin+" / "+birthDate+" / "+residencePlace+" / "+university;
		return serv;
	}
	
public void doPdf( String a , String b , String c , String d , String e){
		
		Document document = new Document();
		document.newPage();
		try {

			
			
		

		
			PdfWriter.getInstance(document,

					new FileOutputStream("D:\\lol.pdf"));

			document.open();

			Font font = new Font(Font.FontFamily.TIMES_ROMAN, 48, Font.ITALIC | Font.BOLD | Font.BOLD);
//			for (int i = 1 ; i<= accountSelected.length ; i++){
//				Paragraph p1 = new Paragraph(accountSelected[i]);
//			}
			Paragraph p1 = new Paragraph("your first name : " + a);
			Paragraph p2 = new Paragraph("your last name : "+b);
			Paragraph p3 = new Paragraph( "your birthdate :" +c);
			Paragraph p4 = new Paragraph("your university : " +d);
			Paragraph p5 = new Paragraph("your residance Plac:"+e);
			
			

			p1.setAlignment(Element.ALIGN_CENTER);
			p2.setAlignment(Element.ALIGN_CENTER);
			p3.setAlignment(Element.ALIGN_CENTER);
			p4.setAlignment(Element.ALIGN_CENTER);
			p5.setAlignment(Element.ALIGN_CENTER);
			
			document.add(p1);

			// add blank line
			document.add(Chunk.NEWLINE);
			document.add(p2);
			document.add(Chunk.NEWLINE);
			document.add(p3);
			document.add(Chunk.NEWLINE);
			document.add(p4);
			document.add(Chunk.NEWLINE);
			document.add(p5);
			document.close();
		} catch (Exception n) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		document.close();

	}
public List<Request> disp(String departement){
	requests=requestGestionLocal.findRequestByDepartement(departement);
	return requests;
	
}

public List<Request> doRequestDepartement(){
	List<Request> r;
	r=requestGestionLocal.findRequestByDepartementState(requestGestionLocal.findRequestById(GestionCitizenBean.idAgent).getDepartement());
	return r;
}
public List<Request> getReq() {
	return req;
}
public void setReq(List<Request> req) {
	this.req = req;
}

//public String doActiverDesactiver(Request etudiant){
//	String navigateTo = null;
//	if (etudiant.getEtat()==0) {
//		etudiant.setEtat(1);
//	}else {
//		etudiant.setEtat(0);
//	}
//	agentService.sauvegarderUtilisateur(etudiant);
//	req = requestGestionLocal.affichageRequest();
//	return navigateTo;
//}
	
}
