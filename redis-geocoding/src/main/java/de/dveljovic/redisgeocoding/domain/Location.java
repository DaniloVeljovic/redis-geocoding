package de.dveljovic.redisgeocoding.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.GeoIndexed;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "Location")
public class Location {
    private String id;
    private String name;
    @GeoIndexed
    private Point location;
}
