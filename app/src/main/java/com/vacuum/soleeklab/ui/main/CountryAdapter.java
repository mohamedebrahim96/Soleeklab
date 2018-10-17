package com.vacuum.soleeklab.ui.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.PictureDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.vacuum.soleeklab.R;
import com.vacuum.soleeklab.data.network.model.Country;
import com.vacuum.soleeklab.utils.SvgSoftwareLayerSetter;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private List<Country> countriesList;
    private Context mContext;
    private RequestBuilder<PictureDrawable> requestBuilder;

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        public TextView name, language, capital,currency;
        ImageView flag;


        public CountryViewHolder(View view) {
            super(view);
            name =  view.findViewById(R.id.name);
            capital =  view.findViewById(R.id.capital);
            language =  view.findViewById(R.id.language);
            currency =  view.findViewById(R.id.currency);
            flag =  view.findViewById(R.id.flag);

        }
    }


    public CountryAdapter(List<Country> countriesList,Context mContext) {
        this.countriesList = countriesList;
        this.mContext = mContext;
        requestBuilder = Glide.with(mContext)
                .as(PictureDrawable.class)
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());
    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_list, parent, false);

        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CountryViewHolder holder, int position) {
        Country c = countriesList.get(position);
        holder.name.setText(c.getName());
        holder.capital.setText("Capital:"+c.getCapital());
        holder.language.setText("Language:"+c.getLanguages().get(0).getName());
        holder.currency.setText("Currency:"+c.getCurrencies().get(0).getName());


        requestBuilder
                .load(c.getFlag())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.flag);


    }

    @Override
    public int getItemCount() {
        return countriesList.size();
    }
}