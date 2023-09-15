import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.player.model.Player;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    public class PlayerService {

    @Autowired
    public PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
       List<Player> players = playerService.getAllPlayers();
       return players;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player addPlayer(@RequestBody Player player) {
        
        Player addedPlayer = playerService.addPlayer(player);
        
        return addedPlayer;
    }

   
    public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable int playerId) {
        try {
            return playerService.getPlayerById(playerId);
        } catch (PlayerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found with ID: " + playerId);
        }
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable int playerId, @RequestBody Player player) {
        try {
            Player updatedPlayer = playerService.updatePlayer(playerId, player);
            
           
            return updatedPlayer;
        } 
        catch (PlayerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found with ID: " + playerId);
        }
    }

    @DeleteMapping("/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlayer(@PathVariable int playerId) {
        try {
            playerService.deletePlayer(playerId);
        } catch (PlayerNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.OK, "Player not found with ID: " + playerId);
        }
    }
}
}
