package com.example.pdftext.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Stream;

public interface FilesStorageService {
    void init();

    Set<String> save(MultipartFile... file);

    Resource load(String filename);

    void deleteAll();

    Stream<Path> loadAll();
}