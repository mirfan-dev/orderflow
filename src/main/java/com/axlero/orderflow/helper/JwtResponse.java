package com.axlero.orderflow.helper;

import com.axlero.orderflow.dto.CustomerDtos;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {

    private String accessToken;

    private String refreshToken;

    private CustomerDtos user;
}
