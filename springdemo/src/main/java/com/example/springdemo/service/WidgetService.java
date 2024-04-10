package com.example.springdemo.service;

import com.example.springdemo.model.Widget;
import com.example.springdemo.repositories.WidgetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WidgetService {
    private final WidgetRepository repository;

    public WidgetService(WidgetRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Widget createOrUpdateWidget(Widget widget) {
        return repository.save(widget);
    }

    public void deleteWidget(Long id) {
        repository.deleteById(id);
    }

    public Widget getWidget(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Widget> getAllWidgets() {
        return repository.findAllByOrderByZAsc();
    }

}
