package jpapicture.picture.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String password;

    private String name;

    private String email;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
