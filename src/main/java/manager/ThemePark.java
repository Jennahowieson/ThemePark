package manager;

import attractions.Attraction;
import behaviours.IReviewed;
import org.w3c.dom.Attr;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark implements IReviewed {
    private ArrayList<IReviewed> allReviewed;
    private IReviewed iReviewed;

    public ThemePark() {
        this.allReviewed = new ArrayList<IReviewed>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return allReviewed;
    }

    public void setAllReviewed(ArrayList<IReviewed> allReviewed) {
        this.allReviewed = allReviewed;
    }

    public int getRating() {
        return 0;
    }

    public String getName() {
        return null;
    }

    public void addToReviewedList(IReviewed iReviewed){
        allReviewed.add(iReviewed);
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.markAsVisited(attraction);
        attraction.increaseVisitCountBy1();
    }
}
