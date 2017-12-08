package jpaproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpaproject.model.Address;
import jpaproject.model.Company;
import jpaproject.model.Employee1;

public class MainJPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProjectPU"); // untuk connect 
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //<-- supaya transaksi bisa muncul di db
        
        Company fb = new Company("Facebook Inc","FB");
        
        Employee1 develop = new Employee1("Mark Z", "Senior Develop", 25000);
        em.persist(develop);
        Address address = new Address("Jl Silicon Valley", "Los Angeles");
        develop.setAddress(address); // <-- develop.Employee memiliki FK ke address
        em.persist(address); //<-- disimpan di db
        
        Employee1 programmer = new Employee1 ("Luis V","yunior",150000);
        em.persist(programmer);
        List<Employee1> emps = new ArrayList<>();
        emps.add(develop);
        emps.add(programmer);
        
        //yg menentukan foreign key dr company ke employee
        fb.setEmployees(emps);
        em.persist(fb);
        develop.setCompany(fb); // pembuatan isi fk
        programmer.setCompany(fb); // pembuatan isi fk 
        tx.commit();
        em.close();
        emf.close();

        //tx.begin();
//        String nama = "John Aja";
//        Query qName = em.createQuery("Select e from Employee1 e where e.name = :name");
//        qName.setParameter("name", nama);
//        Employee1 aName = (Employee1) qName.getSingleResult();
//        System.out.println(aName.getName() + " " +aName.getPosition());
//
//        Query qPro = em.createQuery("Select e from Employee1 e where e.position=:position");
//        qPro.setParameter("position", "Office Boy");
//        List<Employee1> progs = qPro.getResultList();
//        for (Employee1 prog : progs) {
//            System.out.println(prog.getName() +" "+prog.getPosition());
//        }
        // Employee1 e1 = new Employee1("Bill Gates", "Programmer", 999999999);
//        Employee1 staf = new Employee1();
//        staf.setName("John Aja");
//        staf.setPosition("Office Boy");
//        staf.setSalary(2500000.0);
//        staf.setDateOfBirth(new Date());
//
//        staf.setName("Jony Jony");
//        staf.setPosition("Eating Sugar");
//        staf.setSalary(100000.0);
//        staf.setDateOfBirth(new Date());
//
//        em.persist(staf); // simpan data yg di insert di atas ke dlm db
//        tx.commit();
    }

}
