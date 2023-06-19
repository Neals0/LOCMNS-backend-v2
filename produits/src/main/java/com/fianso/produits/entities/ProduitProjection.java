package com.fianso.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProduit", types = {Produit.class})
public interface ProduitProjection {
    public String getNomProduit();

}
