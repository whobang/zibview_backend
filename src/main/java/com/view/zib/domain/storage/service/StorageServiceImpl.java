package com.view.zib.domain.storage.service;

import com.view.zib.domain.image.entity.Image;
import com.view.zib.domain.storage.domain.Storage;
import com.view.zib.global.common.ClockHolder;
import com.view.zib.global.utils.NumberUtils;
import io.micrometer.common.util.StringUtils;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
public class StorageServiceImpl implements StorageService {
    private final String zibViewUrl;

    private final NumberUtils numberUtils;

    @Builder
    public StorageServiceImpl(@Value("${api.zibview.url}") String zibViewUrl, NumberUtils numberUtils) {
        this.zibViewUrl = zibViewUrl;
        this.numberUtils = numberUtils;
    }

    @Override
    public Storage store(MultipartFile file, ClockHolder clockHolder) {
        // TODO: save file to storage

        return Storage.builder()
                .originalFilename(file.getOriginalFilename())
                .fileSize(file.getSize())
                .mimeType(file.getContentType())
                .extension(getExtension(file))
                .path(createPath(clockHolder))
                .build();
    }

    @Override
    public String createPath(ClockHolder clockHolder) {
        LocalDateTime now = clockHolder.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        return year + numberUtils.zeroPadNumber(month, 2) + numberUtils.zeroPadNumber(day, 2);
    }


    @Override
    public String getExtension(String originalFilename) {
        if (StringUtils.isBlank(originalFilename) || !originalFilename.contains(".")) {
            return "";
        }

        return originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
    }

    @Override
    public String getExtension(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return "";
        }
        return getExtension(multipartFile.getOriginalFilename());
    }

    /**
     * 이미지 URL 생성
     * @param image
     * @return
     */
    @Override
    public String generateImageUrl(Image image) {
        return String.format("%s/%s/%s", zibViewUrl, image.getPath(), image.getStoredFilename());
    }
}
