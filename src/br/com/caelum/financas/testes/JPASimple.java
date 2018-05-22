package br.com.caelum.financas.testes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class JPASimple {

  public static void main(String[] args) {

    Conta conta = new Conta();
    conta.setTitular("Maria dos Santos");
    conta.setBanco("Caixa");
    conta.setAgencia("043");
    conta.setNumero("54321");

    // Usando HSQLDB
    // EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas-hsqldb");

    // Usando PostgreSQL
    // EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas-postgres");

    // Usando MySQL - Chame o persistence.xml e pega as informações do contas-mysql
    // <persistence-unit name="contas-mysql">
    //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas-mysql");
    //EntityManager entityManager = entityManagerFactory.createEntityManager();

    EntityManager entityManager = Persistence.createEntityManagerFactory("contas-mysql").createEntityManager();

    // Open connection
    entityManager.getTransaction().begin();

    // Save
    entityManager.persist(conta);

    // Commit
    entityManager.getTransaction().commit();

    // Close connection
    entityManager.close();
  }
}