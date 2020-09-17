package com.example.Julien3DBack.Projet;

import com.example.Julien3DBack.Categorie.Categorie;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ProjetService {

    public static final String COL_NAME="Projet";

    public String saveProjetDetails(Projet projet) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(projet.getName()).set(projet);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Projet getProjetDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Projet projet = null;

        if(document.exists()) {
            projet = document.toObject(Projet.class);
            return projet;
        }else {
            return null;
        }
    }

    public String updateProjetDetails(Projet projet) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(projet.getName()).set(projet);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteProjet(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Projet File ID "+name+" has been deleted";
    }
}
