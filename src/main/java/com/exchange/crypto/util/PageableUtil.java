package com.exchange.crypto.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtil {
    public static Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size).withSort(Sort.Direction.ASC, "id");
    }
}
