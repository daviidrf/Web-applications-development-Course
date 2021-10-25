package cat.proven.teamplayer.model;

import cat.proven.exceptions.DuplicateException;
import cat.proven.exceptions.ParameterNull;
import java.util.List;

/**
 *
 * @author David
 */
public class TeamPlayerModel {

    /**
     *
     * @return a list of all teams or an empty list if none is found.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
    public List<Team> findAllTeams() throws ParameterNull{
        //TODO
        return null;
    }

    /**
     *
     * @param id is the id of the team to search.
     * @return a team with the given id.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
    public Team findTeamByID(long id) throws ParameterNull{
        //TODO
        return null;
    }

    /**
     *
     * @param name is the name of the team to search.
     * @return a team with the given name.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
    public Team findTeamByName(String name) throws ParameterNull{
        //TODO
        return null;
    }

    /**
     *
     * @param Category is the category of the teams to search.
     * @return a list of all teams that belongs to that category, an empty list
     * if not found.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
    public List<Team> findTeamsByCategory(String Category) throws ParameterNull{
        //TODO
        return null;
    }

    /**
     *
     * @param id is the id of the player to search.
     * @return a player with the given id.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
    public Player findPlayerById(long id) throws ParameterNull{
        //TODO
        return null;
    }

    /**
     *
     * @param fullname is the full name of the player to search.
     * @return a list of players with the given full name.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
    public List<Player> findPlayerByFullName(String fullname) throws ParameterNull{
        //TODO
        return null;
    }

    /**
     *
     * @param team is the team of the players to search.
     * @return a list of players that belongs to the given team.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
    public List<Player> findPlayersByTeam(Team team) throws ParameterNull{
        //TODO
        return null;
    }

    /**
     * Adds a team to the data source.
     *
     * It prevents null objects, teams with null name and duplicates.
     *
     * @param team the team to add.
     * @return 1 if its successfully added, 0 otherwise.
     * @throws cat.proven.exceptions.DuplicateException if team name already is
     * in the data source.
     */
    public int addTeam(Team team) throws DuplicateException {
        //TODO
        return 0;
    }

    /**
     *
     * @param team is the team to modify.
     * @return 1 if its successfully modified or 0 otherwise.
     */
    public int modifyTeam(Team team) {
        //TODO
        return 0;
    }

    /**
     *
     * @param team is the team to remove.
     * @return 1 if its successfully removed or 0 otherwise.
     */
    public int removeTeam(Team team) {
        //TODO
        return 0;
    }

    /**
     *
     * @param player is the player to add.
     * @return 1 if its successfully added, 0 otherwise.
     * @throws cat.proven.exceptions.DuplicateException if team name already is
     * in the data source.
     */
    public int addPlayer(Player player) throws DuplicateException{
        //TODO
        return 0;
    }
    
    /**
     * 
     * @param player is the player to modify.
     * @return 1 if its successfully modified or 0 otherwise.
     */
    public int modifyPlayer(Player player) {
        //TODO
        return 0;
    }
    
    /**
     * 
     * @param player is the player to remove.
     * @return 1 if its successfully removed or 0 otherwise.
     */
    public int removePlayer(Player player){
        //TODO
        return 0;
    }
    
    /**
     * A player cannot be add to more than one team.
     * 
     * @param team is the team to join the @player introduced.
     * @param player is the player that will join to the @team introduced.
     * @return 1 if the player is enrolled in the team or 0 othewise.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
     public int enrolPlayerToTeam(Team team,Player player) throws ParameterNull{
        //TODO
        return 0;
    }
    /**
     * 
     * @param team is the team to unenrol the @player introduced.
     * @param player is the player that will unenrol the @team introduced.
     * @return 1 if the player is unenrolled of the team or 0 othewise.
     * @throws cat.proven.exceptions.ParameterNull in case of error.
     */
     public int unenrolPlayerToTeam(Team team,Player player) throws ParameterNull{
        //TODO
        return 0;
    }
}
