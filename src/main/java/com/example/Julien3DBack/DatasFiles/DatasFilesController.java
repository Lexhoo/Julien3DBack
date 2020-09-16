package com.example.Julien3DBack.DatasFiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class DatasFilesController {

    @Autowired
    DatasFilesService datasFilesService;

    @GetMapping("/getData")
    public DatasFiles datasFiles(@RequestParam String name ) throws InterruptedException, ExecutionException{
        return datasFilesService.getDataFilesDetails(name);
    }

    @PostMapping("/createData")
    public String createDataFile(@RequestBody DatasFiles datasFiles ) throws InterruptedException, ExecutionException {
        return datasFilesService.saveDataFilesDetails(datasFiles);
    }

    @PutMapping("/updateData")
    public String updateDataFile(@RequestBody DatasFiles datasFiles  ) throws InterruptedException, ExecutionException {
        return datasFilesService.updateDataFilesDetails(datasFiles);
    }

    @DeleteMapping("/deleteData")
    public String deleteDataFile(@RequestParam String name){
        return datasFilesService.deleteDataFilesPatient(name);
    }
}
