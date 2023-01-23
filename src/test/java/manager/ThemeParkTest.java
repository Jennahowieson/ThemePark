package manager;

import attractions.Attraction;
import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    Dodgems dodgems;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    Visitor passingvisitor;
    Visitor shortvisitor;
    Visitor child;
    TobaccoStall tobacco;
    ThemePark themePark;
    ArrayList<Attraction> visitedAttractions;
    HashMap<String, Integer> allReviews;


    @Before
    public void setUp() {
        themePark = new ThemePark();
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        tobacco = new TobaccoStall("Forbidden", "jeff", ParkingSpot.B1);
        dodgems = new Dodgems("Bumper Cars", 5);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1);
        passingvisitor = new Visitor(20, 210, 30);
        shortvisitor = new Visitor(19, 120, 60);
        child = new Visitor(10, 100, 10);
        allReviews = new HashMap<String, Integer>();
    }

    @Test
    public void canAddToAllReviewed(){
        themePark.addToReviewedList(candyflossStall);
        assertEquals (1, themePark.getAllReviewed().size());
    }

    @Test
    public void canGetAllReviewed() {
        themePark.addToReviewedList(candyflossStall);
        themePark.addToReviewedList(dodgems);
        themePark.addToReviewedList(rollerCoaster);
        assertEquals ( 3, themePark.getAllReviewed().size());
    }

    @Test
    public void visitingIncreasesVisitCountByOne(){
        themePark.visit(passingvisitor, rollerCoaster);
        assertEquals(1, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitingIncreasesVisitorVisitedListByOne(){
        themePark.visit(passingvisitor, rollerCoaster);
        assertEquals(1, passingvisitor.getVisitedAttractions().size());
    }

    @Test
    public void themeParkCanReadAllReviews(){
        themePark.getAllReviews().put(rollerCoaster.getName(), rollerCoaster.getRating());
        themePark.getAllReviews().put(dodgems.getName(), dodgems.getRating());
        assertEquals(2, themePark.getAllReviews().size());
        String expected = "{Bumper Cars=5, Blue Ridge=10}";
        assertEquals(expected, themePark.getAllReviews().toString());
    }

    @Test
    public void canGiveVisitorsListOfSuitableAttractions(){
        themePark.addToReviewedList(candyflossStall);
        themePark.addToReviewedList(rollerCoaster);
        themePark.addToReviewedList(dodgems);
        themePark.addToReviewedList(tobacco);
        assertEquals ( 4, themePark.getAllAllowedFor(passingvisitor).size());
        assertEquals(3, themePark.getAllAllowedFor(shortvisitor).size());
        assertEquals(2, themePark.getAllAllowedFor(child).size());

    }
}
