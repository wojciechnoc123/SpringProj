package org.springproj.service;
import org.springproj.model.Circuit;
import java.util.List;

public interface CircuitService {

    List<Circuit> findAll();

    Circuit findById(int id);

    Circuit findByName(String name);


}
