package com.example.Julien3DBack.UploadFile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UploadImageRepository extends JpaRepository<UploadImage, Long> {
    Optional<UploadImage> findByName(String name);
}
