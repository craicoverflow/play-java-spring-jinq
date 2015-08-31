package services;


import models.Bar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import play.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
@Transactional
public class BarServiceImpl implements BarService {

    @PersistenceContext
    EntityManager em;

    @Autowired
    JinqSource source;

    @Override
    public void addBar(Bar bar) {
        em.persist(bar);
    }

    @Override
    public List<Bar> getAllBars() {
        return source.bars(em).toList();
    }

}