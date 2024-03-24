package londonbusticket;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    // Number of seats , busNo

    public String busNo;

    public List<String> seats = new ArrayList<>();


    public Bus (String busNo){  // parameterised constructor
        this.busNo = busNo;
        for (int i = 1; i < 33; i++) {
            this.seats.add(i + "");
        }
    }

}
