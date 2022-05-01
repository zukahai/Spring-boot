package com.haizuka.api;

import java.util.List;

import com.haizuka.service.impl.IHaizukaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import haizuka.dto.HaiZukaDTO;

@RestController

public class LinhAPI {

  @Autowired
  private IHaizukaService haizukaService;

  // @GetMapping("/")
  // public ModelAndView welcome() {
  // ModelAndView modelAndView = new ModelAndView();
  // modelAndView.setViewName("index");
  // return modelAndView;
  // }

  // @GetMapping("/")
  // public String welcome() {
  // return "Hello";
  // }

  @GetMapping(value = "/hai")
  public String show(String s) {
    return (Integer.parseInt(s) + 1) + "";
  }

  @GetMapping(value = "/linh")
  public List<HaiZukaDTO> show() {
    return haizukaService.findAll();
  }

  @PostMapping(value = "/linh")
  public HaiZukaDTO create(@RequestBody HaiZukaDTO model) {
    return haizukaService.save(model);
  }

  @PutMapping(value = "/linh/{id}")
  public HaiZukaDTO update(@RequestBody HaiZukaDTO model, @PathVariable ("id") int id) {
    model.setId(id);
    return haizukaService.update(model);
  }

  @DeleteMapping(value = "/linh")
  public void delete(@RequestBody int[] ids) {
    haizukaService.delete(ids);
  }
}