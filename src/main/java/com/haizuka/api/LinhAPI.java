package com.haizuka.api;

import java.util.List;

import com.haizuka.api.output.HaizukaOutput;
import com.haizuka.service.impl.IHaizukaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
  public HaizukaOutput showHaizuka(@RequestParam("page") int page, @RequestParam("limit") int limit) {
    HaizukaOutput haizukaOutput = new HaizukaOutput();
    haizukaOutput.setPage(page);
    Pageable pageable = PageRequest.of(page - 1, limit);

    haizukaOutput.setListResult(haizukaService.findAll(pageable));
    haizukaOutput.setTotalPage((int)(Math.ceil((double)haizukaService.totalItem() / limit)));
    return haizukaOutput;
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