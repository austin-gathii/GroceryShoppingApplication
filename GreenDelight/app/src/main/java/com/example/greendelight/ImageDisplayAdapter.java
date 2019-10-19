import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.greendelight.R;

import java.util.ArrayList;

public class ImageDisplayAdapter extends ArrayAdapter<ProductBook> {

    Context context;
    public ImageDisplayAdapter(Context context, int resource, ArrayList<ProductBook> books)
    {
        super(context,resource,books);
        this.context = context;
    }

    @Override
    public View getView(int position, View cell, ViewGroup parent)
    {
        Holder holder;

        if (cell == null)
        {
            holder = new Holder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cell = inflater.inflate(R.layout.list_item,null);

            holder.imageView = (ImageView)cell.findViewById(R.id.imageView2);
            holder.textView = (TextView)cell.findViewById(R.id.textView4);
            holder.textView2 = (TextView)cell.findViewById(R.id.textView5);

            cell.setTag(holder);

        }
        else
        {
            holder = (Holder)cell.getTag();
        }

        ProductBook book  = getItem(position);

        holder.textView.setText(book.getName());
        holder.textView2.setText(book.getSeller());
        holder.imageView.setImageBitmap(book.getImg());


        return cell;
    }
}

class Holder{

    ImageView imageView;
    TextView textView;
    TextView textView2;

}
