package org.springproj.repository.sampleMem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springproj.model.TeamEntry;
import org.springproj.repository.TeamEntryDao;

import java.util.List;

@Repository("teamEntryDao")
public class MemTeamEntryDao implements TeamEntryDao {

    public List<TeamEntry> findAll() {
        return SampleData.sampleTeamEntries;
    }

}
