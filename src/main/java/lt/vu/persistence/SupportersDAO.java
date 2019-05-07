package lt.vu.persistence;

import lt.vu.entities.Supporter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class SupportersDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Supporter> loadAll() { return em.createNamedQuery("Supporter.findAll", Supporter.class).getResultList(); }

    public void save(Supporter supporter) {
        this.em.persist(supporter);
    }
}