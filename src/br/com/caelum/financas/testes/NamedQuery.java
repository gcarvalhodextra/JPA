package br.com.caelum.financas.testes;

import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class NamedQuery {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        useNamedQuery(em);

        em.getTransaction().commit();
        em.close();
    }

    private static void useNamedQuery(EntityManager em) {
        TypedQuery<Double> query = em.createNamedQuery("groupByData", Double.class);
        List<Double> result = query.getResultList();
        result.stream().forEach(m -> System.out.println("Media " + m));
    }
}
