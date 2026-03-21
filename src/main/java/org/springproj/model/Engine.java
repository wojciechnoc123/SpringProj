package org.springproj.model;

public class Engine {
    private int id;
    private String name;
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
