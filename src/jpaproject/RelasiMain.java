/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaproject;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpaproject.model.Address;
import jpaproject.model.Company;
import jpaproject.model.Employee1;

/**
 *
 * @author user
 */
public class RelasiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProjectPU"); // <-- akses ke db dibuka
        EntityManager em = emf.createEntityManager();

        //mencari alamat dengan ID employee1
//        Employee1 staf = em.find(Employee1.class, 601);
//        System.out.println("Nama employee: " + staf.getName());
//        
//        Address alamat = staf.getAddress();  // FETCHING 
//        System.out.println("Alamatnya di: " + alamat.getStreet() + " " + alamat.getCity());
//
//        //mencari employee dengan address
//        Address kuningan = em.find(Address.class, 602);
//        System.out.println("Alamat: " + kuningan.getStreet() + " " + kuningan.getCity());
//        Employee1 staf2 = kuningan.getEmployee(); // FETCHING
//        System.out.println("Milik dari: " + staf2.getName());

        em.getTransaction().begin();
        Company c = em.find(Company.class, 604);
        
//        Employee1 e = new Employee1("Sam Sudin", "Junior", 4500000);
//        c.getEmployees().add(e);
//        //1. employee 2 arah. set company, 2. perisist, 3
//        em.persist(e);
//        em.getTransaction().commit();


        List<Employee1> emps = c.getEmployees();
        for (Employee1 emp : emps) {
            System.out.println(emp.getName());
            
        }
        
//yg belum many to one        
        
        em.close();
        emf.close();
        // TODO code application logic here
    }

}
