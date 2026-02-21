package sameer.create_login_account.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_tbl")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private  String Name;

    @Column(unique = true)
    private String email;
    private String Password;
    private String role = "ROLE_USER";


}
