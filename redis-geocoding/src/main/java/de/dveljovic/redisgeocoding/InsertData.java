package de.dveljovic.redisgeocoding;

import com.opencsv.CSVReader;
import de.dveljovic.redisgeocoding.domain.Location;
import de.dveljovic.redisgeocoding.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Slf4j
@Component
@RequiredArgsConstructor
public class InsertData {

    private final LocationService locationService;

    @SneakyThrows
    @EventListener(ApplicationReadyEvent.class)
    public void setup() {
        locationService.deleteAllLocations();

        try(CSVReader csvReader = new CSVReader(new FileReader("./src/main/resources/location.csv"))) {
            String[] line;
            csvReader.readNext();
            while((line = csvReader.readNext()) != null) {
                locationService.saveLocation(
                        Location.builder()
                                .name(line[0])
                                .location(new Point(Double.parseDouble(line[2]), Double.parseDouble(line[1])))
                                .build()
                );
            }
        }
        log.info("Inserted the data into Redis");
    }
}
