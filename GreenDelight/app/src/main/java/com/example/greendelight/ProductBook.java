import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ProductBook {
    String Name;
    String Seller;
    String Price;
    String Quanttity;
    String Descption;
    String imgData;

    public ProductBook(String Name,String Seller,String Price,String Quantity
    ,String Description,String imgData)
    {
        this.Name = Name;
        this.Seller = Seller;
        this.Price = Price;
        this.Quanttity = Quantity;
        this.Descption = Description;
        this.imgData = imgData;

    }

    public String getSeller() {
        return Seller;
    }

    public void setSeller(String seller) {
        Seller = seller;
    }

    public String getName()
    {
        return this.Name;
    }
    public Bitmap getImg()
    {
        byte[] decodedString = Base64.decode(this.imgData,Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString,0,decodedString.length);
        return bitmap;

    }

}
