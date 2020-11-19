package Transportation;


import Exceptions.ParkingZoneIsEmptyException;
import Storage.IContainer;
import java.util.ArrayList;


public class ParkingZone {
    public ArrayList<IContainer> parkingContainer = new ArrayList<>();
    public boolean isHave(IContainer container) {
        try {
            if (parkingContainer.size() == 0) {
                throw new ParkingZoneIsEmptyException();
            } else {
                for (IContainer cont : parkingContainer) {
                    if (cont.getClass().getSimpleName().equals( container.getClass().getSimpleName() )) {
                        return true;
                    }
                }
            }
            return false;
        }catch (ParkingZoneIsEmptyException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public void addContainer(IContainer container){
        parkingContainer.add(container);
    }
    public void removeContainer(IContainer container){
        parkingContainer.remove(container);
    }
    public String toString(){
        if(parkingContainer.size()==0){
            return "Parking zone is Empty";
        }
        else{
            String all="";
            for (IContainer container:parkingContainer) {
                all=all+" "+container.getName()+"\n";

            }
            return all;
        }
    }
}