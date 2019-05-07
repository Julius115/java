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
        @NamedQuery(name = "Supporter.findAll", query = "select a from Supporter as a")
})
@Table(name = "SUPPORTER")
public class Supporter implements Serializable {

    public Supporter() {}

    public Supporter(String name) { this.name = name; }

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Getter @Setter
    @ManyToMany
    @JoinColumn(name = "PLAYER_ID")
    private List<Player> players;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supporter supporter = (Supporter) o;
        return Objects.equals(name, supporter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}