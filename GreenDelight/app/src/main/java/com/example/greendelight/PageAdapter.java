import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class PageAdapter extends FragmentPagerAdapter {
    private int numoftabs;
    public PageAdapter(FragmentManager fm,int numoftabs) {

        super(fm);
        this.numoftabs = numoftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            /*case 0:
                return new newOrders();
            case 1:
                return new ordersInProgress();
            case 2:
                return new orderHistory();
            default:
                return null;*/


        }
        return null;





    }

    @Override
    public int getCount() {
        return numoftabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
