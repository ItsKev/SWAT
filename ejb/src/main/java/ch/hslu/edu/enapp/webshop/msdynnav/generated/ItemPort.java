package ch.hslu.edu.enapp.webshop.msdynnav.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2018-11-29T10:17:58.241+01:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "urn:microsoft-dynamics-schemas/page/item", name = "Item_Port")
@XmlSeeAlso({ObjectFactory.class})
public interface ItemPort {

    @WebMethod(operationName = "Update", action = "urn:microsoft-dynamics-schemas/page/item:Update")
    @RequestWrapper(localName = "Update", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.Update")
    @ResponseWrapper(localName = "Update_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.UpdateResult")
    public void update(
        @WebParam(mode = WebParam.Mode.INOUT, name = "Item", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        javax.xml.ws.Holder<Item> item
    );

    @WebMethod(operationName = "IsUpdated", action = "urn:microsoft-dynamics-schemas/page/item:IsUpdated")
    @RequestWrapper(localName = "IsUpdated", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.IsUpdated")
    @ResponseWrapper(localName = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.IsUpdatedResult")
    @WebResult(name = "IsUpdated_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
    public boolean isUpdated(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        java.lang.String key
    );

    @WebMethod(operationName = "Create", action = "urn:microsoft-dynamics-schemas/page/item:Create")
    @RequestWrapper(localName = "Create", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.Create")
    @ResponseWrapper(localName = "Create_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.CreateResult")
    public void create(
        @WebParam(mode = WebParam.Mode.INOUT, name = "Item", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        javax.xml.ws.Holder<Item> item
    );

    @WebMethod(operationName = "ReadMultiple", action = "urn:microsoft-dynamics-schemas/page/item:ReadMultiple")
    @RequestWrapper(localName = "ReadMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.ReadMultiple")
    @ResponseWrapper(localName = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.ReadMultipleResult")
    @WebResult(name = "ReadMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
    public ch.hslu.edu.enapp.webshop.msdynnav.generated.ItemList readMultiple(
        @WebParam(name = "filter", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        java.util.List<ch.hslu.edu.enapp.webshop.msdynnav.generated.ItemFilter> filter,
        @WebParam(name = "bookmarkKey", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        java.lang.String bookmarkKey,
        @WebParam(name = "setSize", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        int setSize
    );

    @WebMethod(operationName = "UpdateMultiple", action = "urn:microsoft-dynamics-schemas/page/item:UpdateMultiple")
    @RequestWrapper(localName = "UpdateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.UpdateMultiple")
    @ResponseWrapper(localName = "UpdateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.UpdateMultipleResult")
    public void updateMultiple(
        @WebParam(mode = WebParam.Mode.INOUT, name = "Item_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        javax.xml.ws.Holder<ItemList> itemList
    );

    @WebMethod(operationName = "Read", action = "urn:microsoft-dynamics-schemas/page/item:Read")
    @RequestWrapper(localName = "Read", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.Read")
    @ResponseWrapper(localName = "Read_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.ReadResult")
    @WebResult(name = "Item", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
    public ch.hslu.edu.enapp.webshop.msdynnav.generated.Item read(
        @WebParam(name = "No", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        java.lang.String no
    );

    @WebMethod(operationName = "CreateMultiple", action = "urn:microsoft-dynamics-schemas/page/item:CreateMultiple")
    @RequestWrapper(localName = "CreateMultiple", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.CreateMultiple")
    @ResponseWrapper(localName = "CreateMultiple_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.CreateMultipleResult")
    public void createMultiple(
        @WebParam(mode = WebParam.Mode.INOUT, name = "Item_List", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        javax.xml.ws.Holder<ItemList> itemList
    );

    @WebMethod(operationName = "Delete", action = "urn:microsoft-dynamics-schemas/page/item:Delete")
    @RequestWrapper(localName = "Delete", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.Delete")
    @ResponseWrapper(localName = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item", className = "ch.hslu.edu.enapp.webshop.msdynnav.generated.DeleteResult")
    @WebResult(name = "Delete_Result", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
    public boolean delete(
        @WebParam(name = "Key", targetNamespace = "urn:microsoft-dynamics-schemas/page/item")
        java.lang.String key
    );
}
