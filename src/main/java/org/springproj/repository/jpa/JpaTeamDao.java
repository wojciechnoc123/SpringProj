package org.springproj.repository.jpa;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springproj.model.Team;
import org.springproj.repository.TeamDAO;

import java.util.List;

@Repository
@Primary
public class JpaTeamDao implements TeamDAO {

    private final TeamJpaRepository teamRepository;

    public JpaTeamDao(TeamJpaRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findByName(String name) {
        return this.teamRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Team> findAll() {
        return this.teamRepository.findAll();
    }

    @Override
    public Team findById(int id) {
        return this.teamRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Team saveTeam(Team team) {
        return this.teamRepository.save(team);
    }
}
