package com.fianso.produits.service;

import com.fianso.produits.dto.ProduitDTO;
import com.fianso.produits.entities.Categorie;
import com.fianso.produits.entities.Produit;
import java.util.List;

public interface ProduitService {

    ProduitDTO saveProduit(ProduitDTO p);
    ProduitDTO updateProduit(ProduitDTO p);

    ProduitDTO getProduit(Long id);
    List<ProduitDTO> getAllProduits();



    void deleteProduit(Produit p);

    void deleteProduitById(Long id);


    // méthodes implémentées de l'interface ProduitRepositery
    List<Produit> findByNomProduit(String nom);

    List<Produit> findByNomProduitContains(String nom);

    List<Produit> findByNomPrix(String nom, Double prix);

    List<Produit> findByCategorie(Categorie categorie);

    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    List<Produit> trierProduitsNomsPrix();

    ProduitDTO convertEntityToDto(Produit p);

    Produit convertDtoToEntity(ProduitDTO produitDTO);

}
