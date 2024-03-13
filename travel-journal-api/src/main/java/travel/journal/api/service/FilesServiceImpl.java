package travel.journal.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import travel.journal.api.entities.Files;
import travel.journal.api.exception.ResourceNotFoundException;
import travel.journal.api.repositories.FilesRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class FilesServiceImpl implements FileService{

    private final FilesRepository filesRepository;
    public FilesServiceImpl(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    @Override
    public Files saveImage(MultipartFile file) throws IOException {
        Files fileToCreate = new Files();

        fileToCreate.setFileName(file.getOriginalFilename());
        fileToCreate.setCreatedDate(LocalDate.now());
        fileToCreate.setFileContent(file.getBytes());
        fileToCreate.setTitle(file.getName());

        return filesRepository.save(fileToCreate);
    }

    public void deleteImage(long id){
       if(filesRepository.existsById(id)){
           filesRepository.deleteById(id);
       }
       else{
           throw new ResourceNotFoundException("File with id: " + id + " does not exist");
       }
    }

    public Files modifyImage(long id, MultipartFile file) throws IOException {
        Optional<Files> existingImageOptional = filesRepository.findById(id);

        if (existingImageOptional.isPresent()) {

            Files existingFile = existingImageOptional.get();

            existingFile.setFileName(file.getOriginalFilename());
            existingFile.setFileContent(file.getBytes());
            existingFile.setTitle(file.getName());
            existingFile.setCreatedDate(LocalDate.now());

            return filesRepository.save(existingFile);
        }
        else{
           return this.saveImage(file);
        }
    }
}
