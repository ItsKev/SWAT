package ch.hslu.edu.enapp.webshop.services;

import ch.hslu.edu.enapp.webshop.dto.Product;
import ch.hslu.edu.enapp.webshop.msdynnav.generated.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class ItemServices implements ItemServicesLocal {

    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    private void loadProducts() {
        final URL wsdl;
        try {
            wsdl = new URL("http://enapp-was-global02.el.eee.intern:7047/DynamicsNAVTest/WS/iCompany%20HSLU%20T%26A/Page/Item");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        final QName itemPageQName = new QName("urn:microsoft-dynamics-schemas/page/item", "Item_Service");
        Authenticator.setDefault(new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("ICOMPANY" + "\\" + "icDynNAVWsStudentSvc", "ic0mp@ny".toCharArray());
            }
        });

        final ItemService itemService = new ItemService(wsdl, itemPageQName);
        final ItemPort itemPort = itemService.getItemPort();

        final List<ItemFilter> filterList = new ArrayList<ItemFilter>();
        final ItemFilter filter = new ItemFilter();
        filter.setField(ItemFields.PRODUCT_GROUP_CODE);
        filter.setCriteria("MP3");
        filterList.add(filter);

        final ItemList itemList = itemPort.readMultiple(filterList, null, 0);

        addProductsToList(itemList);
    }

    private void addProductsToList(ItemList itemList) {
        for (final Item item : itemList.getItem()) {
            Product product = new Product();
            product.setArticleNumber(item.getNo());

            String description = item.getDescription();
            String[] splittedString = description.split("-");
            if (splittedString.length > 1) {
                product.setName(splittedString[0]);
                if (splittedString.length > 2) {
                    product.setDescription(splittedString[2] +
                            " (" + splittedString[1].replaceAll("\\s+", "") + ")");
                } else {
                    product.setDescription(splittedString[1]);
                }
            } else {
                splittedString = description.split("\\(");
                product.setDescription(splittedString[0]);
                if (splittedString.length > 1) {
                    product.setName(splittedString[1].split("\\)")[0]);
                } else {
                    product.setName("Unknown Artist");
                }
            }
            product.setUnitprice(item.getUnitPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN));
            product.setMediapath(item.getMediafileName());
            products.add(product);
        }
    }
}
