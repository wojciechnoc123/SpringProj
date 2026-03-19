package org.springproj.repository.sampleMem;


import org.springframework.stereotype.Repository;
import org.springproj.repository.CircuitDAO;
import org.springproj.model.Circuit;
import java.util.List;

@Repository("circuitDao")
public class MemCircuitDAO implements CircuitDAO {


    @Override
    public List<Circuit> findAll() {
        return SampleData.sampleCircuits;
    }

    @Override
    public Circuit findById(int id) {
        return SampleData.sampleCircuits.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Circuit findByName(String name) {
        return SampleData.sampleCircuits.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
    }


}
