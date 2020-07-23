package com.company;
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

            while (true){
                if((!checkIfPlayerBWon() && !checkIfDraw())){
                    playerATurn();
                    printBoard();
                }
                else
                {
                    break;
                }

                if((!checkIfPlayerAWon()  && !checkIfDraw())){
                    playerBTurn();
                    printBoard();
                }
                else
                {
                    break;
                }

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
            System.out.print("Player A enter the column number of where you'd like to play from : ");
            Scanner in = new Scanner(System.in);
            int y = in.nextInt();
            System.out.print("Player A enter the row number of where you'd like to play from : ");
            int x = in.nextInt();
            if (isPositionEmpty(x, y)) {
                board[x][y] = " X ";
            } else {
                System.out.println("Position has been taken, Try again");
                playerATurn();
            }

        }

        /**
         * Simulate turn from player B
         * Get the X,Y position from the player and then
         * update the X,Y in board[X][Y] as 'O'
         */
        private void playerBTurn(){
            //TODO
            System.out.print("Player B enter the column number of where you'd like to play from : ");
            Scanner in = new Scanner(System.in);
            int y = in.nextInt();
            System.out.print("Player B enter the row number of where you'd like to play from : ");
            int x = in.nextInt();
            if (isPositionEmpty(x, y)) {
                board [x][y] = " O ";
            }   else {
                System.out.println("Position has been taken, Try again");
                playerBTurn();
            }
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
            return board[x][y].equals(" - ");
        }

        /**
         * Check all rows, columns and diagonals for X's
         * @return True if player A gets 3 X's in a row
         */
        private boolean checkIfPlayerAWon() {
              for (int i = 0; i < 3; i++) {

                      if (board[i][0].equals(" X ") &&
                         board[i][1].equals(" X ") &&      //for checking rows
                         board[i][2].equals(" X ")) {
                          return true;
                      } else if
                          (board[0][i].equals(" X ") &&
                          board[1][i].equals(" X ") &&     //for checking columns
                          board[2][i].equals(" X ")) {
                              return true;
                      } else if
                          (board[0][0].equals(" X ") &&
                          board[1][1].equals(" X ") &&     // Diagonals
                          board[2][2].equals(" X ")) {
                              return true;
                      }else if
                          (board[0][2].equals(" X ") &&
                          board[1][1].equals(" X ") &&
                          board[2][0].equals(" X "))
                        return true;
              } return false;

        }
        /**
         * Check all rows, columns and diagonals for O's
         * @return True if player A gets 3 O's in a row
         */
        private boolean checkIfPlayerBWon() {
            //TODO
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][0].equals(" O ") &&
                        board[i][1].equals(" O ") &&      //for checking rows
                        board[i][2].equals(" O ")) {
                        return true;
                    } else if
                    (board[0][j].equals(" O ") &&
                    board[1][j].equals(" O ") &&     //for checking columns
                    board[2][j].equals(" O ")) {
                        return true;
                } else if
                 (board[0][0].equals(" O ") &&
                 board[1][1].equals(" O ") &&                      // Diagonals
                 board[2][2].equals(" O ")) {
                        return true;
                 }else if
                  (board[0][2].equals(" O ") &&
                  board[1][1].equals(" O ") &&
                  board[2][0].equals(" O "))
                  return true;
                }
            } return false;
        }


        /**         board[2][1].equals(" O ");
         * Check if there is NO empty spot
         * AND checkIfPlayerAWon() and checkIfPlayerBWon() returns false.
         * @return True if the board is a draw, false if not.
         */
        private boolean checkIfDraw() {
            //TODO
            for (int i = 0; i < 3 ; i ++) {
                for (int j = 0; j < 3 ; j ++) {
                    if (board[i][j].equals(" - ")) {
                        return false;
                    }
                }
            }
            return !checkIfPlayerAWon() && !checkIfPlayerBWon();

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
                    System.out.print(board[i][j]);
                }
                System.out.println();
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
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }


