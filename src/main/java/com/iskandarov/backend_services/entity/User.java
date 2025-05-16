package com.iskandarov.backend_services.entity;

import com.iskandarov.backend_services.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "app_users")
public class User {
  @Id @GeneratedValue private Long id;

  @NotBlank
  @Size(min = 3, max = 50)
  @Column(nullable = false, unique = true)
  private String username;

  @NotBlank
  @Size(min = 8)
  @Column(nullable = false)
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;
}
