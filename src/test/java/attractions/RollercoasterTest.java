package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    ArrayList<Attraction> visitedAttractions;
    Visitor passingvisitor;
    Visitor failingvisitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        passingvisitor = new Visitor(16, 210, 30);
        failingvisitor = new Visitor(10, 120, 60);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorMustBe12And185ToRide (){
        assertEquals(true, rollerCoaster.isAllowedTo(passingvisitor));
        assertEquals(false, rollerCoaster.isAllowedTo(failingvisitor));
    }
    @Test
    public void rollercoasterStandardPriceIs840(){
        assertEquals(8.40, rollerCoaster.priceFor(failingvisitor),0.0);
    }

    @Test
    public void rollercoasterExtraTallPriceIs1680(){
        assertEquals(16.80, rollerCoaster.priceFor(passingvisitor),0.0);
    }

}
