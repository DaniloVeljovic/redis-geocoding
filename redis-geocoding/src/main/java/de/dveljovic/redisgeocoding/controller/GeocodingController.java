package de.dveljovic.redisgeocoding.controller;

import de.dveljovic.redisgeocoding.domain.Location;
import de.dveljovic.redisgeocoding.dto.CoordinatesDto;
import de.dveljovic.redisgeocoding.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GeocodingController {

    private final LocationService locationService;

    @GetMapping(path = "/location")
    public ResponseEntity<List<Location>> returnNearbyLocations(@RequestBody CoordinatesDto coordinates) {
        final List<Location> locations = locationService.findLocations(coordinates.getLatitude(), coordinates.getLongitude());
        return ResponseEntity.ok(locations);
    }
}
