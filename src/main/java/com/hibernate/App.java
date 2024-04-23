package com.hibernate;

import java.util.List;
import java.util.Scanner;
import com.hibernate.dao.CiudadDAO;
import com.hibernate.model.*;

public class App {
	
	static void mostrarMenu() {
		System.out.println("Selecciona opcion 1-5 ");
		System.out.println("1-añadir nueva ciudad ");
		System.out.println("2-borrar ciudad ");
		System.out.println("3-actualizar nombre ciudad ");
		System.out.println("4-actualizar habitantes ciudad ");
		System.out.println("5-ver datos de una ciudad");
		System.out.println("6-ver todas las ciudades ");
		System.out.println("7-Seleccionar ciudades con más de 1 millón de habitantes. ");
		System.out.println("8-Seleccionar ciudades con menos habitantes que una cantidad introducida por el usuario");
		System.out.println("9-Mostrar los habitantes de la ciudad que coincida con el nombre introducido por el usuario.");
		
		System.out.println("10-Salir ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc;
		String nomC;
		int habC;
		int idC;
		int numUsu;
		Scanner s = new Scanner(System.in);
		CiudadDAO ciudadDAO=new CiudadDAO();
		List <Ciudad> ciudades=ciudadDAO.selectAllCiudad();
	
		do {
			mostrarMenu();
			opc = s.nextInt();
			switch (opc) {
			case 1:
				
				System.out.println("Dime el nombre de la ciudad");
				nomC = s.next();
				
				System.out.println("Dime los habitantes de la ciudad");
				habC = s.nextInt();
				
				Ciudad ciudad=new Ciudad(nomC,habC);
				ciudadDAO.insertCiudad(ciudad);
				
			
			break;
			
			case 2:
				
				System.out.println("Dime el id de la ciudad");
				idC = s.nextInt();
				
				ciudadDAO.deleteCiudad(idC);
			
			break;
			
			case 3:
				
				System.out.println("Dime el id de la ciudad");
				idC = s.nextInt();
				System.out.println("Dime el nuevo nombre de la ciudad");
				nomC = s.next();
				
				
				Ciudad ciu=ciudadDAO.selectCiudadById(idC);				
				ciu.setNomCiudad(nomC);
				ciudadDAO.updateCiudad(ciu);
			
				
			break;
			case 4:
				
				System.out.println("Dime el id de la ciudad");
				idC = s.nextInt();
				System.out.println("Dime los nuevos habitantes de la ciudad");
				habC = s.nextInt();
				
				
				Ciudad ciu2=ciudadDAO.selectCiudadById(idC);				
				ciu2.setHabitantes(habC);
				ciudadDAO.updateCiudad(ciu2);
			
				
			break;
			
			case 5:
				
				System.out.println("Dime el id de la ciudad");
				idC = s.nextInt();
				
				
				
				Ciudad ciu3=ciudadDAO.selectCiudadById(idC);				
				System.out.println(ciu3.getIdCiudad()+" "+ciu3.getNomCiudad()+" "+ciu3.getHabitantes());
			
				
			break;
			case 6:
				
				
				
				
				
				
				ciudades.forEach(c->System.out.println(c.getNomCiudad()+" "+c.getHabitantes()));
				
				
			break;
			
			case 7:

				for (Ciudad c : ciudades) {
					if (c.getHabitantes()>1000000) {
						System.out.println(c.getNomCiudad()+" "+c.getHabitantes());
					}
				}
				
				
				
				
			break;
			case 8:
				System.out.println("Dime la cantidad");
				numUsu = s.nextInt();
				
				for (Ciudad c : ciudades) {
					if (c.getHabitantes()<numUsu) {
						System.out.println(c.getNomCiudad()+" "+c.getHabitantes());
					}
				}
				
				
				
				
			break;
			case 9:
				System.out.println("Dime el nombre de una ciudad");
				nomC=s.next();
				
				Ciudad ciu4=ciudadDAO.selectCiudadByNombre(nomC);
				
				System.out.println(ciu4.getHabitantes());
				
				
				
				
			break;
			
			}
			
			
		}while(opc!=10);
	}

}
