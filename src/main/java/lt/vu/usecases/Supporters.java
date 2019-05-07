package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Supporter;
import lt.vu.persistence.SupportersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Supporters {

    @Inject
    private SupportersDAO supportersDAO;
    @Getter
    private List<Supporter> allSupporters;
    @Getter @Setter
    private Supporter newSupporter = new Supporter();

    @PostConstruct
    public void init() {
        this.loadSupporters();
    }

    @Transactional
    public String createNewSupporter() {
        supportersDAO.save(newSupporter);
        return "success";
    }

    private void loadSupporters() {
        this.allSupporters = supportersDAO.loadAll();
    }
}