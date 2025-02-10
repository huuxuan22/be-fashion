package com.example.projectc1023i1.request;

import com.example.projectc1023i1.model.AddressUser;
import com.example.projectc1023i1.respone.UserRespone;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetInforEmployeeUpdate {
    private UserRespone userRespone;
    private AddressUser addressUser;
}
