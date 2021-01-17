package be.exam.team.service.mapper;

import be.exam.team.domain.TeamEntity;
import be.exam.team.service.dto.Car;
import be.exam.team.service.dto.Driver;
import be.exam.team.service.dto.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public TeamEntity toEntity(Team team){
        return new TeamEntity(team.getId(), team.getName(), team.getCarId(), team.getDriverId1(), team.getDriverId2());
    }

    public Team toDTO(TeamEntity teamEntity){
        return new Team(teamEntity.getId(), teamEntity.getName(), teamEntity.getCarId(), teamEntity.getDriverId1(), teamEntity.getDriverId2(),
                new Car(), new Driver(), new Driver());
    }
}
