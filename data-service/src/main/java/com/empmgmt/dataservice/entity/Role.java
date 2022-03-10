package com.empmgmt.dataservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"role_name"})
})
public class Role {

    public Role(long roleId, String roleName, LocalDateTime createdAt) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "create_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private Set<User> users = new HashSet<>();

    public void addUser(User user){
        this.getUsers().add(user);
    }

    public void removeUser(long userid){
        this.getUsers().stream().filter(u -> u.getUserId() == userid).findFirst().ifPresent(user -> this.getUsers().remove(user));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return Objects.equals(this.getRoleId(), role.getRoleId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getRoleId());
    }
}
