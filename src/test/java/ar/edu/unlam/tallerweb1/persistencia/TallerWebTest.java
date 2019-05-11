package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class TallerWebTest extends SpringTest {
	//2- Hacer con junit un test que busque todos los países de habla inglesa.
	@Test @Transactional @Rollback
	public void testQueBuscoPaisesQueHablanIngles(){
	
		Session session = getSession();
				
		//pais 1
		Continente america = new Continente();
		america.setNombre("America");
		
		Pais argentina =new Pais();
		argentina.setNombre("Argentina");
		argentina.setHabitantes((long) 40000000);
		argentina.setIdioma("español");
		argentina.setContinente(america);
		
		Ubicacion ubicacionBsAs = new Ubicacion();
		ubicacionBsAs.setLatitud(-34.6083);
		ubicacionBsAs.setLongitud(-58.3712);
		
		Ciudad buenosAires=new Ciudad();
		buenosAires.setNombre("Buenos Aires");
		buenosAires.setUbicacionGeografica(ubicacionBsAs);
		
		buenosAires.setPais(argentina);
		session.save(buenosAires);
		argentina.setCapital(buenosAires);
		session.save(argentina);
		
		//pais 2
		Pais estadosUnidos = new Pais();
		estadosUnidos.setNombre("Estados Unidos");
		estadosUnidos.setHabitantes((long) 328835763);
		estadosUnidos.setIdioma("ingles");
		estadosUnidos.setContinente(america);
		
		Ubicacion ubicacionW = new Ubicacion();
		ubicacionW.setLatitud(38.9041);
		ubicacionW.setLongitud(-77.0171);
		
		Ciudad washington = new Ciudad();
		washington.setNombre("Washington");
		washington.setUbicacionGeografica(ubicacionW);
		
		washington.setPais(estadosUnidos);
		session.save(washington);
		estadosUnidos.setCapital(washington);
		session.save(estadosUnidos);
		
		
		//pais 3
		Continente europa = new Continente();
		europa.setNombre("Europa");
		
		Pais inglaterra = new Pais();
		inglaterra.setContinente(europa);
		inglaterra.setIdioma("ingles");
		inglaterra.setNombre("Inglaterra");
		inglaterra.setHabitantes((long) 53012000);
		
		Ubicacion ubicacionL = new Ubicacion();
		ubicacionL.setLatitud(51.5072);
		ubicacionL.setLongitud(-0.1275);
		
		Ciudad londres = new Ciudad();
		londres.setNombre("Londres");
		londres.setUbicacionGeografica(ubicacionL);
		
		londres.setPais(inglaterra);
		session.save(londres);
		inglaterra.setCapital(londres);
		session.save(inglaterra);		
		
		
		List<Pais> lista=getSession().createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "ingles"))
				.list();
		assertThat(lista).hasSize(2);
	}
	

}
