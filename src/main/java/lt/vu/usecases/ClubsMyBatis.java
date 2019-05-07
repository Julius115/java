package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.usecases.mybatis.dao.ClubMapper;
import lt.vu.usecases.mybatis.model.Club;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ClubsMyBatis {

    @Inject
    private ClubMapper clubMapper;

    @Getter
    private List<Club> allClubs;
    @Getter @Setter
    private Club newClub = new Club();

    @PostConstruct
    public void init() {
        this.loadClubs();
    }

    private void loadClubs() {
        this.allClubs = clubMapper.selectAll();
    }

    @Transactional
    public String createNewClub() {
        clubMapper.insert(newClub);
        return "/mybatis/clubs?faces-redirect=true";
    }
}