package br.ETS.hibernate;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

//        // Criando entidades
//        Categoria escritorio = new Categoria("ESCRITORIO");
//        Material caneta = new Material(new MaterialDTO("Caneta", "Só canetas", 600, escritorio));
//
//        // Criando o entity manager
//        EntityManager entityManager = JPAUtil.getEntityManager();
//
//        // Criando as classes DAO
//        MaterialDAO materialDAO = new MaterialDAO(entityManager);
//        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
//
//        // Transações do HIBERNATE
//        entityManager.getTransaction().begin();
//
//        // cadastrar as tabelas
//        categoriaDAO.cadastrar(escritorio);
//        materialDAO.cadastrar(caneta);
//
//        // commit - envia os dados para o banco
//        entityManager.getTransaction().commit();
//        entityManager.close(); // fecha a conexão do hibernate com o banco de dados

        EntityManager entityManager = JPAUtil.getEntityManager();
        MaterialDAO materialDAO = new MaterialDAO(entityManager);
        Material material = materialDAO.buscaPorId(1);
        // System.out.println(material.getNome());

        var tabela = materialDAO.lerDadosTabela();
        tabela.forEach(m -> System.out.println(m.getNome()));


    }
}