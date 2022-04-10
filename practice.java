package practice;

// 本プログラムで継承しているクラス
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice {
  public static void main(String[] args) {

// 変数に出力したいタイトル、ルールを格納
    String title = "Hit&Blow"
    String rule = "隠された3つの数字を当ててください\n"
                  + "1つの文字は1から6の間です\n"
                  + "3つの数字は重複しません\n"
                  + "入力した数字の、\n"
                  + "位置と数字が当たってたらHit、\n"
                  + "数字だけあってたらBlowとカウントします。\n"
                  + "隠された3つの数字とその場所を当てたら\n"
                  + "終了です\n\n";

// 配列を宣言、3つの箱を用意する
    int[] answer = new int[3];
    int[] input = new int[3];

    int hit = 0,blow = 0, count = 0;

// タイトルとルールを出力
    BufferedReader br 
    = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(title);
    System.out.println(rule);

// 繰り返し処理でランダムな答えを作成
    for (int i = 0; i < answer.length; i++) {
      boolean flag = false;
      answer[i] = (int) (Math.random() * 6 + 1);
      do {
          flag = false;
          for (int j = i - 1; j >= 0; j--) {
              if (answer[i] == answer[j]) {
                  flag = true;
                  answer[i] = (int) (Math.random() * 6 + 1);
              }
          }
        } while (flag == true);
    }

    while (true) {
      count++;
      System.out.println("*** "+count + "回目 ***");

// 入力させる処理、繰り返し
    for (int i = 0; i < answer.length; i++) {
        System.out.print( (i + 1) + "個目 : ");
        try {
            input[i] = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.err.println("数値を入力してください");              
            i--;
        } catch (IOException e) {
            System.err.println("もう一度入力してください");
            i--;
        }
    }

// 答え合わせの処理
// 数字と場所が合っていればHitに加算、誤っていたらBlowに加算
    hit = 0;
    blow = 0;
    for (int i = 0; i < answer.length; i++) {
        for (int j = 0; j < answer.length; j++) {
            if (i == j && input[i] == answer[j]) {
                hit++;
            } else if (input[i] == answer[j]) {
                blow++;
            }
        }
    }

// 3Hitか否かの判断を処理
    System.out.println("ヒット" + hit + " ブロー" + blow);
    if (hit == 3) {
        System.out.println("お見事！");
        break;
    }else{
        System.out.println("残念！");
      }
    }
  }
}
