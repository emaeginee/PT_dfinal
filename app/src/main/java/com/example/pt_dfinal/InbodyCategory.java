package com.example.pt_dfinal;

import java.util.Scanner;

public class InbodyCategory {
    public static void main(String[] args) {

        Scanner POWERSCAN = new Scanner(System.in);
        String sex;
        float height; // 키
        float weight; // 몸무게
        float BMI1; // BMI
        float BMI;
        float skeletal_muscle_mass1; // 골격근
        float fat;
        float muscle; // 골격근률
        float bodyfat1; // 체지방률
        float bodyfat;

        System.out.println("성별? ");
        sex = POWERSCAN.next();

        System.out.println("키는? ");
        height = POWERSCAN.nextFloat();

        System.out.println("몸무게는? ");
        weight = POWERSCAN.nextFloat();

        // System.out.println("BMI눈? ");

        System.out.println("골격근량은? ");
        skeletal_muscle_mass1 = POWERSCAN.nextFloat();

        //골격근률
        float skelatal_muscle_mass=(float) (skeletal_muscle_mass1 / (float) weight)*100;
        muscle = Math.round(skelatal_muscle_mass * 10 / 10.0);


        System.out.println("체지방량은? ");
        fat = POWERSCAN.nextFloat();

        //체지방률
        bodyfat1 = (float) (fat / (float) weight)*100;
        //소수점 한자리
        bodyfat = Math.round(bodyfat1 * 10 / 10.0);
        System.out.println("골격근률:"+muscle);
        System.out.println("체지방률:"+bodyfat);

        BMI1 = (float) ((float) weight / (height * 0.01 * height * 0.01));
        BMI = Math.round(BMI1 * 10 / 10.0);
        System.out.println("BMI:"+BMI);


        if ((sex.equals("여성"))) {
            if ((18.5 <= BMI) && (BMI <= 23.0)) {

                if ((26.5 <= muscle) && (0.0 <= bodyfat) &&(bodyfat <= 34.9)) {
                    System.out.print("표준체중 강인형");

                } else if ((0.0 <= muscle) && (bodyfat >= 35.0)) {
                    System.out.println("표준체중 비만형");

                } else if ((26.4>= muscle) && (0.0 <= bodyfat) &&(bodyfat <= 34.9)) {
                    System.out.print("표준체중 허약형");

                } else
                    System.out.println("입력 오류.");

            } else if ((18.5 > BMI)) {
                if ((26.4 >= muscle) && (0.0 <= bodyfat)&& (bodyfat <= 34.9)) {
                    System.out.print("저체중 허약형");

                } else if ((26.5 <=muscle) && (0.0 <= bodyfat) && (bodyfat <= 34.9)) {
                    System.out.println("저체중 강인형");

                } else
                    System.out.println("입력 오류.");
            } else if ((23.0 < BMI)) {
                if ((26.4 >= muscle) && (0.0 <= bodyfat) &&(bodyfat <= 34.9)) {
                    System.out.print("과체중 허약형");

                } else if ((26.5 <= muscle) && (0.0 <= bodyfat) && (bodyfat <= 34.9)) {
                    System.out.println("과체중 강인형");

                } else if ((0.0 <= muscle) && (bodyfat >= 35.0)) {
                    System.out.print("과체중 비만형");

                } else
                    System.out.println("입력 오류.");
            } else {
                System.out.println("입력 오류.");
            }
        }else if((sex.equals("남성"))) {
            if ((18.5 <= BMI) && (BMI <= 23.0)) {

                if ((32.0 <= muscle) && (0.0 <= bodyfat) &&(bodyfat <= 24.9)) {
                    System.out.print("표준체중 강인형");

                } else if ((0.0 <= muscle) && (bodyfat >= 25.0)) {
                    System.out.println("표준체중 비만형");

                } else if ((31.9>= muscle) && (0.0 <= bodyfat) &&(bodyfat <= 24.9)) {
                    System.out.print("표준체중 허약형");

                } else
                    System.out.println("입력 오류.");

            } else if ((18.5 > BMI)) {
                if ((31.9 >= muscle) && (0.0 <= bodyfat)&& (bodyfat <= 24.9)) {
                    System.out.print("저체중 허약형");

                } else if ((32.0 <=muscle) && (0.0 <= bodyfat) && (bodyfat <= 24.9)) {
                    System.out.println("저체중 강인형");

                } else
                    System.out.println("입력 오류.");
            } else if ((23.0 < BMI)) {
                if ((31.9>= muscle) && (0.0 <= bodyfat) &&(bodyfat <= 24.9)) {
                    System.out.print("과체중 허약형");

                } else if ((32.0 <= muscle) && (0.0 <= bodyfat) && (bodyfat <= 24.9)) {
                    System.out.println("과체중 강인형");

                } else if ((0.0 <= muscle) && (bodyfat >= 25.0)) {
                    System.out.print("과체중 비만형");

                } else
                    System.out.println("입력 오류.");
            } else {
                System.out.println("입력 오류.");
            }


        }
    }

} // class 끝