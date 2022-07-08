package uz.murodjon.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.murodjon.university.entity.Subject;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>, BaseRepository {

    boolean existsByNameAndDeletedFalse(String name);

    Optional<Subject> findByIdAndDeletedFalse(Long id);

    List<Subject> findAllByDeletedFalse();
}