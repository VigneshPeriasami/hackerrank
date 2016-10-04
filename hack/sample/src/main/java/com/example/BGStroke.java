package com.example;

public class BGStroke {

  public static void main(String[] args) {
    args = new String[] { "GR.", "BG.", "..." };
    int colLeng = args[0].length();
    char[][] matrix = new char[args.length][colLeng];
    boolean[] missedARowSpot = new boolean[args.length];
    boolean[] missedColumnSpot = new boolean[colLeng];
    int[] rowStrokes = new int[args.length];
    int[] columnStrokes = new int[colLeng];

    for (int i = 0; i < args.length; i++) {
      char[] ch = args[i].toCharArray();
      missedARowSpot[i] = true;
      missedColumnSpot[i] = true;
      for (int j = 0; j < ch.length; j++) {
        matrix[i][j] = ch[j];
        if (ch[j] != 'R' && ch[j] != 'G') {
          missedARowSpot[i] = true;
        } else if (missedARowSpot[i]) {
          rowStrokes[i] = ++rowStrokes[i];
          missedARowSpot[i] = false;
        }

      }

      for (int j = 0; j < colLeng; j++) {
        if (ch[j] != 'B' && ch[j] != 'G') {
          missedColumnSpot[j] = true;
        } else if (missedColumnSpot[j]) {
          columnStrokes[j] = ++columnStrokes[j];
          missedColumnSpot[j] = false;
        }
      }
    }
    int redStroke = 0;
    int blueStroke = 0;
    for (int row : rowStrokes) {
      redStroke += row;
    }
    for (int b : columnStrokes) {
      System.out.println("--" + b);
      blueStroke += b;
    }
    System.out.println(redStroke + blueStroke);
    System.out.println(blueStroke);
  }
}
