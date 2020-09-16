package com.example.Julien3DBack.DatasFiles;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class DatasFilesService {

    public static final String COL_NAME="DataFiles";

    public String saveDataFilesDetails(DatasFiles datasFiles) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(datasFiles.getName()).set(datasFiles);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public DatasFiles getDataFilesDetails(String name) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        DatasFiles datasFiles = null;

        if(document.exists()) {
            datasFiles = document.toObject(DatasFiles.class);
            return datasFiles;
        }else {
            return null;
        }
    }

    public String updateDataFilesDetails(DatasFiles datasFiles) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(datasFiles.getName()).set(datasFiles);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteDataFilesPatient(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Document with File ID "+name+" has been deleted";
    }
}
