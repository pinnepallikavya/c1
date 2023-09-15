import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRowMapper implements RowMapper<Player> {
    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        int playerId = rs.getInt("playerId");
        String playerName = rs.getString("playerName");
        int jerseyNumber = rs.getInt("jerseyNumber");
        String role = rs.getString("role");

        return new Player(playerId, playerName, jerseyNumber, role);
    }
}
