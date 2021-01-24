package be.exam.team.web;

import be.exam.team.service.TeamService;
import be.exam.team.service.dto.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamResource {

    @Autowired
    private TeamService teamService;

    @PostMapping("/add-team")
    public void addTeam(@RequestBody Team team){
        teamService.addTeam(team);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAll(){
        List<Team> teamList = teamService.getAll();
        return new ResponseEntity<>(teamList, HttpStatus.OK);
    }

    @GetMapping("/team/{id}")
    public ResponseEntity<Team> getById(@PathVariable Long id){
        return new ResponseEntity<>(teamService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/get-team-by-driver/{id}")
    public ResponseEntity<Team> getTeamByDriverId(@PathVariable Long id){
        return new ResponseEntity<>(teamService.getTeamByDriverId(id), HttpStatus.OK);
    }
}
