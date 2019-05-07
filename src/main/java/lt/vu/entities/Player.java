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
        @NamedQuery(name = "Player.findAll", query = "select a from Player as a")
})
@Table(name = "PLAYER")
public class Player implements Serializable {

    public Player() {}

    public Player(String name) {
        this.name = name;
    }

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    private Club club;

    @Getter @Setter
    @ManyToMany(mappedBy = "players")
    private List<Supporter> supporters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}