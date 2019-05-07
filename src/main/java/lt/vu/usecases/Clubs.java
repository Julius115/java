package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Club;
import lt.vu.persistence.ClubsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Clubs {

    @Inject
    private ClubsDAO clubsDAO;
    @Getter
    private List<Club> allClubs;
    @Getter @Setter
    private Club newClub = new Club();

    @PostConstruct
    public void init() {
        this.loadClubs();
    }

    @Transactional
    public String createNewClub() {
        String title = "FC " + newClub.getTitle();
        newClub.setTitle(title);
        clubsDAO.save(newClub);
        return "index?faces-redirect=true";
    }

    private void loadClubs() {
        this.allClubs = clubsDAO.loadAll();
    }
}