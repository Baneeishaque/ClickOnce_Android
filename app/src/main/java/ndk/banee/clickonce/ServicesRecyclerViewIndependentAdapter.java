package ndk.banee.clickonce;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ndk.banee.clickonce.ServiceList.ServiceItem;

public class ServicesRecyclerViewIndependentAdapter extends RecyclerView.Adapter<ServicesRecyclerViewIndependentAdapter.ViewHolder> {

    private final List<ServiceItem> serviceList;
    private final int height;
    private final int width;

    ServicesRecyclerViewIndependentAdapter(List<ServiceItem> serviceList, int height, int width) {

        this.serviceList = serviceList;
        this.height = height;
        this.width = width;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mItem = serviceList.get(position);

        holder.buttonService.setText(serviceList.get(position).name);
        holder.buttonService.setHeight(height);
        holder.buttonService.setWidth(width);

        holder.listItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return serviceList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final View listItem;
        final Button buttonService;
        ServiceItem mItem;

        ViewHolder(View view) {

            super(view);
            listItem = view;
            buttonService = view.findViewById(R.id.buttonService);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + buttonService.getText() + "'";
        }
    }
}
