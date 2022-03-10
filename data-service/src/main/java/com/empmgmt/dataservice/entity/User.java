package com.empmgmt.dataservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_name"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "create_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

//    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "users")
//    private Set<Role> roles = new HashSet<Role>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(this.getUserId(), user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }
}
