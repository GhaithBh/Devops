package tn.esprit.rh.achat.tests;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Fournisseur;

import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FornisseurserviceTest {
	@Autowired
	FournisseurServiceImpl FournisseurService;
	@Test
	public void testaddFournisseur() throws java.text.ParseException {
	List<Fournisseur> Fournisseurs = FournisseurService.retrieveAllFournisseurs();
	int expected=Fournisseurs.size();
	Fournisseur F = new Fournisseur();
	F.setCategorieFournisseur(null);
	F.setLibelle("fornisseur");
	F.setCode("123cb");
	F.setDetailFournisseur(null);
	F.setFactures(null);
	F.setSecteurActivites(null);
	Fournisseur savedFournisseur= FournisseurService.addFournisseur(F);
	assertEquals(expected+1, FournisseurService.retrieveAllFournisseurs().size());
	assertNotNull(savedFournisseur.getLibelle());
	FournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur()); 

    }

}
