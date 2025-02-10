package com.example.projectc1023i1.respone;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorRespones {
    private String message;
    private int status;
}
