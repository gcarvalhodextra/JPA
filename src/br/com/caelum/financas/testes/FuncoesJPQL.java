package br.com.caelum.financas.testes;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class FuncoesJPQL {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        //sum(em);
        //avg(em);
        //max(em);
        //min(em);
        //count(em);
        //groupBy(em);
        useDAO(em);

        em.getTransaction().commit();
        em.close();
    }

    private static void sum(EntityManager em) {
        String jpql = "select sum(m.valor) from Movimentacao m";

        Query query = em.createQuery(jpql);
        BigDecimal result = (BigDecimal) query.getSingleResult();

        System.out.printf("A soma é -> " + result);
    }

    private static void avg(EntityManager em) {
        // Média (Sum dividido pelo numero de valores)
        String jpql = "select avg(m.valor) from Movimentacao m";

        Query query = em.createQuery(jpql);
        Double result = (Double) query.getSingleResult();

        System.out.printf("A média é -> " + result);
    }

    private static void max(EntityManager em) {
        String jpql = "select max(m.valor) from Movimentacao m";

        Query query = em.createQuery(jpql);
        BigDecimal result = (BigDecimal) query.getSingleResult();

        System.out.println("O maior valor é -> " + result);
    }

    private static void min(EntityManager em) {
        String jpql = "select min(m.valor) from Movimentacao m";

        Query query = em.createQuery(jpql);
        BigDecimal result = (BigDecimal) query.getSingleResult();

        System.out.println("O menor valor é -> " + result);
    }

    private static void count(EntityManager em) {
        String jpql = "select count(m.valor) from Movimentacao m";

        Query query = em.createQuery(jpql);
        Long result = (Long) query.getSingleResult();

        System.out.println(result + " Movimentações encontradas");
    }

    private static void groupBy(EntityManager em) {
        String jpql = "select avg(m.valor) from Movimentacao m group by m.data";

        // Força o retorno como Double.class
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        List<Double> result = query.getResultList();

        result.stream().forEach(m -> System.out.println("Media " + m));
    }

    private static void useDAO(EntityManager em) {
        MovimentacaoDAO dao = new MovimentacaoDAO(em);
        System.out.printf("A soma é -> " + dao.getSUM());
    }
}