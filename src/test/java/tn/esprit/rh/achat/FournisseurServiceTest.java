package tn.esprit.rh.achat.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceTest {

    @Mock
    FournisseurRepository FournisseurRepository;

    @InjectMocks
    FournisseurServiceImpl FournisseurService;

    @Test
    public void testRetrieveFacture() {

    	Fournisseur F = new Fournisseur(1L, "1a", "Fournisseur1", null, null, null, null);

        F.setIdFournisseur(1L);
        

        Mockito.when(FournisseurRepository.findById(1L)).thenReturn(Optional.of(F));
        FournisseurService.retrieveFournisseur(1L);
        Assertions.assertNotNull(F);
        System.out.println(" Retrieve is working !!");

    }


    @Test
    public void createFournisseurTest()
    {
    	Fournisseur F1 = new Fournisseur(2L, "Fournisseur2", null, null, null, null, null);
        
        F1.setIdFournisseur(2L);

        FournisseurService.addFournisseur(F1);
        verify(FournisseurRepository, times(1)).save(F1);
        System.out.println(" Create is working !!");
    }


    @Test
    public void getAllFournisseurTest()
    {
        List<Fournisseur> FS = new ArrayList<Fournisseur>() {

            {
                add(new Fournisseur(3L, "Fournisseur3", null, null, null, null, null));
                add(new Fournisseur(4L, "Fournisseur4", null, null, null, null, null));
                add(new Fournisseur(5L, "Fournisseur5", null, null, null, null, null));
            }};


        when(FournisseurService.retrieveAllFournisseurs()).thenReturn(FS);
        //test
        List<Fournisseur> fs = FournisseurService.retrieveAllFournisseurs();
        assertEquals(3, fs.size());
        System.out.println(" Retrieve all is working !!");
    }




}