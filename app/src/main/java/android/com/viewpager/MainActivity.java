package android.com.viewpager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        TestPagerAdapter adapter = new TestPagerAdapter();
        Drawable drawable1 = getResources().getDrawable(R.drawable.num_one);
        Drawable drawable2 = getResources().getDrawable(R.drawable.num_two);
        Drawable drawable3 = getResources().getDrawable(R.drawable.num_three);

//        ImageView iv1 = (ImageView) View.inflate(this, R.layout.layout_iv, null).findViewById(R.id.iv);
//        ImageView iv2 = (ImageView) View.inflate(this, R.layout.layout_iv, null).findViewById(R.id.iv);
//        ImageView iv3 = (ImageView) View.inflate(this, R.layout.layout_iv, null).findViewById(R.id.iv);
        ImageView iv1 = new ImageView(this);
        ImageView iv2 = new ImageView(this);
        ImageView iv3 = new ImageView(this);

        iv1.setImageDrawable(drawable1);
        iv2.setImageDrawable(drawable2);
        iv3.setImageDrawable(drawable3);

        ArrayList<ImageView> imageViews = new ArrayList();
        imageViews.add(iv1);
        imageViews.add(iv2);
        imageViews.add(iv3);
        adapter.setData(imageViews);

        viewPager.setAdapter(adapter);
    }

    class TestPagerAdapter extends PagerAdapter {

        private ArrayList<ImageView> mArrayList = new ArrayList();

        public void setData(ArrayList<ImageView> imageViews) {
            mArrayList = imageViews;
        }
        @Override
        public int getCount() {
            return mArrayList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view ==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ImageView imageView = mArrayList.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mArrayList.get(position));
        }

        @Override
        public float getPageWidth(int position) {
            return 0.8f;
        }
    }
}
