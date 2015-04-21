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
import org.test.hellobeer.model.Beer;
import org.test.hellobeer.model.Brewery;
import org.test.hellobeer.repository.BeerRepository;
import org.test.hellobeer.repository.BreweryRepository;

@Controller
public class BeerController {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BreweryRepository breweryRepository;

    /**
     * @param model
     * @return
     */
    @RequestMapping("/hellobeer")
    public String menu(Model model) {
        return "menu";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping("/beers")
    public String listBeers(Model model) {

        List<Beer> beerList = new ArrayList<Beer>();

        for (Beer beer : beerRepository.findAll()) {
            beerList.add(beer);
        }

        model.addAttribute("beerList", beerList);

        return "list-beers";
    }

    /**
     * @param beer
     * @param brewer
     * @param model
     * @return
     */
    @RequestMapping(value = "/newBeer", method = RequestMethod.GET)
    public String newBeerForm(Beer beer, Brewery brewery, Model model) {

        // Necessary for the form to know where to put the brewery so the
        // response gets validated
        beer.setBrewery(brewery);
        model = setBreweryList(model);

        return "new-beer-form";
    }

    /**
     * @param beer
     * @param brewer
     * @param model
     * @return
     */
    private final Model setBreweryList(Model model) {

        List<Brewery> breweriesList = new ArrayList<Brewery>();

        for (Brewery brewery : breweryRepository.findAll()) {
            breweriesList.add(brewery);
        }

        model.addAttribute("breweryList", breweriesList);

        return model;
    }

    /**
     * @param beer
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/addBeer", method = RequestMethod.POST)
    public String addBeer(@ModelAttribute @Valid Beer beer,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model = setBreweryList(model);
            return "new-beer-form";
        }
        beerRepository.save(beer);
        model.addAttribute("beer", beer);

        // return "detail-beer";
        return "redirect:/beers";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleteBeer", method = RequestMethod.GET)
    public String deleteBeer(@RequestParam("id") long id, Model model) {

        Beer beer = beerRepository.findById(id);

        if (beer != null) {
            beerRepository.delete(beer);
            model.addAttribute("name", beer.getName());

            // return "delete-beer-result";
            return "redirect:/beers";
        } else {
            return "error";
        }
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail-beer", method = RequestMethod.GET)
    public String detailBeer(@RequestParam("id") long id, Model model) {

        Beer beer = beerRepository.findById(id);

        if (beer != null) {
            model.addAttribute("beer", beer);
            return "detail-beer";
        }

        else {
            return "error";
        }
    }
}
