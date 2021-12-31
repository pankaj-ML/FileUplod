package FileUplod.Servies;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface fileUplodService {
    void upload(MultipartFile file) throws IOException;
}
