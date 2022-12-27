package net.javaguides.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.model.Employee;
import net.javaguides.hibernate.model.User;
import net.javaguides.hibernate.util.HibernateUtil;


public class EmployeeDao {


    /**
     * Save Employee
     * @param employee
     */
    public void saveEmployee(Employee emp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(emp);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Update Employee
     * @param employee
     */
    public void updateEmployee(Employee emp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(emp);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Delete Employee
     * @param id
     */
    public void deleteEmployee(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
            Employee emp = session.get(Employee.class, id);
            if (emp != null) {
                session.delete(emp);
                System.out.println("employee is deleted");
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Get Employee By ID
     * @param id
     * @return
     */
    public Employee getEmployee(int id) {

        Transaction transaction = null;
        Employee emp = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            emp = session.get(Employee.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return emp;
    }

    /**
     * Get all Employees
     * @return
     */
   // @SuppressWarnings("unchecked")
    public List < Employee > getAllEmployee(String name) {

        Transaction transaction = null;
        List < Employee > listOfEmployee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            if(name==null) {
            	listOfEmployee = session.createQuery("from Employee").getResultList();
            }else {
            	listOfEmployee = session.createQuery("from Employee U WHERE U.name = :Name").setParameter("Name",name).getResultList();
            }


            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfEmployee;
    }
}