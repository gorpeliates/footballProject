package com.league.footballProject.functionality;

import com.league.footballProject.commons.Player;
import com.league.footballProject.services.PlayerService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
public class DBIntegrator implements CommandLineRunner {
    final static String FILE = "..\\data\\players_data.csv";

    private PlayerService playerService;

    @Override
    public void run(String... args) throws Exception {
        var players = DBIntegrator.CSVToPlayers();

        players.forEach(player -> {
            playerService.addPlayer(player);
        });
    }

    public DBIntegrator(PlayerService playerService) {
        this.playerService = playerService;
    }

    /**
     * convert the csv file to a list of players
     * @return a list of players to be added to the database
     *
     */
    private static List<Player> CSVToPlayers(){

        List<Player> players = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(DBIntegrator.FILE));){
            var rows = reader.readAll();
            var headers = Stream.of(rows.getFirst()).map(String::trim).toList();

            System.out.println(headers);
            int pos = headers.indexOf("Pos");
            int nation = headers.indexOf("Nation");
            int name = headers.indexOf("Player");
            int age = headers.indexOf("Age");
            int minutes = headers.indexOf("Min");
            int starts = headers.indexOf("Starts");
            int gls = headers.indexOf("Gls");
            int asst = headers.indexOf("Ast");



            for (String[] row : rows) {

                try{
                    var age_data = Integer.parseInt(row[age].trim());
                    var pos_data = row[pos].trim();
                    var nation_data = row[nation].trim();
                    var name_data = row[name].trim();
                    var starts_data = Integer.parseInt(row[starts].trim());
                    var gls_data = Integer.parseInt(row[gls].trim());
                    var asst_data = Integer.parseInt(row[asst].trim());
                    var minutes_data = Double.parseDouble(row[minutes].trim().replace(".", ","));


                    Player player = new Player();
                    player.setAge(age_data);
                    player.setAssists(asst_data);
                    player.setGoals(gls_data);
                    player.setName(name_data);
                    player.setStarts(starts_data);
                    player.setPosition(pos_data);
                    player.setNationality(nation_data);
                    player.setMinutes(minutes_data);
                    System.out.println(player);

                    players.add(player);

                }
                catch (Exception e){
                    continue;
                }
            }
        }
        catch (IOException e){
            System.out.println(e + " Error while reading file " + DBIntegrator.FILE);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        System.out.println(players);
        return players;


    }



}

