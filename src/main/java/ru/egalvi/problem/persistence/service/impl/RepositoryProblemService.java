package ru.egalvi.problem.persistence.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.egalvi.problem.config.OrikaMappings;
import ru.egalvi.problem.core.domain.CategoryDto;
import ru.egalvi.problem.core.domain.ProblemDto;
import ru.egalvi.problem.persistence.domain.Problem;
import ru.egalvi.problem.persistence.repository.ProblemRepository;
import ru.egalvi.problem.persistence.service.EntityNotFoundException;
import ru.egalvi.problem.persistence.service.ProblemService;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class RepositoryProblemService implements ProblemService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryCategoryService.class);

    @Resource
    private ProblemRepository problemRepository;

    @Resource
    private OrikaMappings orikaMappings;

    @Override
    public ProblemDto create(ProblemDto created) {
        LOGGER.debug(created.toString());
        return orikaMappings.getMapper()
            .map(problemRepository.save(orikaMappings.getMapper().map(created, Problem.class)), ProblemDto.class);
    }

    @Override
    public ProblemDto delete(Long id) throws EntityNotFoundException {
        LOGGER.debug("Deleting category with id: " + id);
        Problem deleted = problemRepository.findOne(id);
        if (deleted == null) {
            LOGGER.debug("No discipline with id: " + id);
            throw new EntityNotFoundException("No discipline with id: " + id);
        }
        problemRepository.delete(deleted);
        return orikaMappings.getMapper().map(deleted, ProblemDto.class);
    }

    @Override
    public Iterable<ProblemDto> findAll() {
        LOGGER.debug("Selecting all categories");
        return orikaMappings.getMapper().mapAsList(problemRepository.findAll(), ProblemDto.class);
    }

    @Override
    public ProblemDto findById(Long id) {
        LOGGER.debug("Finding category by id: " + id);
        return orikaMappings.getMapper().map(problemRepository.findOne(id), ProblemDto.class);
    }

    @Override
    public Iterable<ProblemDto> findByCategory(CategoryDto categoryDto) {
        //TODO implement!
        return null;
    }

    @Override
    public ProblemDto update(ProblemDto updated) throws EntityNotFoundException {
        LOGGER.debug("Updating category with information: " + updated);

        Problem problem = problemRepository.findOne(updated.getId());

        if (problem == null) {
            LOGGER.debug("No person found with id: " + updated.getId());
            throw new EntityNotFoundException("No person found with id: " + updated.getId());
        }

        Problem saved = problemRepository.save(orikaMappings.getMapper().map(updated, Problem.class));

        return orikaMappings.getMapper().map(saved, ProblemDto.class);
    }
}
