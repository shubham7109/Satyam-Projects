package com.company;


import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class TikTacToe {

        //NOTE: This might be helpful
        //https://www.geeksforgeeks.org/multidimensional-arrays-in-java/

        //This is a 2-dimensional array used to represent the 2D board layout.
        private String[][] board = new String[3][3];



        public static void main(String[] args) {
            TikTacToe tikTacToe = new TikTacToe();
            tikTacToe.playGame();

        }

        /**
         * This method will simulate a TikTacToe game.
         * You do NOT need to edit this.
         */
        private void playGame(){
            createBoard();
            printBoard();

            while (true){
                if((!checkIfPlayerAWon() || !checkIfDraw())){
                    playerATurn();
                    printBoard();
                    checkIfPlayerAWon();

                }
                else
                {
                    break;
                }

                if((!checkIfPlayerBWon() || !checkIfDraw())){
                    playerBTurn();
                    printBoard();
                    checkIfPlayerBWon();

                }
                else
                {
                    break;
                }
                printBoard();
            }

            if(checkIfPlayerBWon()){
                System.out.println("Player B wins!");
            }
            else if(checkIfPlayerAWon()){
                System.out.println("Player A wins!");
            }
            else if(checkIfDraw()){
                System.out.println("This game is draw!");
            }


        }

        /**
         * Simulate turn from player A
         * Get the X,Y position from the player and then
         * update the X,Y in board[X][Y] as 'X'
         */
        private void playerATurn(){
            //TODO
            System.out.println(" Player A enter the column number of where you'd like to play from");
            Scanner in = new Scanner(System.in);
            int y = in.nextInt();
            System.out.println("Player A enter the row number of where you'd like to play from");
            int x = in.nextInt();
            if (isPositionEmpty(x,y)) {
                board [x][y] = "X" ;
            } else System.out.println(" Position not empty choose again");

        }

        /**
         * Simulate turn from player B
         * Get the X,Y position from the player and then
         * update the X,Y in board[X][Y] as 'O'
         */
        private void playerBTurn(){
            //TODO
            System.out.println("Player B enter the column number of where you'd like to play from");
            Scanner in = new Scanner(System.in);
            int y = in.nextInt();
            System.out.println("Player B enter the row number of where you'd like to play from");
            int x = in.nextInt();
            if (isPositionEmpty(x, y)) {
                board [x][y] = "O";
            } else System.out.println(" Position not empty choose again");
        }

        /**
         * Check if the position is empty.
         * This can be used to check before simulating a player turn.
         * If it returns false, handle it in the player simulate methods.
         * @param x X position of the array
         * @param y Y position of the array
         * @return True if empty, false if not.
         */
        private boolean isPositionEmpty(int x, int y){
            //TODO
            if (board [x][y] == "-") {
                return true;
            } else {
                return false;
            }
        }

        /**
         * Check all rows, columns and diagonals for X's
         * @return True if player A gets 3 X's in a row
         */
        private boolean checkIfPlayerAWon(){
            //TODO
            if (board [0][0]== "X" && board [1][0] == "X" && board [2][0] == "X" || board [0][1]== "X" && board [1][1]== "X" & board [2][1]== "X" || board [0][2]== "X" && board [1][2]== "X" && board [2][2]== "X" || board [0][0]== "X" && board [1][1]== "X" && board [2][2]== "X" || board [2][0]== "X" && board [1][1]== "X" && board [0][3]== "X"){
                return true;
            } else
            return false;
        }
        /**
         * Check all rows, columns and diagonals for O's
         * @return True if player A gets 3 O's in a row
         */
        private boolean checkIfPlayerBWon(){
            //TODO
            if (board [0][0]== "O" && board [1][0] == "O" && board [2][0] == "O" || board [0][1]== "O" && board [1][1]== "O" & board [2][1]== "O" || board [0][2]== "O" && board [1][2]== "O" && board [2][2]== "O" || board [0][0]== "O" && board [1][1]== "O" && board [2][2]== "O" || board [2][0]== "O" && board [1][1]== "O" && board [0][3]== "O") {
                return true;
            } else
            return false;
        }

        /**
         * Check if there is NO empty spot
         * AND checkIfPlayerAWon() and checkIfPlayerBWon() returns false.
         * @return True if the board is a draw, false if not.
         */
        private boolean checkIfDraw() {
            //TODO
            for (int i = 0; i < 2 ; i ++) {
                for (int j = 0; j < 2 ; j ++) {
                    if ( board [i][j] != "-") {
                        if (checkIfPlayerAWon() && checkIfPlayerBWon() == false) {
                            return  true;
                        }
                    }
                }
            }
            return false;
        }

        /**
         * Creates the board in the beginning of the game
         * This should be done by adding values to board[][]
         * Empty slots should be represented by '-'
         * [- - -]
         * [- - -]
         * [- - -]
         */
        private void createBoard(){
            //TODO
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++){
                    board [i][j] = " - " ;
                }
            }
        }

        /**
         * Print the current values of the board[][]
         * Example:
         * [X - O]
         * [- X O]
         * [O - X]
         */
        private void printBoard(){
            //TODO
            System.out.println(Arrays.deepToString(board));
        }
    }


