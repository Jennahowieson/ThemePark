package manager;

import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.*;

public class ThemePark {
    private ArrayList<IReviewed> allReviewed;
    private IReviewed iReviewed;
    private HashMap<String, Integer> allReviews;

    public ThemePark() {
        this.allReviewed = new ArrayList<IReviewed>();
        this.allReviews = new HashMap<String, Integer>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return allReviewed;
    }

    public HashMap<String, Integer> getAllReviews() {
        return allReviews;
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

    public void addToReviewedList(IReviewed iReviewed) {
        allReviewed.add(iReviewed);
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.markAsVisited(attraction);
        attraction.increaseVisitCountBy1();
    }


    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> canGoOn = new ArrayList<IReviewed>();
        for (IReviewed i : getAllReviewed()) {
            if (i.isAllowedTo(visitor) == true) {
                canGoOn.add(i);
            }
        }
        return canGoOn;
    }
}