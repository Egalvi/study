package ru.egalvi.problem.persistence.service.impl;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.egalvi.problem.core.domain.DisciplineDto;
import ru.egalvi.problem.persistence.domain.Discipline;
import ru.egalvi.problem.persistence.repository.DisciplineRepository;
import ru.egalvi.problem.persistence.service.DisciplineService;
import ru.egalvi.problem.persistence.service.EntityNotFoundException;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class RepositoryDisciplineService implements DisciplineService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryDisciplineService.class);

    @Resource
    private DisciplineRepository disciplineRepository;

    @Transactional
    @Override
    public Discipline create(DisciplineDto created) {
        LOGGER.debug("Creating discipline: " + created);
        return disciplineRepository.save(new Discipline.Builder().setName(created.getName()).setCategoriesFromModel(
                created.getCategories()).build());
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    @Override
    public Discipline delete(Long id) throws EntityNotFoundException {
        LOGGER.debug("Deleting discipline with id: " + id);
        Discipline deleted = disciplineRepository.findOne(id);
        if (deleted == null) {
            LOGGER.debug("No discipline with id: " + id);
            throw new EntityNotFoundException("No discipline with id: " + id);
        }
        disciplineRepository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Discipline> findAll() {
        LOGGER.debug("Selecting all disciplines");
        return disciplineRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Discipline findById(Long id) {
        LOGGER.debug("Finding discipline by id: " + id);
        return disciplineRepository.findOne(id);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class)
    @Override
    public Discipline update(DisciplineDto updated) throws EntityNotFoundException {
        LOGGER.debug("Updating discipline with information: " + updated);

        Discipline discipline = disciplineRepository.findOne(updated.getId());

        if (discipline == null) {
            LOGGER.debug("No person found with id: " + updated.getId());
            throw new EntityNotFoundException("No person found with id: " + updated.getId());
        }

        discipline = new Discipline.Builder().update(discipline).setName(updated.getName())
                .setCategoriesFromModel(updated.getCategories()).build();

        disciplineRepository.save(discipline);

        return discipline;
    }

    @VisibleForTesting
    protected void setDisciplineRepository(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }
}
