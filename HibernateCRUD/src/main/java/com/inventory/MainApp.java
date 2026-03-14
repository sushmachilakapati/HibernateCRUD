package com.inventory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    public static void main(String[] args) {

    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();

    	// Insert
    	Product p1 = new Product("Laptop","Dell i5",50000,10);
    	Product p2 = new Product("Mouse","Wireless Mouse",500,50);

    	session.save(p1);
    	session.save(p2);

    	// Retrieve
    	Product product = session.get(Product.class,1);
    	System.out.println(product.getName());

    	// Update
    	product.setPrice(52000);
    	session.update(product);

    	// Delete
    	Product deleteProduct = session.get(Product.class,2);
    	if(deleteProduct != null){
    	    session.delete(deleteProduct);
    	}

    	tx.commit();
    	session.close();

    	System.out.println("CRUD Operations Completed");
    }
}