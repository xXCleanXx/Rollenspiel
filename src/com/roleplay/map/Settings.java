package com.roleplay.map;

import com.roleplay.characters.Character;
import com.roleplay.characters.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Settings {
    private Difficulty difficulty = Difficulty.MEDIUM;
    private final List<Character> players = new ArrayList<>();
    private int playerCount = 3;
    private final List<String> artefactBlacklist = new ArrayList<>();

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        if (playerCount < 3 || playerCount > 6) throw new IllegalArgumentException("Player count cannot be less than 3 and greater than 6!");

        this.playerCount = playerCount;
    }

    public List<Character> getPlayers() {
        return players;
    }

    public void addPlayer(Character player) {
        players.add(player);
    }

    public void removePlayer(Character player) {
        players.remove(player);
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean containsArtefactInBlacklist(String artefact) {
        return artefactBlacklist.contains(artefact);
    }

    public void addArtefactToBlacklist(String artefact) {
        if (!artefactBlacklist.contains(artefact)) artefactBlacklist.add(artefact);
    }

    public void removeArtefactFromBlacklist(String artefact) {
        artefactBlacklist.remove(artefact);
    }
}