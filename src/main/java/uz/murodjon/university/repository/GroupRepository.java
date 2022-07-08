package uz.murodjon.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import uz.murodjon.university.dto.student.StudentsMark;
import uz.murodjon.university.entity.Faculty;
import uz.murodjon.university.entity.Group;

import java.util.List;
import java.util.Optional;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long>, BaseRepository {
    Optional<Group> findByIdAndDeletedFalse(Long id);

    List<Group> findAllByDeletedFalseOrderById();

    boolean existsByNameAndFaculty(String name, Faculty faculty);

    List<Group> findAllByFacultyIdAndDeletedFalse(Long id);

    @Query(nativeQuery = true,
            value = "select s.first_name as \"name\", avg(m.mark)\n" +
                    "from student s\n" +
                    "         inner join groups g on g.id = s.group_id\n" +
                    "         full join mark m on s.id = m.student_id\n" +
                    "where g.id = :id\n" +
                    "group by s.first_name\n" +
                    "order by avg(m.mark) desc ")
    List<StudentsMark> groupStudentsMark(@PathVariable("id") Long id);
}
