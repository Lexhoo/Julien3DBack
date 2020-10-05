package com.example.Julien3DBack.Projet;

import com.example.Julien3DBack.exceptionHandler.DataNotFoundException;
import com.example.Julien3DBack.exceptionHandler.DataSystemException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ProjetServiceTest {

    @TestConfiguration
    static class ProjetServiceTestConfiguration {

        @Bean
        public ProjetService projetService() {
            return new ProjetService();
        }
    }

    @Autowired
    private ProjetService projetService;

    @MockBean
    private ProjetRepository projetRepository;

    public void init() {
    }

    @Test
    public void getAllProjets_OK() {
        //GIVEN
        /**
         * 1ère ligne de la liste projet créée.
         */
        Projet projet1 = new Projet();
        projet1.setName("projet1");
        projet1.setId(1L);
        /**
         * 2ème ligne créée.
         */
        Projet projet2 = new Projet();
        projet2.setName("projet2");
        projet2.setId(2L);
        List<Projet> projetListCreated = new ArrayList<>();
        projetListCreated.add(projet1);
        projetListCreated.add(projet2);
        /**
         * On mock l'appel au repository car on ne teste pas cette méthode.
         */
        when(projetRepository.findAll()).thenReturn(projetListCreated);
        //WHEN
        List<Projet> projetList = projetService.getAllProjets();
        //THEN
        assertEquals(2, projetList.size());
    }

    @Test
    public void getAllProjets_KO_listeVide() {
        //GIVEN
        List<Projet> projetListCreated = new ArrayList<>();
        /**
         * On mock l'appel au repository car on ne teste pas cette méthode.
         */
        when(projetRepository.findAll()).thenReturn(projetListCreated);
        try {
            //WHEN
            projetService.getAllProjets();
            fail("L'appel au service gatAllProjets aurait dû lever une exception puisque la liste est vide");
        } catch (DataNotFoundException e) {
            //THEN
            assertEquals("0200", e.getMessage());
        }
    }

    @Test
    public void getAllProjets_KO_systeme() {
        //GIVEN
        /**
         * On mock l'appel au repository car on ne teste pas cette méthode.
         */
        when(projetRepository.findAll()).thenThrow(NullPointerException.class);
        try {
            //WHEN
            projetService.getAllProjets();
            fail("L'appel au service gatAllProjets aurait dû lever une exception puisque le système est en erreur");
        } catch (DataSystemException e) {
            //THEN
            assertEquals("0300", e.getMessage());
        }
    }

}
