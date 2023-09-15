import java.util.List;

import com.example.player.model.Player;

 interface PlayerService {
    List<Player> getAllPlayers();
    Player getPlayerById(int playerId);
    Player addPlayer(Player player);
    Player updatePlayer(int playerId, Player player);
    void deletePlayer(int playerId);
}