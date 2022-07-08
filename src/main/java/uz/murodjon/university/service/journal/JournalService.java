package uz.murodjon.university.service.journal;

import uz.murodjon.university.dto.journal.JournalCreateDTO;
import uz.murodjon.university.dto.journal.JournalDTO;
import uz.murodjon.university.dto.journal.JournalUpdateDTO;
import uz.murodjon.university.entity.Journal;
import uz.murodjon.university.service.GenericCrudService;

public interface JournalService extends GenericCrudService<Journal, JournalDTO, JournalCreateDTO, JournalUpdateDTO,Long> {
}
