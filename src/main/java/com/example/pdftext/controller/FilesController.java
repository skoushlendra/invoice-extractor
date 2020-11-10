package com.example.pdftext.controller;


import com.example.pdftext.beans.FileInfo;
import com.example.pdftext.beans.ResponseMessage;
import com.example.pdftext.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class FilesController {

    @Autowired
    private FilesStorageService storageService;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://extractor-invoice-id.herokuapp.com", "http://extractor-invoice-id.herokuapp.com"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
                "Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin",
                "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile[] file) {
        String message = "";
        try {
            Set<String> orderIds = storageService.save(file);
            message = "Uploaded the files successfully: ";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, orderIds));
        } catch (Exception e) {
            message = "Could not upload the files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
