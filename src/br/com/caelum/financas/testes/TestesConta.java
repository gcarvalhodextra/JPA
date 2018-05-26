package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

public class TestesConta {

  public static void main(String[] args) {

    EntityManager manager = new JPAUtil().getEntityManager();

    manager.getTransaction().begin();

    findById(manager);
    //update(manager);
    //insert(manager);
    //remove(manager);

    manager.close();
  }

  private static void findById(EntityManager manager) {
    br.com.caelum.financas.modelo.Conta conta1 = manager.find(br.com.caelum.financas.modelo.Conta.class, 2);
  }

  private static void update(EntityManager manager) {
    br.com.caelum.financas.modelo.Conta conta1 = manager.find(br.com.caelum.financas.modelo.Conta.class, 2);
    manager.getTransaction().commit();
    // Não precisa do manager.persist(conta1);
    conta1.setBanco("341 - BANCO ITAU UNIBANCO");

    // Quando ela não está sendo gerenciada pelo JPASimple ela fica DETACHED
    // Se estiver fora do manager precisa do manager.merge(conta);
  }

  private static void insert(EntityManager manager) {
    br.com.caelum.financas.modelo.Conta conta = new br.com.caelum.financas.modelo.Conta();
    conta.setBanco("001 - BANCO DO BRASIL");
    conta.setNumero("16987-8");
    conta.setAgencia("6543");

    // Quando faz o persiste ele vira MANAGED(JPASimple vai sincronizar todas as suas alterações)
    manager.persist(conta);

    conta.setBanco("341 - BANCO ITAU UNIBANCO");

    manager.getTransaction().commit();
  }

  private static void remove(EntityManager manager) {
    br.com.caelum.financas.modelo.Conta conta1 = manager.find(br.com.caelum.financas.modelo.Conta.class, 10);
    manager.remove(conta1);
    manager.getTransaction().commit();
  }
}