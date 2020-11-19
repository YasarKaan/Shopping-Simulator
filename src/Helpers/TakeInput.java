package Helpers;

import Factory.*;
import Factory.Products;
import Warehouse.Ingredients;
import Warehouse.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {

    public int getInput() {
        try {
            System.out.print( "Enter :" );
            int amount;
            Scanner scanner = new Scanner( System.in );
            while (true) {
                amount = scanner.nextInt();
                break;
            }

            return amount;
        } catch (InputMismatchException e) {
            System.out.println( "Please write a number" );
            return getInput();
        }
    }

    public Ingredients getIngredients(int input, Warehouse warehouse) {
        while (true) {
            try {
                if (input == 1) {
                    if (warehouse.cacaoStorageTank.getSize() >= 1000) {
                        Cacao cacao = new Cacao( 1000 );
                        return cacao;
                    } else {
                        Cacao cacao = new Cacao( warehouse.cacaoStorageTank.getSize() );
                        return cacao;
                    }
                } else if (input == 2) {
                    if (warehouse.creamStorageTank.getSize() >= 1000) {
                        Cream cream = new Cream( 1000 );
                        return cream;
                    } else {
                        Cream cream = new Cream( warehouse.creamStorageTank.getSize() );
                        return cream;
                    }
                } else if (input == 3) {
                    if (warehouse.milkStorageTank.getSize() >= 1000) {
                        Milk milk = new Milk( 1000 );
                        return milk;
                    } else {
                        Milk milk = new Milk( warehouse.milkStorageTank.getSize() );
                        return milk;
                    }
                } else if (input == 4) {
                    if (warehouse.yeastStorageTank.getSize() >= 1000) {
                        Yeast yeast = new Yeast( 1000 );
                        return yeast;
                    } else {
                        Yeast yeast = new Yeast( warehouse.yeastStorageTank.getSize() );
                        return yeast;
                    }
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println( e.getMessage() );
            }
        }
    }

    public Products getProducts(int input, Factory factory) {
        while (true) {
            try {
                if (input == 1) {
                    BoxedMilk boxedMilk = new BoxedMilk();
                    return boxedMilk;
                } else if (input == 2) {
                    Chocolate chocolate = new Chocolate();
                    return chocolate;
                } else if (input == 3) {
                    Yogurt yogurt = new Yogurt();
                    return yogurt;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println( e.getMessage() );
            }
        }

    }
}
