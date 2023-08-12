package de.dveljovic.redisgeocoding.repository;

import de.dveljovic.redisgeocoding.domain.Location;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {
    List<Location> findByLocationWithin(Circle args);
}
