package tn.esprit.services;


import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.Clustered;

@Stateful
@Clustered
@Remote(CounterServiceRemote.class)
public class CounterService implements CounterServiceRemote {

	int counter=0;
	
	@PostConstruct
	public void init(){
		
		System.out.println(" SFSB initiated successfully! ");
	}
	
	@Override
	public int doIncrementCounter() {
		counter++;
		System.out.println("Counter: " + counter);
		return counter;
	}

}
