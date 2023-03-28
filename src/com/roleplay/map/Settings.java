package com.roleplay.map;

import com.roleplay.characters.Character;
import com.roleplay.characters.enums.Difficulty;
import com.roleplay.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    private Difficulty difficulty = Difficulty.MEDIUM;
    private final List<Character> players = new ArrayList<>();
    private final List<String> playerNames = new ArrayList<>();
    private int playerCount = 3;
    private final List<Item> itemWhiteList = new ArrayList<>();

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        if (playerCount < 3 || playerCount > 6)
            throw new IllegalArgumentException("Player count cannot be less than 3 and greater than 6!");

        this.playerCount = playerCount;
    }

    public List<Character> getPlayers() {
        return players;
    }    public List<String> getPlayerNames() {
        return playerNames;
    }

    public boolean playerNamesContainsIgnoreCase(String playerName){
        for (String name : getPlayerNames())
            if(name.equalsIgnoreCase(playerName)){
                return true;
            }
        return false;
    }

    public void addPlayer(Character player) {
        players.add(player);
        playerNames.add(player.getProperties().getDisplayName());
    }

    public void removePlayer(Character player) {
        players.remove(player);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void addItemToWhiteList(Item item) {
        if (!itemWhiteList.contains(item)) itemWhiteList.add(item);
    }

    public List<Item> getItemWhiteList(){
        return this.itemWhiteList;
    }
}