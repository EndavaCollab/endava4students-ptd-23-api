package travel.journal.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import travel.journal.api.entities.Files;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface FilesRepository extends JpaRepository<Files, Integer >{

}
