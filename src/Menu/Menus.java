package Menu;

import DistributationCenter.DistributationCenter;
import Factory.Factory;
import Warehouse.Warehouse;

public class Menus {
    public void firstList(){
        System.out.println("Press 1 for Buy Ingredients");
        System.out.println("Press 2 for Produce Products");
        System.out.println("Press 3 for Sell Products");
        System.out.println("Press 4 for See total Ingredients and Products");
        System.out.println("Press 5 for Transportation");
        System.out.println("Press 0 for Exit");
        System.out.println(" ");
        System.out.println(" ");
    }

    public void secondList(){
        System.out.println("Press 1 for Cacao");
        System.out.println("Press 2 for Cream");
        System.out.println("Press 3 for Milk");
        System.out.println("Press 4 for Yeast");
        System.out.println(" ");
        System.out.println(" ");
    }
    public void  thirdList(){
        System.out.println("Press 1 for produce Boxed Milk");
        System.out.println("Press 2 for produce Chocolate");
        System.out.println("Press 3 for produce Yogurt");
        System.out.println(" ");
        System.out.println(" ");
    }
    public void fourthList(){
        System.out.println("Press 1 for transfer Ingredients to Factory");
        System.out.println("Press 2 for transfer Products to Distribution Center");
        System.out.println("Press 3 for transfer Containers");
        System.out.println(" ");
        System.out.println(" ");
    }
    public void trasferList(){
        System.out.println("Press 1 for transfer Open Top Container to Warehouse");
        System.out.println("Press 2 for transfer Tank Container to Warehouse");
        System.out.println("Press 3 for transfer Dry Storage Container to Factory");
        System.out.println(" ");
        System.out.println(" ");
    }
    public void containerList(){
        System.out.println("Press 1 for Open Top Container");
        System.out.println( "Press 2 for Tank Container" );
        System.out.println( "Press 3 for Dry Storage Container" );

    }
}