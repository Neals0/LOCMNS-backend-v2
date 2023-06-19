package com.fianso.produits.service;

import com.fianso.produits.dto.ProduitDTO;
import com.fianso.produits.entities.Categorie;
import com.fianso.produits.entities.Produit;
import com.fianso.produits.repos.ProduitRepositery;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service        // dire à spring que cette classe s'agit d'un service
public class ProduitServiceImpl implements ProduitService {

    @Autowired      // ordonner à spring l'injection de dépendance
    ProduitRepositery produitRepositery;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto(produitRepositery.findById(id).get());
    }

    @Override
    public List<ProduitDTO> getAllProduits() {
//        méthode classique :
//        List<Produit> prods = produitRepositery.findAll();
//
//        List<ProduitDTO> listProdDto = new ArrayList<>(prods.size());
//        for (Produit p : prods) {
//            listProdDto.add(convertEntityToDto(p));
//        }
//        return listProdDto;
        return produitRepositery.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDTO saveProduit(ProduitDTO p) {
        return convertEntityToDto(produitRepositery.save(convertDtoToEntity(p)));
    }

    @Override
    public ProduitDTO updateProduit(ProduitDTO p) {
        return convertEntityToDto(produitRepositery.save(convertDtoToEntity(p)));
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepositery.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepositery.deleteById(id);
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepositery.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepositery.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepositery.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepositery.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepositery.findByCategorieIdCat(id);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepositery.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepositery.trierProduitsNomsPrix();
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit produit) {
        //        ProduitDTO produitDTO = new ProduitDTO();
//
//        produitDTO.setIdProduit(p.getIdProduit());
//        produitDTO.setNomProduit(p.getNomProduit());
//        produitDTO.setPrixProduit(p.getPrixProduit());
//        produitDTO.setDateCreation(p.getDateCreation());
//        produitDTO.setCategorie(p.getCategorie());
//
//        return produitDTO;

//        return ProduitDTO.builder()
//                .idProduit(p.getIdProduit())
//                .nomProduit(p.getNomProduit())
//                //.prixProduit(p.getPrixProduit())
//                .dateCreation(p.getDateCreation())
//                //.nomCat(p.getCategorie().getNomCat())
//                .categorie(p.getCategorie())
//                .build();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);

        return produitDTO;
    }

    @Override
    public Produit convertDtoToEntity(ProduitDTO produitDTO) {
        //        Produit produit = new Produit();
//
//        produit.setIdProduit(produitDTO.getIdProduit());
//        produit.setNomProduit(produitDTO.getNomProduit());
//        produit.setPrixProduit(produitDTO.getPrixProduit());
//        produit.setDateCreation(produitDTO.getDateCreation());
//        produit.setCategorie(produitDTO.getCategorie());
//
//
//        return produit;

        Produit produit = new Produit();
        produit = modelMapper.map(produitDTO, Produit.class);

        return produit;
    }

}
