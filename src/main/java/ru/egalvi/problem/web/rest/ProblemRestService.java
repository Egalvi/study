package ru.egalvi.problem.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.egalvi.problem.persistence.service.ProblemService;

import javax.annotation.Resource;

/**
 *
 */
@Controller
@RequestMapping("/problem")
public class ProblemRestService {

    @Resource
    private ProblemService problemService;

    @RequestMapping("")
    public String listAllProblems(Model model) {
        model.addAttribute("problems", problemService.findAll());
        return "problem";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findProblemById(@PathVariable(value = "id") String id, Model model) {
        model.addAttribute("foo", "You've asked for problem with id " + id + ". Not implemented yet");
        return "problem";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteProblemById(@PathVariable(value = "id") String id, Model model) {
        model.addAttribute("foo", "You've asked to delete problem with id " + id + ". Not implemented yet");
        return "problem";
    }


}
