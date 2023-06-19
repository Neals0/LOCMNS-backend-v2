package com.fianso.produits.repos;

import com.fianso.produits.entities.Categorie;
import com.fianso.produits.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(path = "rest")
public interface ProduitRepositery extends JpaRepository<Produit, Long> {
    List<Produit> findByNomProduit(String nom);

    List<Produit> findByNomProduitContains(String nom);

//    @Query("SELECT p FROM Produit AS p WHERE p.nomProduit LIKE %?1 AND p.prixProduit > ?2")
//    List<Produit> findByNomPrix(String nom, Double prix);

    @Query("SELECT p FROM Produit AS p WHERE p.nomProduit LIKE %:nom AND p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

    @Query("SELECT p FROM Produit AS p WHERE p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);

    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("SELECT p FROM Produit AS p ORDER BY p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNomsPrix();

}
