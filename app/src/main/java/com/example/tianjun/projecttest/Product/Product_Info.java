package com.example.tianjun.projecttest.Product;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tianjun.projecttest.Bean.Product.Product_Info_GridLayout_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Info_Gson;
import com.example.tianjun.projecttest.Bean.Product.Product_Info_ReadMe_Gson;
import com.example.tianjun.projecttest.CustomerView.AlphaTitleScrollView;
import com.example.tianjun.projecttest.R;
import com.example.tianjun.projecttest.Util.HttpRequest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Product_Info extends AppCompatActivity {

    @BindView(R.id.title_viewpager)
    ViewPager mViewPager;
    @BindView(R.id.goods_english_name)
    TextView mGoods_english_name;
    @BindView(R.id.rank_price)
    TextView mRank_price;
    @BindView(R.id.shop_price)
    TextView mShop_price;
    @BindView(R.id.goods_brief)
    TextView mGoods_brief;

    @BindView(R.id.tags_icon_img1)
    ImageView mTags_icon_img1;
    @BindView(R.id.tag_name_tv1)
    TextView mTag_name_tv1;
    @BindView(R.id.tags_icon_img2)
    ImageView mTags_icon_img2;
    @BindView(R.id.tag_name_tv2)
    TextView mTag_name_tv2;

    @BindView(R.id.model_description)
    TextView mModel_description;
    @BindView(R.id.size_img)
    ImageView mSize_img;

    @BindView(R.id.model_description2)
    TextView mModel_description2;

    @BindView(R.id.product_snapshot_ll)
    LinearLayout mProduct_snapshot_ll;

    @BindView(R.id.logistics_ll)
    LinearLayout mLogistics_ll;

    @BindView(R.id.comment_info_list)
    LinearLayout mComment_lv;
    CircleImageView mCircleImageView;
    TextView mUser_name_tv;
    TextView mComment_info_tv;
    @BindView(R.id.comment_add_ll)
    LinearLayout mComment_add_ll;
    @BindView(R.id.comment_num)
    TextView mComment_num;

    @BindView(R.id.readme_content_ll)
    LinearLayout readme_content_ll;
    @BindView(R.id.readme_img1)
    ImageView readme_img1;
    @BindView(R.id.readme_img2)
    ImageView readme_img2;
    @BindView(R.id.readme_img3)
    ImageView readme_img3;

    @BindView(R.id.something_grid)
    GridLayout mSomething_grid;


    @BindView(R.id.bar)
    Toolbar toolbar;
    @BindView(R.id.scroll)
    AlphaTitleScrollView alphaTitleScrollView;

    private String goodId;
    private Context mContext;
    private Product_Info_Gson.InfoBean mInfo;
    private List<Product_Info_Gson.InfoBean.PropertiesBean> properties = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter;
    private Fragment[] fragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private List<Product_Info_ReadMe_Gson.InfoBean> readMeInfo;
    private Product_Info_GridLayout_Gson mBody;
    private int width;
    private int n;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.product__info);
        mContext = this;
        ButterKnife.bind(this);
        alphaTitleScrollView.setTitleAndHead(toolbar, mViewPager);
        toolbar.getBackground().setAlpha(0);
        initData();
    }

    private void initData() {
        goodId = getIntent().getStringExtra("goods_id");
        HttpRequest.getHttpService().openProductInfoGsonCall(goodId).enqueue(new Callback<Product_Info_Gson>() {
            @Override
            public void onResponse(Call<Product_Info_Gson> call, Response<Product_Info_Gson> response) {
                initFragment(response.body().getInfo());
                resultDatas(response.body().getInfo());
            }

            @Override
            public void onFailure(Call<Product_Info_Gson> call, Throwable t) {

            }
        });
        //读我部分信息读取
        HttpRequest.getHttpService().openProductInfoReadMeGsonCall(goodId).enqueue(new Callback<Product_Info_ReadMe_Gson>() {
            @Override
            public void onResponse(Call<Product_Info_ReadMe_Gson> call, Response<Product_Info_ReadMe_Gson> response) {
                readMeInfo = response.body().getInfo();
                resultReadMe();
            }

            @Override
            public void onFailure(Call<Product_Info_ReadMe_Gson> call, Throwable t) {

            }
        });
        //花心部分数据请求
        HttpRequest.getHttpService().openProductInfoGridLayoutGsonCall(goodId).enqueue(new Callback<Product_Info_GridLayout_Gson>() {

            @Override
            public void onResponse(Call<Product_Info_GridLayout_Gson> call, Response<Product_Info_GridLayout_Gson> response) {
                mBody = response.body();
                resultGridLayout();
            }

            @Override
            public void onFailure(Call<Product_Info_GridLayout_Gson> call, Throwable t) {

            }
        });
    }

    /**
     * 动态向GridLayout中添加view布局
     */
    private void resultGridLayout() {
        int numSize = mBody.getInfo().size();
        int numRow;
        int getNum = 0;
        //不能被3整除
        if ((numSize % 3 > 0) && (numSize % 3 < 3) && numSize != 0) {
            numRow = numSize / 3;
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < 3; j++) {
                    setGridLayout(getNum, i, j);
                    getNum++;
                }
            }
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < numSize % 3; j++) {
                    setGridLayout(getNum, i + numSize / 3, j);
                    getNum++;
                }
            }
        } else {
            numRow = numSize / 3;
            for (int i = 0; i < numRow; i++) {
                for (int j = 0; j < 3; j++) {
                    setGridLayout(getNum, i, j);
                    getNum++;
                }
            }
        }
    }

    private void setGridLayout(int getNum, int i, int j) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.product_info_gridlayout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.title_img);
        TextView price_tv = (TextView) view.findViewById(R.id.price_tv);
        TextView title_name_tv = (TextView) view.findViewById(R.id.title_name_tv);

        String goods_name = mBody.getInfo().get(getNum).getGoods_name();
        String shop_price = mBody.getInfo().get(getNum).getShop_price();
        String goods_thumb = mBody.getInfo().get(getNum).getGoods_thumb();

        WindowManager windowManager = getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int imageWidth = width / 3;
        int imageHeigth = width / 3;
        layoutParams.width = imageWidth;
        layoutParams.height = imageHeigth;
        imageView.setLayoutParams(layoutParams);
        Picasso.with(mContext).load(goods_thumb).into(imageView);

        price_tv.setText(shop_price);
        title_name_tv.setText(goods_name);
        GridLayout.Spec rowSpec = GridLayout.spec(i);     //设置它的行和列
        GridLayout.Spec columnSpec = GridLayout.spec(j);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
        params.setGravity(Gravity.LEFT);
        mSomething_grid.addView(view, params);

    }

    private void resultReadMe() {
        Picasso.with(mContext).load(readMeInfo.get(0).getTopic_img()).resize(720,360).into(readme_img1);
        Picasso.with(mContext).load(readMeInfo.get(1).getTopic_img()).resize(720,360).into(readme_img2);
        Picasso.with(mContext).load(readMeInfo.get(2).getTopic_img()).resize(720,360).into(readme_img3);
    }

    private void initFragment(Product_Info_Gson.InfoBean info) {
        fragment = new Fragment[3];
        fragmentManager = getSupportFragmentManager();
        fragment[0] = fragmentManager.findFragmentById(R.id.size_type_no);
        fragment[1] = fragmentManager.findFragmentById(R.id.size_type_yes);
        fragment[2] = fragmentManager.findFragmentById(R.id.comment_fra);

        fragmentTransaction = fragmentManager.beginTransaction().hide(fragment[0]).hide(fragment[1]).hide(fragment[2]);
        if (info.getSize_type().equals("0")) {
            fragmentTransaction.show(fragment[0]).show(fragment[2]).commit();
        } else {
            fragmentTransaction.show(fragment[1]).show(fragment[2]).commit();
        }
    }

    public void resultDatas(Product_Info_Gson.InfoBean info) {
        mInfo = info;
        properties = mInfo.getProperties();
        //标题栏部分内容数据
        setTitleInfo();
        //动态添加show_img图片
        setShow_img();

        WindowManager windowManager = getWindowManager();
        width = windowManager.getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = mViewPager.getLayoutParams();
        layoutParams.height = width;
        mViewPager.setLayoutParams(layoutParams);

        viewPagerAdapter = new ViewPagerAdapter();
        mViewPager.setAdapter(viewPagerAdapter);

        if (mInfo.getComments().size() != 0) {
            mComment_num.setText(mInfo.getComments().size() + "");
            for (int i = 0; i < mInfo.getComments().size(); i++) {
                View view = LayoutInflater.from(mContext).inflate(R.layout.product_info_comment_list, null);
                mCircleImageView = (CircleImageView) view.findViewById(R.id.profile_image);
                mUser_name_tv = (TextView) view.findViewById(R.id.user_name_tv);
                mComment_info_tv = (TextView) view.findViewById(R.id.comment_info_tv);

                mComment_info_tv.setText(mInfo.getComments().get(i).getContent());
                mUser_name_tv.setText(mInfo.getComments().get(i).getUser_name());
                String url = mInfo.getComments().get(i).getAvatar();
                Picasso.with(mContext).load(url).into(mCircleImageView);
                mComment_lv.addView(view);
            }
        }
    }

    /**
     * 标题栏部分内容数据
     */
    private void setTitleInfo() {
        String goods_english_name = mInfo.getGoods_english_name() + mInfo.getGoods_name();
        String shop_price = mInfo.getShop_price();
        String goods_brief = mInfo.getGoods_brief();
        mGoods_english_name.setText(goods_english_name);
        if (mInfo.getIs_promote() == 0) {
            mRank_price.setText(shop_price);
        } else if (mInfo.getIs_promote() == 1) {
            mRank_price.setText(mInfo.getPromote_price());
            mShop_price.setText(shop_price);
        }
        mGoods_brief.setText(goods_brief);
        String model_description = mInfo.getModel_description();
        mModel_description.setText(model_description);
        mModel_description2.setText(model_description);

        //动态添加物流信息
        if (mInfo.getGoods_information() != "") {
            TextView textView = new TextView(mContext);
            textView.setText("物流");
            textView.setPadding(20, 20, 20, 0);
            mLogistics_ll.addView(textView);

            LinearLayout linearLayout = new LinearLayout(mContext);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            mLogistics_ll.addView(linearLayout);

            TextView textView1 = new TextView(mContext);
            TextView textView2 = new TextView(mContext);

            textView1.setText(mInfo.getGoods_information());
            textView1.setTextColor(getResources().getColor(R.color.colorTheme));
            textView1.setPadding(0, 20, 20, 0);
            linearLayout.addView(textView1);

            textView2.setText(mInfo.getGoods_tip());
            textView2.setPadding(0, 0, 10, 10);
            linearLayout.addView(textView2);
        }
        //动态添加尺码图片
        String size_type = mInfo.getSize_type();
        switch (size_type) {
            case "1":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "2":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "3":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "4":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "5":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "6":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "7":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "8":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
            case "9":
                mSize_img.setImageResource(R.drawable.sizecode_1);
                break;
        }

        List<Product_Info_Gson.InfoBean.TagsIconBean> tags_icon = mInfo.getTags_icon();
        String icon1 = tags_icon.get(0).getIcon();
        Picasso.with(mContext).load(icon1).into(mTags_icon_img1);
        String tag_name1 = tags_icon.get(0).getTag_name();
        mTag_name_tv1.setText(tag_name1);
        String icon2 = tags_icon.get(1).getIcon();
        Picasso.with(mContext).load(icon2).into(mTags_icon_img2);
        String tag_name2 = tags_icon.get(1).getTag_name();
        mTag_name_tv2.setText(tag_name2);
    }

    /**
     * 动态添加show_img图片
     */
    public void setShow_img() {
        List<String> show_img = mInfo.getShow_img();
        List<String> show_img_size = mInfo.getShow_img_size();

        for (int i = 0; i < show_img.size(); i++) {
            ImageView imageView = new ImageView(mContext);
            WindowManager windowManager = this.getWindowManager();
            int width = windowManager.getDefaultDisplay().getWidth();
            String s = show_img_size.get(i);
            imageView.setLayoutParams(setImageHeigth(imageView, s, width));
            Picasso.with(mContext).load(show_img.get(i)).resize(360,n/2).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(15, 15, 15, 0);
            mProduct_snapshot_ll.addView(imageView);
        }
    }

    /**
     * 计算图片的高度
     *
     * @param imageView
     * @param s
     * @param width
     * @return
     */
    public LinearLayout.LayoutParams setImageHeigth(ImageView imageView, String s, int width) {
        String sWidth = getWidth(s);
        String sHeigth = getHeigth(s);
        float widthNum = Float.parseFloat(sWidth);
        float heigthNum = Float.parseFloat(sHeigth);
        float num = width / widthNum;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, 0);
        n = (int) (heigthNum * num);
        layoutParams.height = (int) (heigthNum * num);
        return layoutParams;
    }

    public String getWidth(String s) {
        return s.substring(0, s.lastIndexOf("x"));
    }

    public String getHeigth(String s) {
        return s.substring(s.lastIndexOf("x") + 1);
    }


    /**
     * 头部viewpager的
     */
    class ViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return properties.get(0).getAlbums() == null ? 0 : properties.get(0).getAlbums().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_info_viewpager, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.viewpager_img);
            String url = properties.get(0).getAlbums().get(position).getImg_url();

            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = width;
            imageView.setLayoutParams(layoutParams);

            Picasso.with(mContext).load(url).into(imageView);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
