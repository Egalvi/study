package ru.egalvi.problem.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.egalvi.problem.core.domain.CategoryDto;
import ru.egalvi.problem.core.domain.DisciplineDto;
import ru.egalvi.problem.persistence.service.CategoryService;
import ru.egalvi.problem.persistence.service.DisciplineService;
import ru.egalvi.problem.persistence.service.EntityNotFoundException;

import javax.annotation.Resource;

/**
 *
 */
@Controller
@RequestMapping("/discipline/{disciplineId}")
public class CategoryRestService {
    @Resource
    private DisciplineService disciplineService;
    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable(value = "id") Long id, Model model) throws EntityNotFoundException {
        model.addAttribute("category", categoryService.findById(id));
        return "category";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Long id, Model model) throws EntityNotFoundException {
        categoryService.delete(id);
        return "category";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String create(@PathVariable(value = "disciplineId") Long disciplineId,
        @ModelAttribute("categoryDto") CategoryDto categoryDto, Model model) throws EntityNotFoundException {
        DisciplineDto disciplineDto = disciplineService.findById(disciplineId);
//        categoryDto = categoryService.create(categoryDto);
        disciplineDto.getCategories().add(categoryDto);
//        categoryDto.setDiscipline(disciplineDto);
        disciplineService.update(disciplineDto);
        return "redirect:/discipline/{disciplineId}";
    }
}
