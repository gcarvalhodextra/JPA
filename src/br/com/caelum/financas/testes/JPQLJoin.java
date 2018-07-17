package br.com.caelum.financas.testes;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JPQLJoin {

  public static void main(String[] args) {
    EntityManager em = new JPAUtil().getEntityManager();
    em.getTransaction().begin();

    //String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria order by m.valor desc";
    //String jpql = "select c from Cliente c join ClienteConta cc on cc.idCliente = c.id where c.id = 1";
    String jpql = "select c from Cliente c where c.id in(select cc.idCliente from ClienteConta cc)";
    //String jpql = "select c from Cliente c where c.conta.id = 14";

    Query query = em.createQuery(jpql, Cliente.class);
    ((List<Cliente>) query.getResultList()).stream().forEach(r -> {
      System.out.println("Resultado -> " + r.getNome());
    });

    em.getTransaction().commit();
    em.close();
  }
}