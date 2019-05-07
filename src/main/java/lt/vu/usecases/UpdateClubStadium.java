package lt.vu.usecases;

import lt.vu.entities.Club;
import lt.vu.persistence.ClubsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class UpdateClubStadium implements Serializable {

    private Club club;

    @Inject
    private ClubsDAO clubsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateClubStadium INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer clubId = Integer.parseInt(requestParameters.get("clubId"));
        this.club = clubsDAO.findOne(clubId);
    }

    @Transactional
    public String updateClubStadium() {
        try{
            clubsDAO.update(club);
        } catch (OptimisticLockException e) {
            return "/club.xhtml?faces-redirect=true&clubId=" + this.club.getId() + "&error=optimistic-lock-exception";
        }
        return "/index.xhtml";
    }

    @Transactional
    public String updateClubStadiumSlow() throws InterruptedException {
        try{
            Thread.sleep(5000);
            clubsDAO.update(club);
        } catch (OptimisticLockException e) {
            return "/club.xhtml?faces-redirect=true&clubId=" + this.club.getId() + "&error=optimistic-lock-exception";
        }
        return "/index.xhtml";
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
