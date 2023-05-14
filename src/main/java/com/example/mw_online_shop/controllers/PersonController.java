package com.itstep.springapp.controllers;

import com.itstep.springapp.daos.PersonDao;
import com.itstep.springapp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {
    private PersonDao personDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @ModelAttribute(value = "myEntity")
    public Person newEntity() {
        return new Person();
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("personList", personDao.getAll());
        return "person/all";
    }

    @GetMapping("/add")
    public String getAdd(@ModelAttribute("myEntity") Person person) {
        return "person/add";
    }

    @PostMapping("/add")
    public String addAction(@ModelAttribute("myEntity") @Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "person/add";
        }
        personDao.save(person);
        return "redirect:/person";
    }

    @GetMapping("/edit/{id}")
    public String getEdit(@PathVariable("id") Integer id, Model model) {
        Person person = personDao.getById(id);
        if(person != null) {
            model.addAttribute("person", person);
            return "person/edit";
        }
        return "redirect:/person";
    }

    @PutMapping("/edit")
    public String editAction(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors())  {
            return "person/edit";
        }
        personDao.edit(person);
        return "redirect:/person";
    }

    @DeleteMapping("/delete/{id}")
    public String getDelete(@PathVariable("id") Integer id) {
        Person person = personDao.getById(id);
        personDao.delete(person);
        return "redirect:/person";
    }
}
