package com.view.zib.domain.address.service;

import com.view.zib.domain.address.entity.Jibun;
import com.view.zib.domain.address.repository.dto.JibunSearchResultDTO;

import java.math.BigDecimal;
import java.util.List;

public interface JibunQueryService {
    Jibun getById(Long jibunId);

    List<JibunSearchResultDTO> findAddressesInUtmk(BigDecimal utmkX, BigDecimal utmkY, BigDecimal utmkXSpan, BigDecimal utmkYSpan);

    List<Jibun> findByLegalDongCodeAndJibunNumber(String legalDongCode, String jibunNumber);
}
