package uz.murodjon.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.murodjon.university.entity.Faculty;
import uz.murodjon.university.entity.University;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>, BaseRepository {

    Optional<Faculty> findByIdAndDeletedFalse(Long id);

    List<Faculty> findAllByDeletedFalse();

    List<Faculty> findAllByDeletedFalseAndUniversityId(Long id);

    boolean existsByNameAndUniversityId(String s, Long id);

    boolean existsByName(String s);

    boolean existsByNameAndUniversity(String name, University university);
}