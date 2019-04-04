package by.tms.finalProject.controller;

import by.tms.finalProject.entity.*;
import by.tms.finalProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;

@Controller
@RequestMapping(path = "logAdmin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "classPlace")
    public ModelAndView getFormClass(ModelAndView modelAndView){
        modelAndView.setViewName("classPlace");
        modelAndView.addObject("classPlace", new PlaceClass());
        return modelAndView;
    }

    @PostMapping(path = "classPlace")
    public ModelAndView setFormClass(@Valid @ModelAttribute("classPlace") PlaceClass placeClass, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logAdmin/place");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }

        if(adminService.findPlaceClass(placeClass) != null){
            httpServletRequest.getSession().setAttribute("errorPlaceClass", "Такой класс уже добавлен");
            modelAndView.setViewName("classPlace");
            return modelAndView;
        }
        adminService.addPlaceClass(placeClass);
        httpServletRequest.getSession().setAttribute("currentPlaceClass", placeClass);
        return modelAndView;
    }

    @GetMapping(path = "place")
    public ModelAndView getFormPlace(ModelAndView modelAndView){
        modelAndView.setViewName("place");
        modelAndView.addObject("newPlace", new Place());
        return modelAndView;
    }

    @PostMapping(path = "place")
    public ModelAndView setFormPlace(@Valid @ModelAttribute("newPlace") Place place, BindingResult bindingResult, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logAdmin/place");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("redirect:/logAdmin/place");
            return modelAndView;
        }
        if(adminService.findPlace(place) != null){
            httpServletRequest.getSession().setAttribute("error", "Такое место уже введено");
            modelAndView.setViewName("place");
            return modelAndView;
        }
        PlaceClass placeClass = (PlaceClass) httpServletRequest.getSession().getAttribute("currentPlaceClass");
        place.setPlaceClass(placeClass);
        adminService.addPlace(place);
        return modelAndView;
    }

    @GetMapping(path = "flight")
    public ModelAndView viewFlight(ModelAndView modelAndView){
        modelAndView.setViewName("flight");
        return modelAndView;
    }

    @PostMapping(path = "flight")
    public ModelAndView setFormFlight(@RequestParam("date") Date date,@RequestParam("cityFrom") String cityFrom,@RequestParam("cityTo") String cityTo, ModelAndView modelAndView, HttpServletRequest httpServletRequest){
        modelAndView.setViewName("redirect:/logAdmin/flight");
        Flight flight = new Flight();
        City _cityFrom = new City();
        City _cityTo = new City();
        _cityFrom.setNameCity(cityFrom);
        _cityTo.setNameCity(cityTo);
        flight.setFlightDate(date);
        flight.setCityFrom(adminService.findCity(_cityFrom));
        flight.setCityTo(adminService.findCity(_cityTo));
        adminService.addFlight(flight);
        httpServletRequest.getSession().setAttribute("listFlights", adminService.getAllListFlights());
        return modelAndView;
    }

    @GetMapping(path = "removeCity")
    public ModelAndView getRemoveCity(ModelAndView modelAndView){
        modelAndView.setViewName("removeCity");
        modelAndView.addObject("removeCity", new City());
        return modelAndView;
    }

    @PostMapping(path = "removeCity")
    public ModelAndView setRemoveCity(@Valid @ModelAttribute("removeCity") City city, BindingResult bindingResult, ModelAndView modelAndView){
        modelAndView.setViewName("redirect:/logAdmin/removeCity");
        if(bindingResult.hasErrors()){
            return modelAndView;
        }
        adminService.removeCity(city);
        return modelAndView;
    }

}
