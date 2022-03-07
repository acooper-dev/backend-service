package com.empmgmt.dataservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"role_name"})
})
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;
    @Column(name = "role_name")
    private String roleName;

    @Column(name = "create_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private Set<User> user;
}
