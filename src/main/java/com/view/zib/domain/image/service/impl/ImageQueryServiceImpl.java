package com.view.zib.domain.image.service.impl;

import com.view.zib.domain.image.entity.Image;
import com.view.zib.domain.image.repository.ImageRepository;
import com.view.zib.domain.image.service.ImageQueryService;
import com.view.zib.global.exception.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ImageQueryServiceImpl implements ImageQueryService {

    private final ImageRepository imageRepository;

    @Override
    public Image getByUuid(String imageUuid) {
        return this.findByUuid(imageUuid)
                .orElseThrow(() -> new ResourceNotFoundException("Image", "uuid", imageUuid));
    }

    @Override
    public Optional<Image> findByUuid(String imageUuid) {
        return imageRepository.findByUuid(imageUuid);
    }

    @Override
    public Image getByStoredFilename(String storedFileName) {
        return imageRepository.findByStoredFilename(storedFileName)
                .orElseThrow(() -> new ResourceNotFoundException("Image", "storedFileName", storedFileName));
    }

    @Override
    public Optional<Image> findMostRecentImageByPostIdIn(Long postId) {
        return imageRepository.findMostRecentImageByPostId(postId);
    }

    @Transactional
    @Override
    public List<Image> findByUuidIn(List<String> imageUuids) {
        return imageRepository.findByUuidIn(imageUuids);
    }

    @Override
    public List<Image> findByPostIdInOrderByCreatedAtDesc(List<Long> postIds) {
        return imageRepository.findByPostIdInOrderByCreatedAtDesc(postIds);
    }

    @Override
    public List<Image> findByUserIdAndSubPostIdIsNullAndDeletedFalse(Long currentUserId) {
        return imageRepository.findByUserIdAndSubPostIdIsNullAndDeletedFalse(currentUserId);
    }
}
