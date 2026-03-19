package org.springproj.repository;


import org.springproj.model.Circuit;
import java.util.List;

public interface CircuitDAO {


    List<Circuit> findAll();

    Circuit findById(int id);

    Circuit findByName(String name);

}
