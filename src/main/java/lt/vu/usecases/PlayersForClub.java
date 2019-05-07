package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Club;
import lt.vu.entities.Player;
import lt.vu.persistence.ClubsDAO;
import lt.vu.persistence.PlayersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class PlayersForClub {

    @Getter @Setter
    private Club club;
    @Getter @Setter
    private Player newPlayer = new Player();
    @Inject
    private PlayersDAO playersDAO;
    @Inject
    private ClubsDAO clubsDAO;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer clubId = Integer.parseInt(requestParameters.get("clubId"));
        this.club = clubsDAO.findOne(clubId);
    }

    @Transactional
    public String createPlayer() {
        newPlayer.setClub(this.club);
        playersDAO.save(newPlayer);
        return "players?faces-redirect=true&clubId=" + this.club.getId();
//        return "/mybatis/players.xhtml?faces-redirect=true&clubId=" + this.club.getId();
    }

}