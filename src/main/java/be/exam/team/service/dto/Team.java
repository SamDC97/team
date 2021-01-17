package be.exam.team.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    private Long id;
    private String name;
    private Long carId;
    private Long driverId1;
    private Long driverId2;

    private Car car;
    private Driver driver1;
    private Driver driver2;
}
