package uz.murodjon.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.murodjon.university.entity.Mark;

import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark, Long>, BaseRepository {
    Optional<Mark> findByIdAndDeletedFalse(Long id);
}