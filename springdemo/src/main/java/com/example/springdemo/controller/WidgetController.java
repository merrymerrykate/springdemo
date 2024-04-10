package com.example.springdemo.controller;


import com.example.springdemo.model.Widget;
import com.example.springdemo.service.WidgetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/widgets")
public class WidgetController {
    private final WidgetService service;

    public WidgetController(WidgetService service) {
        this.service = service;
    }

    @PostMapping
    public Widget createWidget(@RequestBody Widget widget) {
        return service.createOrUpdateWidget(widget);
    }

    @PutMapping("/{id}")
    public Widget updateWidget(@PathVariable Long id, @RequestBody Widget widget) {
        widget.setId(id);
        return service.createOrUpdateWidget(widget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWidget(@PathVariable Long id) {
        service.deleteWidget(id);
    }

    @GetMapping("/{id}")
    public Widget getWidgetById(@PathVariable Long id) {
        return service.getWidget(id);
    }

    @GetMapping
    public List<Widget> getAllWidgets() {
        return service.getAllWidgets();
    }

}
