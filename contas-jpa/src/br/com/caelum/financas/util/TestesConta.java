package br.com.caelum.financas.util;

import br.com.caelum.financas.modelo.Conta;
import javax.persistence.EntityManager;

public class TestesConta {

  public static void main(String[] args) {

    EntityManager manager = new JPAUtil().getEntityManager();

    manager.getTransaction().begin();

    //findById(manager);
    //update(manager);
    insert(manager);

    manager.close();
  }

  private static void findById(EntityManager manager) {
    Conta conta1 = manager.find(Conta.class, 2);
    System.out.println(conta1.getTitular());
  }

  private static void update(EntityManager manager) {
    Conta conta1 = manager.find(Conta.class, 2);
    conta1.setTitular("Gustavo Carvalho");
    manager.getTransaction().commit();
    // Não precisa do manager.persist(conta1);
    System.out.println(conta1.getTitular() + " alterado com sucesso!");
    conta1.setBanco("341 - BANCO ITAU UNIBANCO");

    // Quando ela não está sendo gerenciada pelo JPA ela fica DETACHED
    // Se estiver fora do manager precisa do manager.merge(conta);
  }

  private static void insert(EntityManager manager) {
    Conta conta = new Conta();
    conta.setBanco("001 - BANCO DO BRASIL");
    conta.setNumero("16987-8");
    conta.setAgencia("6543");
    conta.setTitular("Maria dos Santos NEW");

    // Quando faz o persiste ele vira MANAGED(JPA vai sincronizar todas as suas alterações)
    manager.persist(conta);

    conta.setBanco("341 - BANCO ITAU UNIBANCO");

    manager.getTransaction().commit();
  }
}