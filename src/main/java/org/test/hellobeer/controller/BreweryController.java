package org.test.hellobeer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.hellobeer.model.Brewery;
import org.test.hellobeer.repository.BreweryRepository;

@Controller
public class BreweryController {

    @Autowired
    BreweryRepository breweryRepository;

    /**
     * @param model
     * @return
     */
    @RequestMapping(value = "/breweries")
    public String listBreweries(Model model) {

        List<Brewery> breweryList = new ArrayList<Brewery>();

        for (Brewery brewery : breweryRepository.findAll()) {
            breweryList.add(brewery);
        }

        model.addAttribute("breweryList", breweryList);

        return "list-breweries";
    }

    /**
     * @param brewery
     * @param model
     * @return
     */
    @RequestMapping(value = "/newBrewery", method = RequestMethod.GET)
    public String newBreweryForm(Brewery brewery, Model model) {
        return "new-brewery-form";
    }

    /**
     * @param brewery
     * @param model
     * @return
     */
    @RequestMapping(value = "/addBrewery", method = RequestMethod.POST)
    public String addBrewery(@ModelAttribute @Valid Brewery brewery,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "new-brewery-form";
        }

        breweryRepository.save(brewery);
        model.addAttribute("brewery", brewery);

        // return "detail-brewery";
        return "redirect:/breweries";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteBrewery", method = RequestMethod.GET)
    public String deleteBeer(@RequestParam("id") long id, Model model) {
        Brewery brewery = breweryRepository.findById(id);

        // TODO: Delete a brewery should result in deleting its beers?
        // Or do not allow the action if the brewery has beers?
        if (brewery != null) {
            breweryRepository.delete(brewery);
            model.addAttribute("name", brewery.getName());

            // return "delete-brewery-result";
            return "redirect:/breweries";
        } else {
            return "error";
        }
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail-brewery", method = RequestMethod.GET)
    public String detailBrewery(@RequestParam("id") long id, Model model) {

        Brewery brewery = breweryRepository.findById(id);

        if (brewery != null) {
            model.addAttribute("brewery", brewery);
            return "detail-brewery";
        } else {
            return "error";
        }
    }
}
