package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor;
    Visitor oldvisitor;
    ArrayList<Attraction> visitedAttractions;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
        visitor = new Visitor(12, 200, 30);
        oldvisitor = new Visitor(18, 200, 30);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void playgroundHasMaxAge15 (){
        assertEquals(true, playground.isAllowedTo(visitor));
        assertEquals(false, playground.isAllowedTo(oldvisitor));
    }
}
