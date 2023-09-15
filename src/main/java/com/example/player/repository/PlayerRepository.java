// Write your code here

import com.example.player.model.Player;
import java.util.List;

public interface PlayerRepository {
    List<Player> getAllPlayers();
    Player getPlayerById(int playerId);
    Player addPlayer(Player player);
    Player updatePlayer(int playerId, Player player);
    void deletePlayer(int playerId);
}
