package ru.egalvi.problem.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.egalvi.problem.core.domain.DisciplineDto;
import ru.egalvi.problem.persistence.service.DisciplineService;
import ru.egalvi.problem.persistence.service.EntityNotFoundException;

import javax.annotation.Resource;

/**
 *
 */
@Controller
@RequestMapping("/discipline")
public class DisciplineRestService
{
    @Resource
    private DisciplineService disciplineService;

    @RequestMapping("")
    public String listAll(Model model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        model.addAttribute("disciplineDto", new DisciplineDto());
        return "discipline";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Long id, Model model) throws EntityNotFoundException{
        disciplineService.delete(id);
        return "redirect:/discipline";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String create(@ModelAttribute("discipline")DisciplineDto disciplineDto, Model model) {
        disciplineService.create(disciplineDto);
        return "redirect:/discipline";
    }
}
