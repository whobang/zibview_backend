package com.view.zib.domain.post.service;

import com.view.zib.domain.client.kako.domain.KakaoAddressResponse;
import com.view.zib.domain.post.controller.request.PostRequest;

public interface PostCommandService {

    Long create(PostRequest.Save request, KakaoAddressResponse kakaoAddressResponse);
}
