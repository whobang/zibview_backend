package com.view.zib.domain.address.service;

import com.view.zib.domain.api.kako.domain.Coordinate;
import com.view.zib.domain.post.entity.Post;

public interface RoadNameAddressCommandService {
    void updateCoordinate(Post post, Coordinate coordinate);
}
