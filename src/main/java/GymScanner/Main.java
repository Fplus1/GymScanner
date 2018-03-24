package GymScanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args)  throws SQLException{
        List<Gym> yellowGymList = retrieveOpenGyms(Team.VALOR);
        SpringApplication.run(Main.class, args);

        for(Gym gym : yellowGymList){
            print(gym.getName());
        }
    }


    public static List<Gym> retrieveOpenGyms(Team team) throws SQLException{
        List<Gym> openGymList = new ArrayList<Gym>();
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://35.197.87.254:3306/pokemon", "root", "CaNd1e");
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT gym.gym_id, gym.team_id, gym.slots_available, gym.park, gymdetails.name, gymdetails.url " +
                    "FROM gym LEFT JOIN gymdetails ON gym.gym_id = gymdetails.gym_id " +
                    "WHERE team_id = "+Team.getTeamId(team)+" AND slots_available > 0;");
            while(rs.next()) {
                Gym gym = new Gym(
                        rs.getString("gym_id"),
                        rs.getString("name"),
                        Team.getTeam(rs.getByte("team_id")),
                        rs.getByte("slots_available"),
                        rs.getBoolean("park"),
                        rs.getString("url"));
                openGymList.add(gym);
            }

        }catch (Exception e){
            print(e);
        }finally {
            if(conn != null) {
                conn.close();
            }
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
        }
        return openGymList;
    }


    public static void print(Object o){
        System.out.println(o);
    }
}