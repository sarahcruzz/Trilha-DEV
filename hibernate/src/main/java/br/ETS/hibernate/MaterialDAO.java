package br.ETS.hibernate;

import org.hibernate.annotations.GenerationTime;

import javax.persistence.EntityManager;
import java.util.List;

public class MaterialDAO {
    private EntityManager entityManager;

    public MaterialDAO() {
    }

    public MaterialDAO (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Material material){
        this.entityManager.persist(material);
    }

    public void atualizar(Material material){
        this.entityManager.merge(material);
    }

    public void remover(Material material){
        material = entityManager.merge(material);
        this.entityManager.remove(material);
    }

    public Material buscaPorId(int id){
        return this.entityManager.find(Material.class, id);
    }

    public List<Material> lerDadosTabela(){
        String jpql = "SELECT m FROM Material m";
        return entityManager.createQuery(jpql, Material.class).getResultList();
    }

}
