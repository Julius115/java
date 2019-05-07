package lt.vu.persistence;

import lt.vu.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PlayersDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Player> loadAll() {
        return em.createNamedQuery("Player.findAll", Player.class).getResultList();
    }

    public void save(Player player) {
        this.em.persist(player);
    }
}