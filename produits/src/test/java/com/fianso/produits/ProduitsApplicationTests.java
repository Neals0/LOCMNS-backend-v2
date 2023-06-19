package com.fianso.produits;

import com.fianso.produits.entities.Categorie;
import com.fianso.produits.entities.Produit;
import com.fianso.produits.repos.ProduitRepositery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitsApplicationTests {

    @Autowired
    private ProduitRepositery produitRepositery;

    @Test
    public void testCreateProduit() {
        Produit produit1 = new Produit("Pc Dell", 2200.500, new Date());
        Produit produit2 = new Produit("Smartphone Iphone 14", 1799.99, new Date());
        Produit produit3 = new Produit("Smartphone Pixel 7", 719.99, new Date());
        Produit produit4 = new Produit("Pc Lenovo", 999.99, new Date());
        Produit produit5 = new Produit("Pc Acer", 800.00, new Date());

        produitRepositery.save(produit1);
        produitRepositery.save(produit2);
        produitRepositery.save(produit3);
        produitRepositery.save(produit4);
        produitRepositery.save(produit5);

    }

    @Test
    public void testFindProduit() {
        Produit p = produitRepositery.findById(1L).get();
        System.out.println(p);
    }

    @Test
    public void testUpdateProduit() {
        Produit p = produitRepositery.findById(1L).get();
        p.setPrixProduit(2000.0);
        produitRepositery.save(p);

        System.out.println(p);
    }

    @Test
    public void testDeleteProduit() {
        produitRepositery.deleteById(1L);
    }

    @Test
    public void testFindAllProduit() {
        List<Produit> produits = produitRepositery.findAll();

        for (Produit p : produits) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindProduitByNom() {
        List<Produit> prods = produitRepositery.findByNomProduit("Pc Dell");
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindProduitByNomContains() {
        List<Produit> prods = produitRepositery.findByNomProduitContains("P");
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomPrix() {
        List<Produit> prods = produitRepositery.findByNomPrix("Pc Dell", 2200.0);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategorie() {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);

        List<Produit> prods = produitRepositery.findByCategorie(cat);

        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategorieIdCat() {
        List<Produit> prods = produitRepositery.findByCategorieIdCat(1L);

        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByOrderByNomProduitAsc() {
        List<Produit> prods = produitRepositery.findByOrderByNomProduitAsc();

        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testtrierProduitsNomsPrix() {
        List<Produit> prods = produitRepositery.trierProduitsNomsPrix();

        for (Produit p : prods) {
            System.out.println(p);
        }
    }

}
