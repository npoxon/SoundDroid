package uk.co.peartree_productions.sounddroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import uk.co.peartree_productions.sounddroid.soundcloud.Track;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView titleTextView;
        private final ImageView thumbImageView;

        ViewHolder(View v){
            super(v);
            titleTextView = (TextView)v.findViewById(R.id.track_title);
            thumbImageView = (ImageView)v.findViewById(R.id.track_thumbnail);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null){
                mOnItemClickListener.onItemClick(null,v,getPosition(),0);
            }
        }
    }

    private List<Track> mTracks;
    private Context mContext;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    TracksAdapter(Context context, List<Track> tracks){
        mContext = context;
        mTracks = tracks;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.track_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Track track = mTracks.get(position);
        holder.titleTextView.setText(track.getTitle());
        Picasso.with(mContext).load(track.getAvatarURL()).into(holder.thumbImageView);
    }

}
