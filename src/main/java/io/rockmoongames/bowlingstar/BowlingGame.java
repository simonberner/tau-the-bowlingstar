package io.rockmoongames.bowlingstar;

public class BowlingGame {

    private int[] rolls = new int[21];
    private int rollIndex = 0;

    /**
     * Rolls the bowling ball
     *
     * @param pins The total number of knocked down pins in a roll
     */
    public void roll(int pins) {
        rolls[rollIndex++] = pins;
    }

    /**
     * Calculates the total score of a game
     *
     * @return the total score of the game
     */
    public int score() {

        var frames = 0; // counts the frames
        var score = 0; // holds the total score of a game
        var rollIndex = 0; // move between each roll in the rolls[]

        // Loop over all 10 frames
        while (frames < 10) {

            // If spare, then score = 10 + knocked down pins of the next roll
            if (isSpare(rollIndex)) {
                score += 10 + rolls[rollIndex + 2];
                rollIndex += 2; // move roll index forward to the first roll of the next frame

                // If strike, then score = 10 + knocked down pins of the next two rolls
            } else if (isStrike(rollIndex)) {
                score += 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
                rollIndex += 1; // move roll index forward to the first roll of the next frame

                // Otherwise score = knocked down pins of the first and second roll of that frame
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2; // move roll index forward to the first roll of the next frame
            }
            frames++;
        }

        return score;

    }

    // Check if the player rolled a spare in a frame
    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    // Check if the player rolled a strike in a frame
    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

}