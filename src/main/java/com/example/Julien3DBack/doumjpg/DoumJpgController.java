package com.example.Julien3DBack.doumjpg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Julien3DBack.UploadImage.UploadImage;

@RestController
@CrossOrigin
@RequestMapping("/doumjpg")
public class DoumJpgController {
	
	@Autowired
	private DoumJpgService doumJpgService;
	
	@GetMapping()
    public List<UploadImage> getImagesVitrine() {
		return this.doumJpgService.getImagesVitrine();
	}

}
