package ru.egalvi.problem.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
