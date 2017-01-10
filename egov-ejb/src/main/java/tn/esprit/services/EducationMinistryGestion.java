package tn.esprit.services;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.ejb3.annotation.Clustered;

import tn.esprit.domain.HightEducationMinistry;


/**
 * Session Bean implementation class EducationMinistryGestion
 */
@Stateful
@Clustered
@Remote(EducationMinistryGestionRemote.class)

public class EducationMinistryGestion implements EducationMinistryGestionRemote, EducationMinistryGestionLocal {

	@PersistenceContext(unitName="egovernment")
    EntityManager em;
    public EducationMinistryGestion() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addStudent(HightEducationMinistry student) {
		try {
			em.persist(student);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}
	
	
	
    
	@Override
	public HightEducationMinistry findStudentByCin(int cin21) {
		
		
		HightEducationMinistry std=null;
		try {
			
			Query queryBCbyCin = em.createQuery("SELECT m FROM HightEducationMinistry m WHERE m.cin=:cin1");
			queryBCbyCin.setParameter("cin1", cin21);
			std = (HightEducationMinistry) queryBCbyCin.getSingleResult();
			return std;
			
		} catch (Exception e) {
			System.out.println(e+"erreur");
			return null;
		}
	}

	@Override
	public Boolean addDiploma(HightEducationMinistry student, byte[] diploma) {
		HightEducationMinistry std=null;
		std = student;
		try {
			std.setDiploma(diploma);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public byte[] extractBytes (String ImageName) {
		 // open image
		 File imgPath = new File(ImageName);
		 BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(imgPath);
			WritableRaster raster = bufferedImage .getRaster();
			 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
			 return ( data.getData() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 // get DataBufferBytes from Raster
		 

		 return null;
		}



	@Override
	public byte[] findDiplomaByCin(int cin) {
		HightEducationMinistry std;
		std = findStudentByCin(cin);
		return std.getDiploma();	
		//return null;
	}

	@Override
	public Boolean modifyStudent(HightEducationMinistry student) {
		try {
			em.merge(student);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateDiploma(HightEducationMinistry student) {
		
		//student.setDiploma(d);
		em.merge(student);
		return true;
	}

	@Override
	public Boolean deleteStudent(int cin) {
	HightEducationMinistry std;
		try {
			
		std = findStudentByCin(cin);
			
			em.remove(em.merge(std));
			
			return true;
			
		} 
		catch (Exception e) {
			return false;
		}
		
	}

	/*@Override
	public boolean addDiplona(HightEducationMinistry student, String path) {
		HightEducationMinistry a = new HightEducationMinistry();
		a.setDiploma();
		return false;
	}*/
	
	@Override
	
	public HightEducationMinistry findStudentById(int id) {
		HightEducationMinistry std = null;
		Query qr;
		try {
			qr= em.createQuery("SELECT c FROM  HightEducationMinistry c WHERE c.id=:id");
			qr.setParameter("id", id);
			std=(HightEducationMinistry) qr.getSingleResult();
			return std;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return std;
	}

	@Override
	public boolean updateStudent(int cin, String name, String lastname, String adress, String level,
			String establisement, Date date) {
		HightEducationMinistry std;
		try {
			std=findStudentByCin(cin);
		std.setFname(name);
			std.setLname(lastname);
			std.setBirthdate(date);
		  std.setAdress(adress);
		  std.setEstablisment(establisement);
	
		std.setLevel(level);
			em.merge(std);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	
	}
	@Override
	public HightEducationMinistry afficherStudent(int cin1) {
		HightEducationMinistry person=new  HightEducationMinistry();
		Query qr;
		try {
			qr=em.createQuery("SELECT p FROM HightEducationMinistry p WHERE p.cin=:cin ");
			qr.setParameter("cin",cin1);
			person = (HightEducationMinistry)qr.getSingleResult();
			return person;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	

}
