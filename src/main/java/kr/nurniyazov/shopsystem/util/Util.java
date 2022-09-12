package kr.nurniyazov.shopsystem.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

@UtilityClass
public class Util {

    public static final String TOTAL_PAGES = "totalPages";
    public static final String PAGE = "page";
    public static final String SIZE = "size";

    public static void generateModel(Model model, String attribute, Page<?> pageObjects, int page, int size) {
        model.addAttribute(attribute, pageObjects.getContent());
        model.addAttribute(TOTAL_PAGES, pageObjects.getTotalPages());
        model.addAttribute(PAGE, page);
        model.addAttribute(SIZE, size);
    }

}
