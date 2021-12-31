package FileUplod.Controller;

import FileUplod.Servies.fileUplodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Objects;

@RestController
public class fileUplod {
    @Autowired
    fileUplodService fileUplodService;

    @PostMapping("/Ufile")
    public ResponseEntity<String> uplod(@RequestParam MultipartFile file){
        try {
            fileUplodService.upload(file);
            System.out.println("FILE ADD");
            System.out.println((ServletUriComponentsBuilder.fromCurrentContextPath().path("/files").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString()));
            String url = (ServletUriComponentsBuilder.fromCurrentContextPath().path("/files").path(file.getOriginalFilename()).toUriString());
            //(ResponseEntity.BodyBuilder) ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(file.getOriginalFilename()).toUriString());
            return ResponseEntity.ok(url);
        }
        catch (Exception e)
        {
            return ResponseEntity.status(401).body("File Upload Error");
        }


    }
}
