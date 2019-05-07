package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Club.findAll", query = "select a from Club as a")
})
@Table(name = "CLUB")
public class Club implements Serializable {

    public Club() {
    }

    public Club(String title) {
        this.title = title;
    }

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;

    @Getter @Setter
    @Size(max = 50)
    @Column(name = "STADIUM")
    private String stadium;

    @Getter @Setter
    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @Getter @Setter
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER)
    private List<Player> players;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(title, club.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}