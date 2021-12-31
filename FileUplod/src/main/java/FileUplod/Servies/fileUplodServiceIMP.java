package FileUplod.Servies;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class fileUplodServiceIMP implements fileUplodService{
    @Override
    public void upload(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\Users\\ADMIN\\Desktop\\FileUplod\\src\\main\\resources\\static\\files"+file.getOriginalFilename()));

        // Dynamic URL
        //file.transferTo(new File(new ClassPathResource("/static/files").getFile().getAbsolutePath()));
    }
}
