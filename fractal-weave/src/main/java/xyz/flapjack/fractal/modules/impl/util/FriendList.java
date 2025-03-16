package xyz.flapjack.fractal.modules.impl.util;

import xyz.flapjack.Access;

import java.io.*;
import java.util.ArrayList;

public class FriendList {

    private static final String FILE_PATH = new File(Access.Utils.getLocalMinecraftPath(), "license/friend_list.txt").getPath();
    private final ArrayList<String> excludedPlayers;

    public FriendList() {
        this.excludedPlayers = new ArrayList<>();
        loadExcludedPlayersFromFile(); // Load excluded players from file
    }

    /**
     * Load excluded players from a text file.
     */
    public void loadExcludedPlayersFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return; // Return if the file does not exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String playerName = line.trim();
                if (!playerName.isEmpty()) {
                    this.excludedPlayers.add(playerName); // Add the player to the list
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save excluded players to a text file.
     */
    public void saveExcludedPlayersToFile() {
        File file = new File(FILE_PATH);
        try {
            // Ensure the folder exists
            file.getParentFile().mkdirs(); // Create the parent directories

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String player : excludedPlayers) {
                    writer.write(player);
                    writer.newLine(); // Write the player to the file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add a player to the excluded list.
     * @param playerName Player name
     */
    public void addExcludedPlayer(String playerName) {
        if (!excludedPlayers.contains(playerName)) {
            excludedPlayers.add(playerName); // If the player is not already in the list, add it
            saveExcludedPlayersToFile(); // Save file
        }
    }

    /**
     * Remove a player from the excluded list.
     * @param playerName Player name
     */
    public void removeExcludedPlayer(String playerName) {
        if (excludedPlayers.contains(playerName)) {
            excludedPlayers.remove(playerName); // Remove the player from the list
            saveExcludedPlayersToFile(); // Save file
        }
    }

    /**
     * Verify if the player is excluded.
     * @param playerName Player name
     * @return true if the player is excluded, false otherwise
     */
    public boolean isExcluded(String playerName) {
        return excludedPlayers.contains(playerName); // Check if the player is in the list
    }

    /**
     * Get the list of excluded players.
     * @return List of excluded players
     */
    public ArrayList<String> getExcludedPlayers() {
        return excludedPlayers;
    }
}