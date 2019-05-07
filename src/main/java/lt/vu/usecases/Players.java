package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Player;
import lt.vu.persistence.PlayersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Players {

    @Inject
    private PlayersDAO playersDAO;
    @Getter
    private List<Player> allPlayers;
    @Getter @Setter
    private Player newPlayer = new Player();

    @PostConstruct
    public void init() {
        this.loadPlayers();
    }

    @Transactional
    public String createNewPlayer() {
        playersDAO.save(newPlayer);
        return "success";
    }

    private void loadPlayers() {
        this.allPlayers = playersDAO.loadAll();
    }
}