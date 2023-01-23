package stalls;

import attractions.Attraction;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    ArrayList<Attraction> visitedAttractions;
    Visitor visitor;
    Visitor youngvisitor;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
        visitor = new Visitor(20, 200, 30);
        youngvisitor = new Visitor(15, 200, 30);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void tobaccoStallHasMinAge18 (){
        assertEquals(true, tobaccoStall.isAllowedTo(visitor));
        assertEquals(false, tobaccoStall.isAllowedTo(youngvisitor));

    }


}
