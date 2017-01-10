package edu.esprit.managedBeans;

import java.io.Serializable; 

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tn.esprit.domain.Poste;
import tn.esprit.domain.Request;
import tn.esprit.services.PostGestionLocal;
import tn.esprit.services.RequestGestionLocal;;

@ManagedBean
@SessionScoped
public class GestionPostBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ciiin;
	private Poste receipt ;
	private Poste receipt1 ;
	private Request request;
	
	private int cinn;
	private String ln;
	private String fn;
	private int ncc;
	private long iban;
	private boolean display;
	
	@EJB
	PostGestionLocal PostGestionLocal;
     @EJB
	RequestGestionLocal requestGestionLocal; 
	
	@PostConstruct
	public void init(){
		setRequest(new Request());
		display=false;
		ln=null;
		fn=null;
		cinn=0;
		iban=0;
		ncc=0;
	}

	
	public Poste getReceipt() {
		return receipt;
	}


	public void setReceipt(Poste receipt) {
		this.receipt = receipt;
	}


	public void doSave(){
		//String navigateTo=null; 
		//Boolean aa;
			request.setEtat(0);
			request.setDepartement("Poste");
			request.setCin(cinn);
			
			
			String service="subscription post  /  "+ ln+" / "+fn+" / "+cinn+" / ";
			
			
			request.setService(service);
		
			requestGestionLocal.addRequest(request);
//				if(aa)
//					navigateTo = "/citizen/asked?faces-redirect=true";
				
			init();
		
				//return navigateTo;
		
	}

	public void show(int cin){
		receipt1 = PostGestionLocal.findReceiptByCin(cin);
		display=true;

	}


	public boolean isDisplay() {
		return display;
	}


	public void setDisplay(boolean display) {
		this.display = display;
	}


	public int getCiiin() {
		return ciiin;
	}


	public void setCiiin(int ciiin) {
		this.ciiin = ciiin;
	}

	public Poste getReceipt1() {
		return receipt1;
	}


	public void setReceipt1(Poste receipt1) {
		this.receipt1 = receipt1;
	}


	public int getCinn() {
		return cinn;
	}


	public void setCinn(int cinn) {
		this.cinn = cinn;
	}


	public String getLn() {
		return ln;
	}


	public void setLn(String ln) {
		this.ln = ln;
	}


	public String getFn() {
		return fn;
	}


	public void setFn(String fn) {
		this.fn = fn;
	}


	public Request getRequest() {
		return request;
	}


	public void setRequest(Request request) {
		this.request = request;
	}


	public int getNcc() {
		return ncc;
	}


	public void setNcc(int ncc) {
		this.ncc = ncc;
	}


	public long getIban() {
		return iban;
	}


	public void setIban(long iban) {
		this.iban = iban;
	}
	
	public void ajout(){
		Poste pp = new Poste();
		pp.setCin(cinn);
		pp.setFname(fn);
		pp.setLname(ln);
		pp.setNcc(ncc);
		pp.setIban(iban);
		PostGestionLocal.addReceipt(pp);
		init();
		
	}
}
