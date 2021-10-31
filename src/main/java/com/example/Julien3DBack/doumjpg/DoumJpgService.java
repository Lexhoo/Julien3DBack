package com.example.Julien3DBack.doumjpg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Julien3DBack.UploadImage.UploadImage;
import com.example.Julien3DBack.UploadImage.UploadImageService;

@Service
public class DoumJpgService {
	
	@Autowired
    private UploadImageService uploadImageService;
	
	public List<UploadImage> getImagesVitrine() {
		return uploadImageService.getImagesVitrine();
	}
}
