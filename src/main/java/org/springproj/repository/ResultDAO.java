package org.springproj.repository;

import org.springproj.model.Driver;
import org.springproj.model.Result;

public interface ResultDAO {

    Result findByPosition(int position);
    Result findByDriver(Driver driver);

}
