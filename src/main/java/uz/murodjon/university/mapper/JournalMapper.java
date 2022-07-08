package uz.murodjon.university.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.murodjon.university.dto.journal.JournalCreateDTO;
import uz.murodjon.university.dto.journal.JournalDTO;
import uz.murodjon.university.dto.journal.JournalUpdateDTO;
import uz.murodjon.university.entity.Journal;

@Component
@Mapper(componentModel = "spring")
public interface JournalMapper extends GenericMapper<Journal, JournalDTO, JournalCreateDTO, JournalUpdateDTO, Long> {
}