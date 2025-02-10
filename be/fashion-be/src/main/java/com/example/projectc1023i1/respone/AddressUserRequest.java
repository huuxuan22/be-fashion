package com.example.projectc1023i1.respone;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressUserRequest {
    private String province;
    private String district;
    private String commune;
    private String address;
}
