package com.fianso.produits.restcontrollers;

import com.fianso.produits.entities.Categorie;
import com.fianso.produits.repos.CategorieRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRESTController {

    @Autowired
    CategorieRepositery categorieRepositery;

    @RequestMapping(method = RequestMethod.GET)
    public List<Categorie> getAllCategories() {
        return categorieRepositery.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Categorie getCategorieById(@PathVariable("id") Long id) {
        return categorieRepositery.findById(id).get();
    }

}
