package org.springproj.repository;

import org.springproj.model.DriverEntry;

import java.util.List;

public interface DriverEntryDao {

    List<DriverEntry> findAll();

}
