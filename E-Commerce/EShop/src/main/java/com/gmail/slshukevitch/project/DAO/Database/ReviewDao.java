package com.gmail.slshukevitch.project.DAO.Database;

import com.gmail.slshukevitch.project.DAO.Model.Review;


import java.util.List;

public interface ReviewDao {

    Review readReview(int id);
    Review createReview(Review review);
    List<Review> readAllReview();
}
