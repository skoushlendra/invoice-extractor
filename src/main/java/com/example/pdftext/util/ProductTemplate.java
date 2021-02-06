package com.example.pdftext.util;

import com.example.pdftext.service.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTemplate {
    private final String PLANT_CSS_CLASS = "plant";
    /**
     * %s defines input for specific fields in below order
     * product categories class
     * product code
     * product name
     * mrp
     * discounted price
     * product code
     */
    private final String HTML_TEMPLATE = new String("" +
            "                <!-- ITEM -->\n" +
            "                <div class=\"item-isotope %s \">\n" +
            "                  <div class=\"wrap-box-1\">\n" +
            "                    <div class=\"box-img\">\n" +
            "                      <a href=\"\" title=\"\">\n" +
            "                      <img src=\"images/product/%s.jpg\" class=\"img-responsive\" alt=\"Product\" title=\"images products\"></a>\n" +
            "                      <div class=\"content-item\">\n" +
            "                        <h5 class=\"title-h5\"><a href=\"\" title=\"\">%s</a></h5>\n" +
            "                        <div class=\"bottom\">\n" +
            "                          <div class=\"text-left pull-left\">\n" +
            "                            <span class=\"old-price\"><del>&#8377;%s</del></span>\n" +
            "                            <span class=\"price\">&#8377;%s</span>\n" +
            "                          </div>\n" +
            "                          <div class=\"text-right\">\n" +
            "                            <span class=\"height\">%s</span>\n" +
            "                          </div>\n" +
            "                        </div>\n" +
            "                      </div>\n" +
            "                    </div>\n" +
            "                  </div>\n" +
            "                </div>\n" +
            "                <!-- END / ITEM -->\n\n").toString();

    public String getHtmlTemplateForProducts(List<Product> productList) {
        StringBuilder htmlCodeForProducts = new StringBuilder();

        productList.forEach(product -> {
            htmlCodeForProducts.append(String.format(HTML_TEMPLATE,
                    Optional.ofNullable(product.getProductCategoryCssClass()).orElse(PLANT_CSS_CLASS),
                    product.getProductCode(),
                    product.getProductName(),
                    product.getDiscountedPrice(),
                    product.getMarketPrice(),
                    product.getProductCode()
            ));
        });
        return htmlCodeForProducts.toString();
    }
}
