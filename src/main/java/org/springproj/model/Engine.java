package org.springproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "engine")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "engine_supplier_id")
    private EngineSupplier engineSupplier;

    public Engine(int id, String name, EngineSupplier engineSupplier) {
        this.id = id;
        this.name = name;
        this.engineSupplier = engineSupplier;
    }

    public Engine() {}

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EngineSupplier getEngineSupplier() {
        return this.engineSupplier;
    }

    public void setEngineSupplier(EngineSupplier engineSupplier) {
        this.engineSupplier = engineSupplier;
    }

    public String getEngineSupplierName() {
        return this.engineSupplier.getName();
    }

}
