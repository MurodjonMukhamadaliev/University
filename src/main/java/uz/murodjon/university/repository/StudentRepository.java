package uz.murodjon.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.murodjon.university.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long>, BaseRepository {

    boolean existsByEmail(String s);

    boolean existsByPhone(String s);

    Optional<Student> findByIdAndDeletedFalse(Long id);

    Optional<Student> findByUsername(String uname);

    List<Student> findAllByDeletedFalse();

    boolean existsByUsername(String s);
}
