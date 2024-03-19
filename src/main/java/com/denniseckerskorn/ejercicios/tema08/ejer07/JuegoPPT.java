package com.denniseckerskorn.ejercicios.tema08.ejer07;

import java.util.Random;

public class JuegoPPT {
    public enum PPT {
        PIEDRA,
        PAPEL,
        TIJERA
    }

    private final int rounds;
    private int roundsPlayed;
    private int scorePlayer;
    private int scoreCPU;
    private int scoreEven;
    private Random rnd;

    public JuegoPPT(int rounds) {
        this.rounds = rounds;
        roundsPlayed = 0;
        scorePlayer = 0;
        scoreCPU = 0;
        scoreEven = 0;
        rnd = new Random();
    }

    public void resetGame() {
        scorePlayer = 0;
        scoreCPU = 0;
        scoreEven = 0;
    }

    public int getRounds() {
        return rounds;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public int getScoreCPU() {
        return scoreCPU;
    }

    public int getScoreEven() {
        return scoreEven;
    }

    public PPT playRound(PPT playerChoice) {
        PPT cpuChoice = generateCPUChoice();

        PPT roundWinner = determineWinner(playerChoice, cpuChoice);

        if(roundWinner == playerChoice) {
            scorePlayer++;
        } else if (roundWinner == cpuChoice) {
            scoreCPU++;
        } else {
            scoreEven++;
        }

        incrementRoundsPlayed();

        return roundWinner;
    }

    public void incrementRoundsPlayed() {
        roundsPlayed++;
    }
    private PPT determineWinner(PPT playerChoice, PPT cpuChoice) {
        if(playerChoice == cpuChoice) {
            return null;
        }

        switch(playerChoice) {
            case PIEDRA:
                if(cpuChoice == PPT.TIJERA) {
                    return playerChoice; //Gana Piedra
                } else {
                    return cpuChoice;
                }
            case PAPEL:
                if(cpuChoice == PPT.PIEDRA) {
                    return playerChoice; //Gana Papel
                } else {
                    return cpuChoice;
                }
            case TIJERA:
                if(cpuChoice == PPT.PAPEL) {
                    return playerChoice; //Gana Tijera
                } else {
                    return cpuChoice;
                }
            default:
                return null;
        }
    }

    private PPT generateCPUChoice() {
        int random = rnd.nextInt(3);
        return PPT.values()[random];
    }



}
