package org.springproj.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springproj.repository.CircuitDAO;
import org.springproj.service.CircuitService;


@Service
@Scope("prototype")
public class CircuitServiceBean implements CircuitService {

    private CircuitDAO circuitDao;



}
