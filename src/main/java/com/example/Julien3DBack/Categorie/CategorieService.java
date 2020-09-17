package com.example.Julien3DBack.Categorie;

import com.example.Julien3DBack.DatasFiles.DatasFiles;
import com.example.Julien3DBack.Projet.Projet;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class CategorieService {

public static final String COL_NAME="Categorie";

    public String saveCategorieDetails(Categorie categorie) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(categorie.getName()).set(categorie);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Categorie getCategorieDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Categorie categorie = null;

        if(document.exists()) {
            categorie = document.toObject(Categorie.class);
            return categorie;
        }else {
            return null;
        }
    }

    public String updateCategorieDetails(Categorie categorie) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(categorie.getName()).set(categorie);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCategorie(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Categorie File ID "+name+" has been deleted";
    }
}
