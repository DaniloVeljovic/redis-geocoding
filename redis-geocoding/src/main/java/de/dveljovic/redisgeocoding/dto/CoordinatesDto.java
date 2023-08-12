package de.dveljovic.redisgeocoding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesDto {
    private double latitude;
    private double longitude;
}
