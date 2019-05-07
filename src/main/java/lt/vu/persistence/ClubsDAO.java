package lt.vu.persistence;

import lt.vu.entities.Club;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ClubsDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Club> loadAll() {
        return em.createNamedQuery("Club.findAll", Club.class).getResultList();
    }

    public Club findOne(Integer id) {
        return em.find(Club.class, id);
    }

    public void save(Club club) {
        this.em.persist(club);
    }

    public Club update(Club club) {
        return em.merge(club);
    }
}