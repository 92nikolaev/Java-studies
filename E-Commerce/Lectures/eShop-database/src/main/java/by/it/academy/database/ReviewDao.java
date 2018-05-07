package by.it.academy.database;

import by.it.academy.model.Review;

import java.util.List;

public interface ReviewDao {

    Review readReview(int id);
    Review createReview(Review review);
    List<Review> readAllReview();
}
