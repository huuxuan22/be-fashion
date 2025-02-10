package com.example.projectc1023i1.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {
    private String fullName;
    private String profilePicture;
}
