package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

public class ContaCliente {

  public static void main(String[] args) {
    Conta cnt01 = new Conta("Santander", "2162", "010098745");
    Conta cnt02 = new Conta("Itau", "7699", "80641-8");

    Cliente cli01 = new Cliente("Gustavo", "Analista de Sistemas", "R 18 N51");
    cli01.setConta(cnt01);

    Cliente cli02 = new Cliente("Michelle", "Analista de Sistemas", "R 18 N51");
    cli02.setConta(cnt02);

    EntityManager em = new JPAUtil().getEntityManager();
    em.getTransaction().begin();

    em.persist(cnt01);
    em.persist(cnt02);
    em.persist(cli01);
    em.persist(cli02);

    em.getTransaction().commit();
    em.close();
  }
}