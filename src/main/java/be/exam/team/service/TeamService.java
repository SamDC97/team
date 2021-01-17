package be.exam.team.service;

import be.exam.team.domain.TeamEntity;
import be.exam.team.domain.repository.TeamRepository;
import be.exam.team.service.dto.Car;
import be.exam.team.service.dto.Driver;
import be.exam.team.service.dto.Team;
import be.exam.team.service.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMapper teamMapper;
    @Value("${url.car}")
    private String carURL;
    @Value("${url.driver}")
    private String driverURL;

    @Autowired
    private RestTemplate restTemplate;

    public void addTeam(Team team){
        teamRepository.save(teamMapper.toEntity(team));
    }

    public Team getById(Long id){
        Optional<TeamEntity> optionalTeamEntity = teamRepository.findById(id);
        if (optionalTeamEntity.isPresent()){
            Team team = teamMapper.toDTO(optionalTeamEntity.get());
            team.setCar(getRESTCar(team.getCarId()));
            team.setDriver1(getRESTDriver(team.getDriverId1()));
            team.setDriver2(getRESTDriver(team.getDriverId2()));
            return team;
        }
        return null;
    }

    public List<Team> getAll(){
        List<Team> teamList = StreamSupport.stream(teamRepository.findAll().spliterator(), false)
                .map(t -> teamMapper.toDTO(t))
                .collect(Collectors.toList());

        for (Team team : teamList){
            team.setCar(getRESTCar(team.getCarId()));
            team.setDriver1(getRESTDriver(team.getDriverId1()));
            team.setDriver2(getRESTDriver(team.getDriverId2()));
        }

        return teamList;
    }

    private Car getRESTCar(Long carId){
        try{
            URI carURI = new URI(carURL + carId);
            return restTemplate.getForObject(carURI, Car.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Driver getRESTDriver(Long driverId){
        try{
            URI driverURI = new URI(driverURL + driverId);
            return restTemplate.getForObject(driverURI, Driver.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
