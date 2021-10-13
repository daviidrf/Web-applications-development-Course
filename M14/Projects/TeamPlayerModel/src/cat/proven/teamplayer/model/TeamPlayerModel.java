package cat.proven.teamplayer.model;
import cat.proven.exceptions.DuplicateException;
/**
 *
 * @author David
 */
public class TeamPlayerModel {
    
    /**
     * Adds a team to the data source.
     * 
     * It prevents null objects, teams with null name and duplicates.
     * 
     * @param team the team to add.
     * @return 1 if its successfully added, 0 otherwise.
     * @throws cat.proven.exceptions.DuplicateException if team name 
     * already is in the data source.
     */
    public int addTeam(Team team)throws DuplicateException{
        //TODO
        return 0;
    }
    
}
