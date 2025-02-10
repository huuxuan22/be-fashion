package com.example.projectc1023i1.Exception.ErrorInfor;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {
    private String error;
    private String message;
    private LocalDateTime timestamp;
}
