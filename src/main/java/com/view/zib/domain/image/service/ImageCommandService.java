package com.view.zib.domain.image.service;

import com.view.zib.domain.image.controller.request.SaveImageRequest;
import com.view.zib.domain.image.entity.Image;
import com.view.zib.domain.storage.domain.Storage;

import java.util.List;
import java.util.Map;

public interface ImageCommandService {
    void saveImage(SaveImageRequest saveImageRequest, Map<String, Storage> storageByUuid);

    void deleteImage(String imageUuid);

    void delete(Image image);

    List<Image> preventAbusing(List<SaveImageRequest.Image> imagesToSave, List<Image> unassignedImages);
}
