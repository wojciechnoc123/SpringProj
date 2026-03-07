package org.springproj.repository;

import org.springproj.model.TeamEntry;
import java.util.List;

public interface TeamEntryDao {

    List<TeamEntry> findAll();

}
