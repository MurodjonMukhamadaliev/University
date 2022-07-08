package uz.murodjon.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.murodjon.university.entity.Journal;

import java.util.List;
import java.util.Optional;

public interface JournalRepository extends JpaRepository<Journal, Long>, BaseRepository {
    Optional<Journal> findByIdAndDeletedFalse(Long id);

    List<Journal> findAllByDeletedFalse();

}