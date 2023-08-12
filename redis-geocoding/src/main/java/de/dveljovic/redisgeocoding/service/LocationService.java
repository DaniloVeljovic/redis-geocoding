package de.dveljovic.redisgeocoding.service;

import de.dveljovic.redisgeocoding.domain.Location;
import de.dveljovic.redisgeocoding.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    @Value("${location.radius}")
    private Double radius;

    private final LocationRepository locationRepository;

    public void deleteAllLocations() {
        locationRepository.deleteAll();
    }

    public void saveLocation(final Location location) {
        locationRepository.save(location);
    }

    public List<Location> findLocations(final double latitude, final double longitude) {
        final Circle circle = new Circle(new Point(longitude, latitude), new Distance(radius, Metrics.KILOMETERS));
        return locationRepository.findByLocationWithin(circle);
    }
}
