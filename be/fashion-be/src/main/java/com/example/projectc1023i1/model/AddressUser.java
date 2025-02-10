package com.example.projectc1023i1.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AddressUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_user_id")
    private Integer addressUserId;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "commune")
    private String commune;

    @Column(name = "home_address")
    private String homeAddress;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

}
