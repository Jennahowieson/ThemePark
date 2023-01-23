package manager;

import attractions.Attraction;
import attractions.Dodgems;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.ParkingSpot;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    Dodgems dodgems;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    Visitor passingvisitor;
    Visitor failingvisitor;
    ThemePark themePark;
    ArrayList<Attraction> visitedAttractions;


    @Before
    public void setUp() {
        themePark = new ThemePark();
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        dodgems = new Dodgems("Bumper Cars", 5);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1);
        passingvisitor = new Visitor(16, 210, 30);
        failingvisitor = new Visitor(10, 120, 60);
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
}
