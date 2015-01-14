package ru.egalvi.problem.web.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/problem")
public class ProblemRestService {

    @RequestMapping("")
    public String listAllProblems() {
        return "Not implemented yet";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findProblemById(@PathVariable(value = "id") String id) {
        return "You've asked for problem with id " + id + ". Not implemented yet";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteProblemById(@PathVariable(value = "id") String id) {
        return "You've asked to delete problem with id " + id + ". Not implemented yet";
    }


}
