package uz.murodjon.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.murodjon.university.entity.University;

import java.util.List;
import java.util.Optional;

public interface UniversityRepo extends JpaRepository<University, Long>, BaseRepository {

    Optional<University> findByIdAndDeletedFalse(Long id);

    List<University> findAllByDeletedFalse();

    boolean existsByName(String name);
}