package ru.egalvi.problem.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.egalvi.problem.core.domain.DisciplineDto;
import ru.egalvi.problem.persistence.service.DisciplineService;

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
    public String listAllProblems(Model model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        return "discipline";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String create(@ModelAttribute("discipline")DisciplineDto disciplineDto, Model model) {
        model.addAttribute("foo", "You've asked for problem with id. Not implemented yet");
        return "redirect:discipline";
    }
}
